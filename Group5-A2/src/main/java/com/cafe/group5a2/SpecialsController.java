package com.cafe.group5a2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class SpecialsController {

    @FXML
    public Button SubmitButton;
    public Button ChefHomeReturn;
    public Button DeleteSpecialButton;
    public TextField SpecialName;
    public TextField SpecialDescription;
    public TextField SpecialPrice;
    public TextField DeleteSpecial;

    //Database connection
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    public SpecialsController() throws SQLException {
    }

    ObservableList<String> specialList = FXCollections.observableArrayList();
    
    /**
     * When the display specials button is pressed a list of specials are returned from the database
     * @throws SQLException
     */

    public void onDisplaySpecialsButtonClick() throws SQLException {
        String query = "SELECT * FROM menu WHERE category = 'special';";

        specialList.clear();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                specialList.add(rs.getString("item") + " " + rs.getString("price") + " " + rs.getString("description") + "\n");
            }

            ObservableList<String> specialsList = specialList;

            Stage secondStage = new Stage();
            secondStage.setTitle("Specials");

            final ListView specialListView = new ListView(specialsList);
            specialListView.setPrefSize(400, 500);

            specialListView.setItems(specialsList);

            StackPane root = new StackPane();
            root.getChildren().add(specialListView);
            secondStage.setScene(new Scene(root, 400, 500));
            secondStage.show();

        } catch (SQLException e) {
            System.out.println("Error Detected");
            e.printStackTrace();
        }

    }

    /**
     * When this event is triggered the name, description and price of a new special are collected from the
     * textfields and then the setSpecial method that inputs these into the database are triggered
     * @param event is triggered when the submit button is pressed
     */

    @FXML
    public void onSubmitButtonClick(ActionEvent event) throws SQLException {

        String name = SpecialName.getText();
        String description = SpecialDescription.getText();
        String price = SpecialPrice.getText();

        System.out.println(name + " " + description + " " + price);

        setSpecial(name, description, Integer.parseInt(price));

    }
    
    /**
     * An SQL query is triggered to input these parameters in a new entry in the database
     * @param name is given through the name textfield
     * @param description is given through the description textfield
     * @param price is given through the price textfield
     * @throws SQLException
     */

    public void setSpecial(String name, String description, float price) throws SQLException {
        String special = "special";
        String query = "INSERT INTO menu ( item, description, category, price) " +
                "VALUES ('" + name + "','" + description + "','" + special + "','" + price + "');";
        try(Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error detected");
            e.printStackTrace();
        }

    }
    
    /**
     * Once the actionEvent is triggered a special is deleted by name
     * @param actionEvent is triggered when delete button is pressed
     * @throws SQLException
     */

    public void onDeleteSpecialButtonClick(ActionEvent actionEvent) throws SQLException {
        String name = DeleteSpecial.getText();

        String query = "DELETE FROM menu WHERE item ='" + name + "' AND category = 'special';";
        try(Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error detected");
            e.printStackTrace();
        }
    }



    /**
     * When the event is triggered the chef home page is loaded
     * @param event when the return back button is pressed the event is triggered
     */

    @FXML
    public void onChefHomeReturnClick(ActionEvent event) {
        try {
            Stage stage = (Stage) ChefHomeReturn.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chef-view.fxml")));

            stage.setTitle("Chef");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }



}
