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

public class OrderController {

    @FXML
    public Button loginButton;

    @FXML
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("log-in.fxml"));
        stage.setTitle("Log in");
        stage.getScene().setRoot(newRoot);
    }

    @FXML
    public Button homeButton;

    @FXML
    public void onHomeButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) homeButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.getScene().setRoot(newRoot);
    }

    @FXML
    public Button quitButton;

    @FXML
    public void onQuitButtonClick(ActionEvent event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }
}
