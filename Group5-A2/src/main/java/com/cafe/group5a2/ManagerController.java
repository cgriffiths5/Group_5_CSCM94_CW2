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
import java.util.Objects;

public class ManagerController {

    @FXML
    public Button homeButton;
    public Button generateReports;
    public Button addRemoveStaff;
    public String username;
    public Label userLabel;

    public void setUserText(String text) {
        username = text;
        userLabel.setText(text);
    }



    @FXML
    public void onGenerateReportsClick(ActionEvent event) {
        try {
            Stage stage = (Stage) generateReports.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("generateReports-view.fxml")));
            stage.setTitle("Generate Reports");
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
            stage.setTitle("Add and Remove Staff");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     *
     * @param event is entered when a user presses the home button
     *
     */
    @FXML
    public void onHomeButtonClick(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}
