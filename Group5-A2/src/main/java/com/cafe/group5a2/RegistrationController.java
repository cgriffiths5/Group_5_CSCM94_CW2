package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Observable;


/**
 * @author Chris Griffiths
 * @author 
 */

public class RegistrationController {

    public Button HomeButton1;
    public TextField FirstName1;
    public TextField LastName1;
    public TextField Username1;
    public Text ErrorUsername;
    public PasswordField Password1;
    public PasswordField ConfirmPassword1;
    public Text ErrorPassword;
    public TextField HouseNO1;
    public TextField Postcode1;
    public Button SubmitButton1;
    public Text ErrorLabel1;
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");



    @FXML
    public Button SubmitButton;
    public TextField FirstName;
    public TextField LastName;
    public TextField Username;
    public TextField Password;
    public TextField ConfirmPassword;
    public TextField HouseNO;
    public TextField Postcode;
    public Text ErrorLabel;
    public Button HomeButton;

    public RegistrationController() throws SQLException {
    }

    /**
     * When the submit button is pressed the information entered into the textfields is submitted into the database
     * as a new user. The role is automatically set to customer in order to avoid giving a user access to staff only
     * controls.
     * @param event is triggered when the submit button is pressed
     */

    @FXML
    public void OnSubmit(ActionEvent event) {

        String First = FirstName.getText();
        String Last = LastName.getText();
        String User = Username.getText();
        String Pass = Password.getText();
        String ConPass = ConfirmPassword.getText();
        String HouseNumber = HouseNO.getText();
        String Post = Postcode.getText();

        String query = "INSERT INTO users (f_name, l_name, role, username, password, house_number, postcode)" +
                "VALUES ('" + First + "','" + Last + "', 'customer', '" + User + "','" + Pass + "','"
                + HouseNumber + "','" + Post + "')";

        if (FirstName.getText().isEmpty()) {
            ErrorLabel.setText("Error: First name is empty");
        } else if (LastName.getText().isEmpty()) {
            ErrorLabel.setText("Error: Last name is empty");
        } else if (Username.getText().isEmpty()) {
            ErrorLabel.setText("Error: Username is empty");
        } else if (Password.getText().isEmpty()) {
            ErrorLabel.setText("Error: Password is empty");
        } else if (ConfirmPassword.getText().isEmpty()) {
            ErrorLabel.setText("Error: Confirm password is empty");
        } else if (HouseNO.getText().isEmpty()) {
            ErrorLabel.setText("Error: House number is empty");
        } else if (Postcode.getText().isEmpty()) {
            ErrorLabel.setText("Error: Postcode is empty");
        }

        else if (Pass.equals(ConPass)) {
            try (Statement stmt = con.createStatement()) {
                stmt.executeQuery(query);
            } catch (Exception e) {
                System.out.println("Errors Detected");
                e.printStackTrace();
            }

        } else {
            ErrorLabel.setText("Error: Passwords don't match");
        }

    }

    /**
     * When the home button is pressed then the login page is returned
     * @param event is triggered when the return home button is pressed
     * @throws IOException
     */

    public void onHomeButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) HomeButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull
                (getClass().getResource("home-view.fxml")));
        stage.getScene().setRoot(newRoot);

    }



}
