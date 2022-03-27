package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenu-view.fxml"));
            Parent newRoot = loader.load();

            CustMenuController cMCont = loader.getController();
            cMCont.setItemLabels();
            cMCont.setPriceLabels();
            cMCont.setDescLabels();
            cMCont.setUserText(username);
            Rectangle2D sBound = Screen.getPrimary().getVisualBounds();
            //stage.setX(((sBound.getWidth() - stage.getWidth())/2) - (sBound.getWidth() / 10));
            //stage.setY(((sBound.getHeight() - stage.getWidth())/2) - (sBound.getHeight() / 3));
            stage.centerOnScreen();
            stage.setTitle("Order");
            stage.setHeight(992.0);
            stage.setMaxHeight(2032.0);
            stage.setWidth(744.0);
            stage.setMaxWidth(744.0);
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onBookButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) bookButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customer-booking.fxml"));
            Parent newRoot = loader.load();

            CustBookingController cMCont = loader.getController();
            cMCont.setUserText(username);
            stage.setTitle("Reservation");
            Rectangle2D sBound = Screen.getPrimary().getVisualBounds();
            //stage.setX(((sBound.getWidth() - stage.getWidth())/2) - (sBound.getWidth() / 10));
            //stage.setY(((sBound.getHeight() - stage.getWidth())/2) - (sBound.getHeight() / 3));
            stage.centerOnScreen();
            stage.setHeight(800.0);
            stage.setMaxHeight(1113.0);
            stage.setWidth(658.0);
            stage.setMaxWidth(658.0);
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
