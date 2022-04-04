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

/**
 * @author Adam Tucker
 * This controller represents a view for the Customer Homepage
 */
public class CustomerController {

    @FXML
    public Button bookButton;
    public Button homeButton;
    public Button viewMenu;
    public Button viewOrders;
    public Label Title;
    public Label userLabel;
    private String username;

    /**
     * Set label username as text
     *
     * @param text username
     */
    public void setUserText(String text) {
        username = text;
        userLabel.setText(text);
    }

    /**
     * The Menu page is brought up when the user presses the Menu button
     *
     * @param event is entered when a user presses the Menu button
     */
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

    /**
     * The Customer Booking Page is brought up when the user presses the Customer Booking button
     *
     * @param event is entered when a user presses the Customer Booking button
     */
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

    /**
     * The View Orders Page is brought up when the user presses the View Orders button
     *
     * @param event is entered when a user presses the View Orders button
     */
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

    /**
     * The Home page is brought up when the user presses the  Home button
     *
     * @param event is entered when a user presses the Home button
     */
    @FXML
    public void onHomeButtonClick(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}