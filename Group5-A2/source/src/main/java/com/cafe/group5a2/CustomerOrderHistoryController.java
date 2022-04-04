package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import static java.lang.Integer.parseInt;

/**
 * This class shows the customer all order that they had made previously
 *
 * @author Adam Tucker
 * @version 1.0
 */
public class CustomerOrderHistoryController {

    @FXML
    public Label Type1;
    public Label Type2;
    public Label Type3;
    public Label Type4;
    public Label Type5;
    public Label Type6;
    public Label Type7;
    public Label Type8;
    public Label Type9;
    public Label Type10;
    public Label Type11;
    public Label Type12;
    public Label Type13;
    public Label Type14;
    public Label Type15;
    public Label Type16;
    public Label Type17;
    public Label Type18;
    public Label Type19;
    public Label Type20;
    public Label Type21;
    public Label Date1;
    public Label Date2;
    public Label Date3;
    public Label Date4;
    public Label Date5;
    public Label Date6;
    public Label Date7;
    public Label Date8;
    public Label Date9;
    public Label Date10;
    public Label Date11;
    public Label Date12;
    public Label Date13;
    public Label Date14;
    public Label Date15;
    public Label Date16;
    public Label Date17;
    public Label Date18;
    public Label Date19;
    public Label Date20;
    public Label Date21;
    public Button viewOrder1;
    public Button viewOrder2;
    public Button viewOrder3;
    public Button viewOrder4;
    public Button viewOrder5;
    public Button viewOrder6;
    public Button viewOrder7;
    public Button viewOrder8;
    public Button viewOrder9;
    public Button viewOrder10;
    public Button viewOrder11;
    public Button viewOrder12;
    public Button viewOrder13;
    public Button viewOrder14;
    public Button viewOrder15;
    public Button viewOrder16;
    public Button viewOrder17;
    public Button viewOrder18;
    public Button viewOrder19;
    public Button viewOrder20;
    public Button viewOrder21;
    public Button refreshButton;
    public Button goBack;
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");
    private int orderID1;
    private int orderID2;
    private int orderID3;
    private int orderID4;
    private int orderID5;
    private int orderID6;
    private int orderID7;
    private int orderID8;
    private int orderID9;
    private int orderID10;
    private int orderID11;
    private int orderID12;
    private int orderID13;
    private int orderID14;
    private int orderID15;
    private int orderID16;
    private int orderID17;
    private int orderID18;
    private int orderID19;
    private int orderID20;
    private int orderID21;
    private int uID;
    private String username;


    /**
     * @throws SQLException throw a type of Exception that the IDE doesn't support
     */
    public CustomerOrderHistoryController() throws SQLException {
    }

    /**
     * Returns void.
     * Sets the name of the user using the application
     *
     * @param text The users name
     */
    public void setUser(String text) {
        username = text;
        getUserID();
    }

