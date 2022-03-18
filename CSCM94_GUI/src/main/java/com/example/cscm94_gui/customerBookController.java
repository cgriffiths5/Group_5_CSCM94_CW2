package com.example.cscm94_gui;

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
    public void onConfirmBookingClick(ActionEvent event) throws IOException {

        Stage stage = (Stage) ConfirmBookingButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("booking-confirmation.fxml"));
        stage.setTitle("Customer");
        stage.getScene().setRoot(newRoot);
    }
}
