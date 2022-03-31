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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class ChefController {

    @FXML
    public Button homeButton;
    public Button viewOutstandingOrders;
    public Button viewSpecials;
    public String username;
    public Label userLabel;



    public ChefController() throws SQLException {
    }

    public void setUserText(String text) {
        username = text;
        userLabel.setText(text);
    }

    //Database connection
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

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
     *
     * @param event is entered when a user presses the home button
     *
     */
    @FXML
    public void onHomeButtonClick(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}