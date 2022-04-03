package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

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
            stage.setY(0);
            stage.setTitle("Order");
            stage.setHeight(sBound.getHeight());
            //stage.setMaximized(true);
            stage.setMaxHeight(3640.0);
            stage.setWidth(810.0);
            stage.setMaxWidth(810.0);
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

            CustBookingController cBCont = loader.getController();
            cBCont.setUserText(username);
            stage.setTitle("Reservation");
            stage.setHeight(1000.0);
            stage.setMaxHeight(1113.0);
            stage.setWidth(658.0);
            stage.setMaxWidth(658.0);
            stage.centerOnScreen();
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public void onViewOrdersButtonClick(ActionEvent event) {
        try {
            Stage stage = (Stage) viewOrders.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customer-order-history.fxml"));
            Parent newRoot = loader.load();

            CustomerOrderHistoryController cOHCont = loader.getController();
            cOHCont.setUser(username);
            cOHCont.setOrderID();
            stage.setTitle("View Order History");
            stage.setHeight(969.0);
            stage.setMaxHeight(969.0);
            stage.setWidth(440.0);
            stage.setMaxWidth(440.0);
            stage.centerOnScreen();
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    @FXML
    public void onHomeButtonClick(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
