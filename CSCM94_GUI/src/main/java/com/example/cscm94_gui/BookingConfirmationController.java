package com.example.cscm94_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BookingConfirmationController {

    @FXML
    public Button ProfileButton;

    @FXML
    public void onProfileButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ProfileButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("customer-view.fxml"));
        stage.getScene().setRoot(newRoot);
    }

    @FXML
    public Button homeButton;

    @FXML
    public void onHomeButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) homeButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        stage.getScene().setRoot(newRoot);
    }

    @FXML
    public Button QuitButton;

    @FXML
    public void onQuitButtonClick(ActionEvent event) {
        Stage stage = (Stage) QuitButton.getScene().getWindow();
        stage.close();
    }
}
