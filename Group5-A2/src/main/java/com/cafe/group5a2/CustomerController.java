package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CustomerController {

    private String username;
    @FXML
    public Button bookButton;
    public Button homeButton;
    public Button quitButton;
    public Button viewMenu;
    public Label loginButtonLabel;
    public Label bookButtonLabel;
    public Button viewOrders;
    public Label homeButtonLabel;
    public Label buttonText;
    public Label Subtitle;
    public Label Title;
    public Label userLabel;
    public Label passLabel;


    public void setUserText(String text) {
        username = text;
        userLabel.setText(text);
    }



    @FXML
    public void onViewMenuButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) viewMenu.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu-view.fxml")));
            stage.setTitle("Order");
            stage.getScene().setRoot(newRoot);
            stage.setHeight(820);
            stage.setWidth(640);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public void onBookButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) bookButton.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("customer-booking.fxml")));
            stage.setTitle("Booking");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public void onViewOrdersButtonClick(ActionEvent event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onHomeButtonClick(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }



}
