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
    public Button StaffEnterButton;

    @FXML
    public void onStaffEnterButtonClick(ActionEvent event)  {
        try {
            Stage stage = (Stage) StaffEnterButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("staffHome-view.fxml"));
            stage.setTitle("Staff");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }
}
