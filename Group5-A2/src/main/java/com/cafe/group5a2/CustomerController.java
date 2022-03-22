package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerController {

    @FXML
    public Button loginButton;
    @FXML
    public Button bookButton;
    @FXML
    public Button homeButton;
    @FXML
    public Button quitButton;

    @FXML
    public void onLoginButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("order-view.fxml"));
            stage.setTitle("Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public void onBookButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) bookButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("customer-book.fxml"));
            stage.setTitle("Booking");
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
            System.out.println("Error loading page");
        }
    }

    @FXML
    public void onQuitButtonClick(ActionEvent event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }
}
