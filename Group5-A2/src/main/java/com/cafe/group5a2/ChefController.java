package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
* This class shows options the chef can click which is the orders
* the daily specials and to be able to logout
* @author Chris Griffiths
* @author Cameron Turner
* @version 1.0
*/

public class ChefController {

    @FXML
    public Button homeButton;
    public Button viewOutstandingOrders;
    public Button viewSpecials;
    public String username;
    public Label userLabel;
    public Label Title;
    
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    /**
     * @throws SQLException throw a type of Exception that the IDE doesn't support
     */
    public ChefController() throws SQLException {
    }

    /**
     * Returns void.
     * Sets the name of the user using the application
     * @param text The username
     */
    public void setUserText(String text) {
        username = text;
        userLabel.setText(text);
    }

    /**
     * Returns void.
     * Method is called when a button is pressed to set up 
     * a new page
     * @param event the view specials button
     */
    @FXML
    public void onViewSpecialsClick(ActionEvent event) {
        try {
            Stage stage = (Stage) viewSpecials.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("specials-view.fxml")));
            stage.setTitle("Specials");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * Returns void
     * When view order button has been clicked this method is called
     * to open a new page
     * @param event view order button
     */
    @FXML
    public void onViewOutstandingOrdersClick(ActionEvent event) {
        try {
            Stage stage = (Stage) viewOutstandingOrders.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chefOrders.fxml"));
            Parent newRoot = loader.load();

            ChefOrdersController chefOrdCont = loader.getController();
            chefOrdCont.setUserTextOrders(username);
            chefOrdCont.setOrderID();

            //cgriffiths
            stage.setHeight(530);
            stage.setMaxHeight(530);
            stage.setWidth(630);
            stage.setMaxWidth(630);

            stage.setTitle("Outstanding Orders");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * Returns void
     * takes the user back to the login page when a button is
     * clicked
     * @param event is entered when a user presses the home button
     */
    @FXML
    public void onHomeButtonClick(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
