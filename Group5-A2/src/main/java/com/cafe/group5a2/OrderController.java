package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class OrderController {

    @FXML
    public Button ConfirmOrderButton;

    @FXML
    public void onConfirmOrderButtonClick(ActionEvent event) throws IOException {

        Stage stage = (Stage) ConfirmOrderButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("order-confirmed-view.fxml")));
        stage.setTitle("Customer");
        stage.getScene().setRoot(newRoot);
    }


}
