package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

/**
 * This class allows the manager to add a new staff member
 *
 * @author Chris Griffiths
 * @version 1.6
 */
public class AddNewStaffController {

    public Button HomeButton1;
    public TextField FirstName1;
    public TextField LastName1;
    public TextField Username1;
    public PasswordField Password1;
    public PasswordField ConfirmPassword1;
    public TextField HouseNO1;
    public TextField Postcode1;
    public Button SubmitButton1;
    public TextField Role;
    public Text ErrorLabel;
    private String username;


    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");


    public AddNewStaffController() throws SQLException {
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
     * When the submit button is pressed the information entered into the textfields is submitted into the database
     * as a new user. The role is automatically set to customer in order to avoid giving a user access to staff only
     * controls.
     *
     * @param event is triggered when the submit button is pressed
     */
    @FXML
    public void OnSubmit(ActionEvent event) {

        String First = FirstName1.getText();
        String Last = LastName1.getText();
        String User = Username1.getText();
        String Pass = Password1.getText();
        String ConPass = ConfirmPassword1.getText();
        String Role1 = Role.getText();
        String HouseNumber = HouseNO1.getText();
        String Post = Postcode1.getText();

        String query1 = "SELECT username FROM users";

        boolean sameUsername = false;

        try {
            Statement stmt1 = con.createStatement();
            ResultSet r1 = stmt1.executeQuery(query1);

            while (r1.next()) {
                if (User.equals(r1.getString("username"))) {
                    sameUsername = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query2 = "INSERT INTO users (f_name, l_name, role, username, password, house_number, postcode)" +
                "VALUES ('" + First + "','" + Last + "', '" + Role1 + "', '" + User + "','" + Pass + "','"
                + HouseNumber + "','" + Post + "')";

        if (FirstName1.getText().isEmpty()) {
            ErrorLabel.setText("Error: First name is empty");
            ErrorLabel.setOpacity(1);
        } else if (LastName1.getText().isEmpty()) {
            ErrorLabel.setText("Error: Last name is empty");
            ErrorLabel.setOpacity(1);
        } else if (Username1.getText().isEmpty()) {
            ErrorLabel.setText("Error: Username is empty");
            ErrorLabel.setOpacity(1);
        } else if (Password1.getText().isEmpty()) {
            ErrorLabel.setText("Error: Password is empty");
            ErrorLabel.setOpacity(1);
        } else if (ConfirmPassword1.getText().isEmpty()) {
            ErrorLabel.setText("Error: Confirm password is empty");
            ErrorLabel.setOpacity(1);
        } else if (Role.getText().isEmpty()) {
            ErrorLabel.setText("Error: Role is empty");
        } else if (HouseNO1.getText().isEmpty()) {
            ErrorLabel.setText("Error: House number is empty");
            ErrorLabel.setOpacity(1);
        } else if (Postcode1.getText().isEmpty()) {
            ErrorLabel.setText("Error: Postcode is empty");
            ErrorLabel.setOpacity(1);
        } else if (sameUsername) {
            ErrorLabel.setText("Username already used");
            ErrorLabel.setOpacity(1);
        } else if (Pass.equals(ConPass)) {
            try (Statement stmt = con.createStatement()) {
                stmt.executeQuery(query2);
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
     *
     * @param event is triggered when the return home button is pressed
     * @throws IOException in case loading the view fails
     */
    public void onHomeButtonClick(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) HomeButton1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addStaff-view.fxml"));
            Parent newRoot = loader.load();
            ManageStaffController mSCont = loader.getController();
            mSCont.setUser(username);
            stage.setTitle("Manage Staff");
            stage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }
}