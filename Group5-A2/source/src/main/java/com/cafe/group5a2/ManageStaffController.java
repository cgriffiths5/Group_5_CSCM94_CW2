package com.cafe.group5a2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

/**
 * This class represents a homepage for adding, viewing and deleting staff
 *
 * @author Chris Griffiths
 * @version 1.6
 */
public class ManageStaffController {

    @FXML
    public Button ManagerHomeReturn;
    public Button AddStaffButton;
    public Button ViewStaffButton;
    public Button DeleteStaffButton;
    private String username;


    ObservableList<String> staffList = FXCollections.observableArrayList();

    //Database connection
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    public ManageStaffController() throws SQLException {
    }

    /**
     * Returns void.
     * Sets the name of the user using the application
     *
     * @param text The username
     */
    public void setUser(String text) {
        username = text;
    }

    /**
     * This method brings up the add staff registration form
     *
     * @param event is triggered by pressing the add staff button
     */
    @FXML
    public void onAddStaffButtonClick(ActionEvent event) {

        try {
            Stage stage = (Stage) AddStaffButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addNewStaff-view.fxml"));
            Parent newRoot = loader.load();
            AddNewStaffController mSCont = loader.getController();
            mSCont.setUser(username);
            stage.setTitle("New Staff");
            stage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            System.out.println("Error loading page");
        }

    }

    /**
     * This method brings up the list of current employed staff
     *
     * @throws SQLException handles query error
     */
    @FXML
    public void onViewStaffButtonClick() throws SQLException {


        String query = "SELECT * FROM users WHERE role = 'manager' OR role = 'waiter' OR role = 'chef' OR role = 'driver';";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            while (rs.next()) {

                staffList.add("First name: " + rs.getString("f_name") +
                        " Last Name: " + rs.getString("l_name") + " Role: " + rs.getString("role") + "\n");

            }


            ObservableList<String> staffList1 = staffList;

            Stage secondStage = new Stage();
            secondStage.setTitle("Staff List");

            final ListView staffListView = new ListView(staffList1);
            staffListView.setPrefSize(400, 500);

            staffListView.setItems(staffList1);

            StackPane root = new StackPane();
            root.getChildren().add(staffListView);
            secondStage.setScene(new Scene(root, 400, 500));
            secondStage.show();


        } catch (SQLException e) {
            System.out.println("Error Detected");
            e.printStackTrace();
        }

    }

    /**
     * This method returns the manager home page
     *
     * @param event is triggered when the manager home button is pressed
     */
    @FXML
    public void onManagerHomeReturnClick(ActionEvent event) {
        try {
            Stage stage = (Stage) ManagerHomeReturn.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("manager-view.fxml"));
            Parent newRoot = loader.load();
            ManagerController mCont = loader.getController();
            Rectangle2D sBound = Screen.getPrimary().getVisualBounds();
            mCont.setUserText(username);
            stage.setY(sBound.getHeight() - (sBound.getHeight() / 1.25));
            stage.setX(sBound.getWidth() - (sBound.getWidth() / 1.25));
            stage.setTitle("Manager");
            stage.setHeight(450);
            stage.setWidth(450);
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * This method returns the delete staff page
     *
     * @param event is triggered when the delete staff button is pressed
     */
    public void onDeleteStaffMember(ActionEvent event) {
        try {
            Stage stage = (Stage) DeleteStaffButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteStaff-view.fxml"));
            Parent newRoot = loader.load();
            DeleteStaffController dCont = loader.getController();
            dCont.setUser(username);
            stage.setTitle("Delete Staff Member");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
            e.printStackTrace();
        }

    }
}
