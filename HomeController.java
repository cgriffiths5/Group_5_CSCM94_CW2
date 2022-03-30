package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class HomeController {

    @FXML
    public Button custButton;
    public Label Title;
    public Label Subtitle;
    public Label custButtonLabel;
    public Label buttonText;
    public Button registerButton;
    @FXML
    public Button quitButton;
    public TextField username;
    public TextField password;

    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

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
                    Parent newRoot;
                    Stage stage;
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("customer-view.fxml"));
                        newRoot = loader.load();

                        CustomerController cCont = loader.getController();
                        cCont.setUserText(user);

                        stage = new Stage();
                        stage.setTitle("Main menu");
                        stage.setScene(new Scene(newRoot, 550, 523));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case "manager":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("manager-view.fxml"));
                        newRoot = loader.load();

                        ManagerController mCont = loader.getController();
                        mCont.setUserText(user);
                        Rectangle2D sBound = Screen.getPrimary().getVisualBounds();
                        //stage.setX(((sBound.getWidth() - stage.getWidth())/2) - (sBound.getWidth() / 10));
                        stage = new Stage();
                        stage.setY(sBound.getHeight() - (sBound.getHeight()/1.25));
                        stage.setX(sBound.getWidth() - (sBound.getWidth()/1.25));
                        stage.setTitle("Manager Homepage");
                        stage.setScene(new Scene(newRoot, 450, 450));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case "waiter":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("waiter-view.fxml"));
                        newRoot = loader.load();

                        WaiterController wCont = loader.getController();
                        wCont.setUserText(user);
                        wCont.setResOrdTab();
                        wCont.setTakeawayOrdTable();

                        stage = new Stage();
                        stage.setTitle("Waiter Homepage");
                        stage.setScene(new Scene(newRoot, 600, 490));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case "chef":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("chef-view.fxml"));
                        newRoot = loader.load();

                        //CustomerController cCont = loader.getController();
                        //cCont.setUserText(user);

                        stage = new Stage();
                        stage.setTitle(user);
                        stage.setScene(new Scene(newRoot, 450, 450));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case "driver":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("driver-view.fxml"));
                        newRoot = loader.load();

                        CustomerController cCont = loader.getController();
                        cCont.setUserText(user);

                        stage = new Stage();
                        stage.setTitle(user);
                        stage.setScene(new Scene(newRoot, 450, 450));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                default:
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("home-view.fxml"));
                        newRoot = loader.load();

                        CustomerController cCont = loader.getController();
                        cCont.setUserText(user);

                        stage = new Stage();
                        stage.setTitle(user);
                        stage.setScene(new Scene(newRoot, 450, 450));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

        } catch (IOException e) {
            System.out.println("Error loading page");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEnter(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
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
                        Parent newRoot;
                        Stage stage;
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("customer-view.fxml"));
                            newRoot = loader.load();

                            CustomerController cCont = loader.getController();
                            cCont.setUserText(user);

                            stage = new Stage();
                            stage.setTitle("Main menu");
                            stage.setScene(new Scene(newRoot, 550, 523));
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    case "manager":
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("manager-view.fxml"));
                            newRoot = loader.load();

                            ManagerController mCont = loader.getController();
                            mCont.setUserText(user);
                            Rectangle2D sBound = Screen.getPrimary().getVisualBounds();
                            stage = new Stage();
                            stage.setY(sBound.getHeight() - (sBound.getHeight()/1.25));
                            stage.setX(sBound.getWidth() - (sBound.getWidth()/1.25));
                            stage.setTitle("Manager Homepage");
                            stage.setScene(new Scene(newRoot, 450, 450));
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    case "waiter":
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("waiter-view.fxml"));
                            newRoot = loader.load();

                            WaiterController wCont = loader.getController();
                            wCont.setUserText(user);
                            wCont.setResOrdTab();
                            wCont.setTakeawayOrdTable();


                            stage = new Stage();
                            stage.setTitle("Waiter Homepage");
                            stage.setScene(new Scene(newRoot, 600, 490));
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    case "chef":
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("chef-view.fxml"));
                            newRoot = loader.load();

                            CustomerController cCont = loader.getController();
                            cCont.setUserText(user);

                            stage = new Stage();
                            stage.setTitle(user);
                            stage.setScene(new Scene(newRoot, 450, 450));
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    case "driver":
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("driver-view.fxml"));
                            newRoot = loader.load();

                            CustomerController cCont = loader.getController();
                            cCont.setUserText(user);

                            stage = new Stage();
                            stage.setTitle(user);
                            stage.setScene(new Scene(newRoot, 450, 450));
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    default:
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("home-view.fxml"));
                            newRoot = loader.load();

                            CustomerController cCont = loader.getController();
                            cCont.setUserText(user);

                            stage = new Stage();
                            stage.setTitle(user);
                            stage.setScene(new Scene(newRoot, 450, 450));
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }

            } catch (IOException e) {
                System.out.println("Error loading page");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void onRegButtonClick(ActionEvent event) throws IOException {

        Stage stage = (Stage) registerButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull
                (getClass().getResource("registration-view.fxml")));
        stage.getScene().setRoot(newRoot);

    }

    @FXML
    public void onQuitButtonClick(ActionEvent event) {

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    /**
     *
     * @param username is the username entered by the person logging in
     * @param password is the password entered by the person logging in
     * @return false if the username doesn't exist or the password doesn't match for that user
     * @throws SQLException just to ensure the program doesn't crash, don't actually handle exception
     */
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

    /**
     *
     * @param username rhrhbr
     * @return rhrth
     * @throws SQLException rgrgr
     */
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


