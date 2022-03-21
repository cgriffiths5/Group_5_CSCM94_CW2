package com.example.cscm94_gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

import java.io.IOException;

public class LoginController {
    @FXML
    public Button EnterButton;

    @FXML
    public void onEnterButtonClick(ActionEvent event)  {
        try {
            Stage stage = (Stage) EnterButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("customer-view.fxml"));
            stage.setTitle("Customer Profile");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public Button GuestButton;

    @FXML
    public void onGuestButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) GuestButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("customer-view.fxml"));
            stage.setTitle("Guest Profile");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public Button StaffLoginButton;

    @FXML
    public void onStaffLoginButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) StaffLoginButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("staffHome-view.fxml"));
            stage.setTitle("Staff Home");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public Button RegisterButton;

    @FXML
    public void onRegisterButtonClick(ActionEvent event)  {
        try {
            Stage stage = (Stage) RegisterButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("register-view.fxml"));
            stage.setTitle("Register");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

}
