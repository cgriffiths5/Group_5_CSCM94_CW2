package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
 * This class is the home page of the manager
 *
 * @author Chris Griffiths
 * @version 1.6
 */
public class ManagerController {

    @FXML
    public Button homeButton;
    public Button generateReports;
    public Button addRemoveStaff;
    public String username;
    public Label userLabel;
    //Database connection
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    public ManagerController() throws SQLException {
    }

    /**
     * This method sets the users name
     *
     * @param text is the name parameter
     */
    public void setUserText(String text) {
        username = text;
        userLabel.setText(text);
    }

    /**
     * When the generate reports button is pressed the generate reports page is
     * loaded
     */
    @FXML
    public void onClickGenReports() {
        try {
            Stage stage = (Stage) generateReports.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("reports-view.fxml"));
            Parent newRoot = loader.load();
            ReportsController RCont = loader.getController();
            RCont.setUserText(username);
            RCont.generate();
            stage.setTitle("Reports");
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(550.0);
            stage.setMaxWidth(550.0);
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The add staff page is returned
     *
     * @param event is triggered when the add staff button is pressed
     */
    @FXML
    public void onAddRemoveStaffClick(ActionEvent event) {
        try {
            Stage stage = (Stage) addRemoveStaff.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addStaff-view.fxml"));
            Parent newRoot = loader.load();
            ManageStaffController mSCont = loader.getController();
            mSCont.setUser(username);

            stage.setTitle("Manage Staff");
            stage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The home page is returned when the user pressed the home button
     *
     * @param event is entered when a user presses the home button
     */
    @FXML
    public void onHomeButtonClick(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}