package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * This method deletes a staff member
 *
 * @author Chris Griffiths
 * @version 1.6
 */
public class DeleteStaffController {

    @FXML
    public Button ManagerHomeReturn;
    public Button OnSubmitButton;
    public TextField FirstName;
    public TextField LastName;
    private String username;
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    public DeleteStaffController() throws SQLException {
    }

    /**
     * Returns void.
     * Sets the name of the user using the application
     *
     * @param text The username
     */
    public void setUser(String text) {
        username = text;
    }

    /**
     * This returns the manager homepage
     *
     * @param event this is triggered by the home button
     */
    @FXML
    public void onManagerHomeReturnClick(ActionEvent event) {
        try {
            Stage stage = (Stage) ManagerHomeReturn.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("manager-view.fxml"));
            Parent newRoot = loader.load();
            ManagerController mCont = loader.getController();
            Rectangle2D sBound = Screen.getPrimary().getVisualBounds();
            mCont.setUserText(username);
            stage.setY(sBound.getHeight() - (sBound.getHeight() / 1.25));
            stage.setX(sBound.getWidth() - (sBound.getWidth() / 1.25));
            stage.setTitle("Manager");
            stage.setHeight(450);
            stage.setWidth(450);
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * When the submit button is clicked a user is deleted using the first and last names as
     * parameters
     *
     * @param actionEvent this is triggered the submit button click
     */
    public void onSubmitButtonClick(ActionEvent actionEvent) {
        String FirstName1 = FirstName.getText();
        String LastName1 = LastName.getText();

        String query = "DELETE FROM users WHERE f_name ='" + FirstName1 + "' AND l_name = '" + LastName1 + "';";
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error detected");
            e.printStackTrace();
        }
    }
}
