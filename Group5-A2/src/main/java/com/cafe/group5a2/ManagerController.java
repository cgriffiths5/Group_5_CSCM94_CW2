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

    public void setUserText(String text) {
        username = text;
        userLabel.setText(text);
    }

    @FXML
    public void onClickGenReports() {
        try {
            Stage stage = (Stage) generateReports.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("reports-view.fxml"));
            Parent newRoot = loader.load();
            ReportsController RCont = loader.getController();
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


    @FXML
    public void onAddRemoveStaffClick(ActionEvent event) {
        try {
            Stage stage = (Stage) addRemoveStaff.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addStaff-view.fxml")));
            stage.setTitle("Manage Staff");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * @param event is entered when a user presses the home button
     */
    @FXML
    public void onHomeButtonClick(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}