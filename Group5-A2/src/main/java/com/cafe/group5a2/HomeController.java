package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class HomeController {

    @FXML
    public Button custButton;
    public Label Title;
    public Label Subtitle;
    public Label custButtonLabel;
    public Label buttonText;
    @FXML
    public Button quitButton;
    public TextField username;
    public TextField password;

    Connection con = DriverManager.getConnection
            ("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    // THIS IS THE CONNECTOR, USE THIS IN OTHER CONTROLLERS

    public HomeController() throws SQLException {
    }

    @FXML
    public void onCustButtonClick(ActionEvent event) {
        try {
            String user = username.getText();
            String pass = password.getText();
            boolean verifyUser = checkUsernamePassword(user, pass);
            String role = "";
            if (verifyUser) {
                role = getRole(user);
            } else {
                Stage stage = (Stage) custButton.getScene().getWindow();
                Parent newRoot = FXMLLoader.load(Objects.requireNonNull
                        (getClass().getResource("home-view.fxml")));
                stage.getScene().setRoot(newRoot);
            }

            switch (role) {
                case "customer":
                    Stage stage = (Stage) custButton.getScene().getWindow();
                    Parent newRoot = FXMLLoader.load(Objects.requireNonNull
                            (getClass().getResource("customer-view.fxml")));
                    stage.setTitle(user + "'s profile");
                    stage.getScene().setRoot(newRoot);
                case "manager":
                    stage = (Stage) custButton.getScene().getWindow();
                    newRoot = FXMLLoader.load(Objects.requireNonNull
                            (getClass().getResource("manager-view.fxml")));
                    stage.getScene().setRoot(newRoot);
                case "waiter":
                    stage = (Stage) custButton.getScene().getWindow();
                    newRoot = FXMLLoader.load(Objects.requireNonNull
                            (getClass().getResource("waiter-view.fxml")));
                    stage.getScene().setRoot(newRoot);
                case "chef":
                    stage = (Stage) custButton.getScene().getWindow();
                    newRoot = FXMLLoader.load(Objects.requireNonNull
                            (getClass().getResource("chef-view.fxml")));
                    stage.getScene().setRoot(newRoot);
                case "driver":
                    stage = (Stage) custButton.getScene().getWindow();
                    newRoot = FXMLLoader.load(Objects.requireNonNull
                            (getClass().getResource("driver-view.fxml")));
                    stage.getScene().setRoot(newRoot);
                default:
                    stage = (Stage) custButton.getScene().getWindow();
                    newRoot = FXMLLoader.load(Objects.requireNonNull
                            (getClass().getResource("home-view.fxml")));
                    stage.getScene().setRoot(newRoot);
            }

        } catch (IOException e) {
            System.out.println("Error loading page");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onQuitButtonClick(ActionEvent event) {

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    public boolean checkUsernamePassword(String username, String password) throws SQLException {
        String query = "SELECT password FROM users WHERE username = '" + username + "'";
        boolean retVal = false;
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String resultPassword = rs.getString("password");
                if (resultPassword.equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return retVal;
        }
        return retVal;
    }

    public String getRole(String username) throws SQLException {
        String query = "SELECT role FROM users WHERE username = '" + username + "'";
        String retRole = "null";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                retRole = rs.getString("role");
                if (retRole != null) {
                    return retRole;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return retRole;
        }
        return retRole;
    }
}


