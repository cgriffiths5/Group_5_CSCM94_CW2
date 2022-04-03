package com.cafe.group5a2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class AddStaffController {

    @FXML
    public Button ManagerHomeReturn;
    public Button AddStaffButton;
    public Button ViewStaffButton;
    public Button DeleteStaffButton;



    ObservableList<String> staffList = FXCollections.observableArrayList();

    //Database connection
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    public AddStaffController() throws SQLException {
    }

    @FXML
    public void onAddStaffButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) AddStaffButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addNewStaff-view.fxml")));

            stage.setTitle("Manager");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
            e.printStackTrace();
        }

    }

    @FXML
    public void onViewStaffButtonClick() throws SQLException {



        String query = "SELECT * FROM users WHERE role = 'manager' OR role = 'waiter' OR role = 'chef' OR role = 'driver';";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            while(rs.next()) {

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

    @FXML
    public void onManagerHomeReturnClick(ActionEvent event) {
        try {
            Stage stage = (Stage) ManagerHomeReturn.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("manager-view.fxml")));

            stage.setTitle("Manager");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    public void onDeleteStaffMember(ActionEvent event) {
        try {
            Stage stage = (Stage) DeleteStaffButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deleteStaff-view.fxml")));

            stage.setTitle("Delete Staff Member");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
            e.printStackTrace();
        }

    }
}