    /**
     * Returns an int value.
     * Method gets the usersID which is an int value but using an
     * SQL query
     */
    public void getUserID() {
        String query = "SELECT user_ID FROM users WHERE username = '" + username + "'";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                uID = rs.getInt("user_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * This method sets the order id for the Order on the
     * database to show which orders have been made by the customer .
     */
    @FXML
    public void setOrderID() {
        String query = "SELECT order_ID, table_number, date_time, type FROM orders WHERE complete = 1 AND FK_user_ID = " + uID + " ORDER BY date_time LIMIT 21";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int counter = 1;
            Type1.setText("NAME");
            Type2.setText("NAME");
            Type3.setText("NAME");
            Type4.setText("NAME");
            Type5.setText("NAME");
            Type6.setText("NAME");
            Type7.setText("NAME");
            Type8.setText("NAME");
            Type9.setText("NAME");
            Type10.setText("NAME");
            Type11.setText("NAME");
            Type12.setText("NAME");
            Type13.setText("NAME");
            Type14.setText("NAME");
            Type15.setText("NAME");
            Type16.setText("NAME");
            Type17.setText("NAME");
            Type18.setText("NAME");
            Type19.setText("NAME");
            Type20.setText("NAME");
            Type21.setText("NAME");
            while (rs.next()) {
                int resultID = parseInt(rs.getString("order_ID"));
                String type = rs.getString("type");
                String date = String.valueOf(rs.getDate("date_time"));
                switch (counter) {
                    case 1 -> {
                        orderID1 = resultID;
                        Type1.setText(type);
                        Date1.setText(date);
                    }
                    case 2 -> {
                        orderID2 = resultID;
                        Type2.setText(type);
                        Date2.setText(date);
                    }
                    case 3 -> {
                        orderID3 = resultID;
                        Type3.setText(type);
                        Date3.setText(date);
                    }
                    case 4 -> {
                        orderID4 = resultID;
                        Type4.setText(type);
                        Date4.setText(date);
                    }
                    case 5 -> {
                        orderID5 = resultID;
                        Type5.setText(type);
                        Date5.setText(date);
                    }
                    case 6 -> {
                        orderID6 = resultID;
                        Type6.setText(type);
                        Date6.setText(date);
                    }
                    case 7 -> {
                        orderID7 = resultID;
                        Type7.setText(type);
                        Date7.setText(date);
                    }
                    case 8 -> {
                        orderID8 = resultID;
                        Type8.setText(type);
                        Date8.setText(date);
                    }
                    case 9 -> {
                        orderID9 = resultID;
                        Type9.setText(type);
                        Date9.setText(date);
                    }
                    case 10 -> {
                        orderID10 = resultID;
                        Type10.setText(type);
                        Date10.setText(date);
                    }
                    case 11 -> {
                        orderID11 = resultID;
                        Type11.setText(type);
                        Date11.setText(date);
                    }
                    case 12 -> {
                        orderID12 = resultID;
                        Type12.setText(type);
                        Date12.setText(date);
                    }
                    case 13 -> {
                        orderID13 = resultID;
                        Type13.setText(type);
                        Date13.setText(date);
                    }
                    case 14 -> {
                        orderID14 = resultID;
                        Type14.setText(type);
                        Date14.setText(date);
                    }
                    case 15 -> {
                        orderID15 = resultID;
                        Type15.setText(type);
                        Date15.setText(date);
                    }
                    case 16 -> {
                        orderID16 = resultID;
                        Type16.setText(type);
                        Date16.setText(date);
                    }
                    case 17 -> {
                        orderID17 = resultID;
                        Type17.setText(type);
                        Date17.setText(date);
                    }
                    case 18 -> {
                        orderID18 = resultID;
                        Type18.setText(type);
                        Date18.setText(date);
                    }
                    case 19 -> {
                        orderID19 = resultID;
                        Type19.setText(type);
                        Date19.setText(date);
                    }
                    case 20 -> {
                        orderID20 = resultID;
                        Type20.setText(type);
                        Date20.setText(date);
                    }
                    case 21 -> {
                        orderID21 = resultID;
                        Type21.setText(type);
                        Date21.setText(date);
                    }
                    default -> {
                    }
                }
                counter++;
            }
            if (Type1.getText().equals("NAME")) {
                Type1.setText("No Order");
                viewOrder1.setDisable(true);
                Date1.setText("");
            }
            if (Type2.getText().equals("NAME")) {
                Type2.setText("No Order");
                viewOrder2.setDisable(true);
                Date2.setText("");
            }
            if (Type3.getText().equals("NAME")) {
                Type3.setText("No Order");
                viewOrder3.setDisable(true);
                Date3.setText("");
            }
            if (Type4.getText().equals("NAME")) {
                Type4.setText("No Order");
                viewOrder4.setDisable(true);
                Date4.setText("");
            }
            if (Type5.getText().equals("NAME")) {
                Type5.setText("No Order");
                viewOrder5.setDisable(true);
                Date5.setText("");
            }
            if (Type6.getText().equals("NAME")) {
                Type6.setText("No Order");
                viewOrder6.setDisable(true);
                Date6.setText("");
            }
            if (Type7.getText().equals("NAME")) {
                Type7.setText("No Order");
                viewOrder7.setDisable(true);
                Date7.setText("");
            }
            if (Type8.getText().equals("NAME")) {
                Type8.setText("No Order");
                viewOrder8.setDisable(true);
                Date8.setText("");
            }
            if (Type9.getText().equals("NAME")) {
                Type9.setText("No Order");
                viewOrder9.setDisable(true);
                Date9.setText("");
            }
            if (Type10.getText().equals("NAME")) {
                Type10.setText("No Order");
                viewOrder10.setDisable(true);
                Date10.setText("");
            }
            if (Type11.getText().equals("NAME")) {
                Type11.setText("No Order");
                viewOrder11.setDisable(true);
                Date11.setText("");
            }
            if (Type12.getText().equals("NAME")) {
                Type12.setText("No Order");
                viewOrder12.setDisable(true);
                Date12.setText("");
            }
            if (Type13.getText().equals("NAME")) {
                Type13.setText("No Order");
                viewOrder13.setDisable(true);
                Date13.setText("");
            }
            if (Type14.getText().equals("NAME")) {
                Type14.setText("No Order");
                viewOrder14.setDisable(true);
                Date14.setText("");
            }
            if (Type15.getText().equals("NAME")) {
                Type15.setText("No Order");
                viewOrder15.setDisable(true);
                Date15.setText("");
            }
            if (Type16.getText().equals("NAME")) {
                Type16.setText("No Order");
                viewOrder16.setDisable(true);
                Date16.setText("");
            }
            if (Type17.getText().equals("NAME")) {
                Type17.setText("No Order");
                viewOrder17.setDisable(true);
                Date17.setText("");
            }
            if (Type18.getText().equals("NAME")) {
                Type18.setText("No Order");
                viewOrder18.setDisable(true);
                Date18.setText("");
            }
            if (Type19.getText().equals("NAME")) {
                Type19.setText("No Order");
                viewOrder19.setDisable(true);
                Date19.setText("");
            }
            if (Type20.getText().equals("NAME")) {
                Type20.setText("No Order");
                viewOrder20.setDisable(true);
                Date20.setText("");
            }
            if (Type21.getText().equals("NAME")) {
                Type21.setText("No Order");
                viewOrder21.setDisable(true);
                Date21.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * The Customer Order History page is updated to include any new orders that may have been made
     *
     * @param actionEvent is entered when a user presses the Refresh button
     */
    @FXML
    public void onClickRefreshPage(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) refreshButton.getScene().getWindow();
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
     * The Customer home page is brought up when the user presses the Go back button
     *
     * @param actionEvent is entered when a user presses the Go back button
     */
    @FXML
    public void onClickGoBack(ActionEvent actionEvent) {
        Parent newRoot;
        try {
            Stage stage = (Stage) goBack.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customer-view.fxml"));
            newRoot = loader.load();

            CustomerController cCont = loader.getController();
            cCont.setUserText(username);//550, 523

            stage.setTitle("Main menu");
            stage.setHeight(550);
            stage.setMaxHeight(550);
            stage.setWidth(550);
            stage.setMaxWidth(550);
            stage.centerOnScreen();
            stage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */
    @FXML
    public void onClickViewOrder1(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID1);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder2(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder2.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID2);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder3(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder3.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID3);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder4(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder4.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID4);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder5(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder5.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID5);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder6(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder6.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID6);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder7(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder7.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID7);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder8(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder8.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID8);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder9(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder9.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID9);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder10(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder10.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID10);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder11(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder11.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID11);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder12(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder12.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID12);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder13(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder13.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID13);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder14(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder14.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID14);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder15(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder15.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID15);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder16(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder16.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID16);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder17(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder17.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID17);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder18(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder18.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID18);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */

    @FXML
    public void onClickViewOrder19(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder19.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID19);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */
    @FXML
    public void onClickViewOrder20(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder20.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID20);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * The Customer View Order page is brought up when the user presses the view order button
     *
     * @param actionEvent is entered when a user presses the view order button
     */
    @FXML
    public void onClickViewOrder21(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder21.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custMenuOrder.fxml"));
            Parent newRoot = loader.load();

            CustomerViewOrderController custVOCont = loader.getController();
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            custVOCont.setUser(username);
            custVOCont.setItemsAndQuant(orderID21);
            stage.setTitle("View Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }
}