package com.example.cscm94_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StaffLoginController {

    @FXML
    public Button EnterButton;

    @FXML
    public void onEnterButtonClick(ActionEvent event)  {
        try {
            Stage stage = (Stage) EnterButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("staffHome.fxml"));
            stage.setTitle("Customer Profile");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }
}
