package com.cafe.group5a2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    public void onDisplaySpecialsButtonClick() throws SQLException {
        String query = "SELECT * FROM menu WHERE special_flag = 1;";

        specialList.clear();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                specialList.add(rs.getString("item") + " " + rs.getString("price") + " " + rs.getString("description") + "\n");
            }

            ObservableList specialsList = specialList;

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
     *
     * @param event when the submit button is pressed a special is entered into the menu
     */

    @FXML
    public void onSubmitButtonClick(ActionEvent event) throws SQLException {

        String name = SpecialName.getText();
        String description = SpecialDescription.getText();
        String price = SpecialPrice.getText();

        System.out.println(name + " " + description + " " + price);

        setSpecial(name, description, Integer.parseInt(price));

    }

    public void setSpecial(String name, String description, float price) throws SQLException {
        String query = "INSERT INTO menu ( item, description, food_flag, drink_flag, special_flag, price) " +
                       "VALUES ('" + name + "','" + description + "', 1, 0, 1, '" + price + "');";
        try(Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error detected");
            e.printStackTrace();
        }

    }

    public void onDeleteSpecialButtonClick(ActionEvent actionEvent) throws SQLException {
        String name = DeleteSpecial.getText();

        String query = "DELETE FROM menu WHERE item ='" + name + "' AND special_flag = 1;";
        try(Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error detected");
            e.printStackTrace();
        }
    }



    /**
     *
     * @param event when the return back button is pressed the chef view FXML page is loaded
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
