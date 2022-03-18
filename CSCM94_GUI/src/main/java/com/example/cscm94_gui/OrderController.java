package com.example.cscm94_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderController {

    @FXML
    public Button ConfirmOrderButton;

    public void onConfirmOrderButtonClick(ActionEvent event) throws IOException {

        Stage stage = (Stage) ConfirmOrderButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("order-confirmed-view.fxml"));
        stage.setTitle("Customer");
        stage.getScene().setRoot(newRoot);
    }




}
