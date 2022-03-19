package com.example.cscm94_gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

import java.io.IOException;

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
        
        if(FirstNameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error Message:");
            alert.setContentText("Please enter a valid first name");

            alert.showAndWait();

        } else if(LastNameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error Message:");
            alert.setContentText("Please enter a valid last name");

            alert.showAndWait();

        } else if(UsernameField.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error Message:");
                alert.setContentText("Please enter a valid user name");

                alert.showAndWait();
        } else if(PasswordField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error Message:");
            alert.setContentText("Please enter a valid password");

        }


    }


}


