package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    public TextField FirstNameField;
    public TextField LastNameField;
    public TextField UsernameField;
    public TextField PasswordField;

    @FXML
    public Button RegisterConfirmButton;

    @FXML
    public void Register(ActionEvent event) {

        if (FirstNameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error Message:");
            alert.setContentText("Please enter a valid first name");

            alert.showAndWait();

        } else if (LastNameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error Message:");
            alert.setContentText("Please enter a valid last name");

            alert.showAndWait();

        } else if (UsernameField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error Message:");
            alert.setContentText("Please enter a valid user name");

            alert.showAndWait();
        } else if (PasswordField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error Message:");
            alert.setContentText("Please enter a valid password");

        }


    }


}


