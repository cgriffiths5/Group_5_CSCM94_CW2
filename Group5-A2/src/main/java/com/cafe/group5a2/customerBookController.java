package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class customerBookController {

    @FXML
    public Button ConfirmBookingButton;

    @FXML
    public void onConfirmBookingClick(ActionEvent event) {
        try {
            Stage stage = (Stage) ConfirmBookingButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("booking-confirmation.fxml"));
            stage.setTitle("Customer");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }
}
