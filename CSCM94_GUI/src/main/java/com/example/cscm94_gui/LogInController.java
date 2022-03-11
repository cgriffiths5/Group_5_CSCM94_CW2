package com.example.cscm94_gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

import java.io.IOException;

public class LoginController {
    @FXML
    public Button EnterButton;

    @FXML
    public void onEnterButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) EnterButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("order-view.fxml"));
        stage.setTitle("Customer Profile");
        stage.getScene().setRoot(newRoot);
    }


}
