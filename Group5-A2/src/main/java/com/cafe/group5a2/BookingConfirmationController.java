package com.cafe.group5a2;

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
    public Button homeButton;
    @FXML
    public Button QuitButton;

    @FXML
    public void onProfileButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) ProfileButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("customer-view.fxml"));
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public void onHomeButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) homeButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("home-view.fxml"));
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    @FXML
    public void onQuitButtonClick(ActionEvent event) {
        Stage stage = (Stage) QuitButton.getScene().getWindow();
        stage.close();
    }
}
