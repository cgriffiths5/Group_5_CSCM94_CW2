package com.cafe.group5a2;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import static java.lang.Integer.parseInt;

/**
 * Waiter controller class shows relevant information and buttons
 * that the waiter needs to have functionality in the program
 *
 * @author Cameron Turner
 * @author Adam Tucker
 * @version 1.0
 */

public class WaiterController {
    @FXML
    public Label waiterName;
    public Label ResOrdTab1;
    public Label ResOrdTab2;
    public Label ResOrdTab3;
    public Label ResOrdTab4;
    public Label TakOrdCust1;
    public Label TakOrdCust2;
    public Label TakOrdCust3;
    public Label TakOrdCust4;

    public Button newOrderBut;
    public Button approveBookingBut;
    public Button logoutBut;

    @FXML
    public CheckBox ResOrdFinBox1; //restaurant finished
    public CheckBox ResOrdFinBox2;
    public CheckBox ResOrdFinBox3;
    public CheckBox ResOrdFinBox4;
    public CheckBox ResOrdProBox1; //restaurant problem
    public CheckBox ResOrdProBox2;
    public CheckBox ResOrdProBox3;
    public CheckBox ResOrdProBox4;
    public CheckBox TakOrdProBox1; //Takeaway problem
    public CheckBox TakOrdProBox2;
    public CheckBox TakOrdProBox3;
    public CheckBox TakOrdProBox4;
    public CheckBox TakOrdFinBox1; //Takeaway finished
    public CheckBox TakOrdFinBox2;
    public CheckBox TakOrdFinBox3;
    public CheckBox TakOrdFinBox4;


    @FXML
    public Button refreshButton;
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");
    private String username;
    private int orderID1;
    private int orderID2;
    private int orderID3;
    private int orderID4;
    private int takeawayOrderID1;
    private int takeawayOrderID2;
    private int takeawayOrderID3;
    private int takeawayOrderID4;

    /**
     * @throws SQLException throw a type of Exception that the IDE doesn't support
     */
    public WaiterController() throws SQLException {
    }

    /**
     * Return void. Takes you to the approve booking stage
     * input is an onclick event
     *
     * @param actionEvent Approve booking button
     */
    @FXML
    public void approveBooking(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) approveBookingBut.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("waiterApproveBooking.fxml"));
            Parent newRoot = loader.load();

            WaiterBookingManagement wBMng = loader.getController();
            wBMng.setUser(username);
            wBMng.setLabels();
            wBMng.hideEmpty();

            stage.centerOnScreen();
            stage.setTitle("Booking Management");
            stage.setHeight(800);
            stage.setWidth(800);
            stage.setMaxWidth(800);
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * Returns void.
     * Sets the name of the user using the application
     *
     * @param text The username
     */
    public void setUserText(String text) {
        waiterName.setText(username = text);
    }

    /**
     * Returns void and when logout button is pressed
     * the stage changes to the home screen
     *
     * @param actionEvent Logout button
     */
    public void logout(ActionEvent actionEvent) {
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * Returns void and when the "New Order" button is clicked
     * goes to a new stage to
     *
     * @param actionEvent new order Button
     */
    public void newOrder(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) newOrderBut.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("waiterMenu-view.fxml"));
            Parent newRoot = loader.load();

            WaiterMenuController wMCont = loader.getController();
            wMCont.setItemLabels();
            wMCont.setPriceLabels();
            wMCont.setDescLabels();
            wMCont.setUserText(username);
            Rectangle2D sBound = Screen.getPrimary().getVisualBounds();
            stage.setX(((sBound.getWidth() - stage.getWidth()) / 2) - (sBound.getWidth() / 10));
            stage.setY(((sBound.getHeight() - stage.getWidth()) / 2) - (sBound.getHeight() / 4));
            stage.setTitle("Waiter Order");
            stage.setHeight(802.0);
            stage.setMaxHeight(802.0);
            stage.setWidth(511.0);
            stage.setMaxWidth(511.0);
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * Sets the on screen data to show the relevant information
     * for the waiter to see which order needs to go to which table in the
     * restaurant.
     * If there is no information then a label with "No Order" will show up
     * and none of the check boxes can be clicked
     */
    public void setResOrdTab() {
        String query = "SELECT order_ID, table_number, complete FROM orders WHERE type='seated' AND prepared=1 AND complete=0 ORDER BY date_time LIMIT 4";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int counter = 1;
            ResOrdTab1.setText("No Order");
            ResOrdTab2.setText("No Order");
            ResOrdTab3.setText("No Order");
            ResOrdTab4.setText("No Order");
            while (rs.next()) {
                int result = parseInt(rs.getString("table_number"));
                int resultID = parseInt(rs.getString("order_ID"));
                switch (counter) {
                    case 1 -> {
                        ResOrdTab1.setText(String.valueOf(result));
                        orderID1 = resultID;
                    }
                    case 2 -> {
                        ResOrdTab2.setText(String.valueOf(result));
                        orderID2 = resultID;
                    }
                    case 3 -> {
                        ResOrdTab3.setText(String.valueOf(result));
                        orderID3 = resultID;
                    }
                    case 4 -> {
                        ResOrdTab4.setText(String.valueOf(result));
                        orderID4 = resultID;
                    }
                    default -> {
                    }
                }
                counter++;
            }
            if (ResOrdTab1.getText().equals("Table number")) {
                ResOrdTab1.setText("No Order");
                ResOrdProBox1.setOpacity(0.0);
                ResOrdFinBox1.setOpacity(0.0);
            }
            if (ResOrdTab2.getText().equals("Table number")) {
                ResOrdTab2.setText("No Order");
                ResOrdProBox2.setOpacity(0.0);
                ResOrdFinBox2.setOpacity(0.0);
            }
            if (ResOrdTab3.getText().equals("Table number")) {
                ResOrdTab3.setText("No Order");
                ResOrdProBox3.setOpacity(0.0);
                ResOrdFinBox3.setOpacity(0.0);
            }
            if (ResOrdTab4.getText().equals("Table number")) {
                ResOrdTab4.setText("No Order");
                ResOrdProBox4.setOpacity(0.0);
                ResOrdFinBox4.setOpacity(0.0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void. Shows the on screen information for takeaway orders.
     * Shows parts of the customers details so the waiter can find the
     * correct customer when handing over the order.
     * If there is no takeaway orders available then a "No Order" label will
     * appear
     */
    public void setTakeawayOrdTable() {
        String query = "SELECT f_name, l_name, order_ID FROM list_orders WHERE type = 'takeaway' AND prepared = 1 AND complete = 0 ORDER BY date_time ASC LIMIT 4";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int counter = 1;
            TakOrdCust1.setText("No Order");
            TakOrdCust2.setText("No Order");
            TakOrdCust3.setText("No Order");
            TakOrdCust4.setText("No Order");
            while (rs.next()) {
                String result = (rs.getString("f_name"));
                String result2 = (rs.getString("l_name"));
                String fullName = result + " " + result2;
                int resultID = parseInt(rs.getString("order_ID"));
                switch (counter) {
                    case 1 -> {
                        TakOrdCust1.setText(fullName);
                        takeawayOrderID1 = resultID;
                    }
                    case 2 -> {
                        TakOrdCust2.setText(fullName);
                        takeawayOrderID2 = resultID;
                    }
                    case 3 -> {
                        TakOrdCust3.setText(fullName);
                        takeawayOrderID3 = resultID;
                    }
                    case 4 -> {
                        TakOrdCust4.setText(fullName);
                        takeawayOrderID4 = resultID;
                    }
                    default -> {
                    }
                }
                counter++;
            }
            if (TakOrdCust1.getText().equals("first name last name")) {
                TakOrdCust1.setText("No Order");
                TakOrdProBox1.setOpacity(0.0);
                TakOrdFinBox1.setOpacity(0.0);
            }
            if (TakOrdCust2.getText().equals("first name last name")) {
                TakOrdCust2.setText("No Order");
                TakOrdProBox2.setOpacity(0.0);
                TakOrdFinBox2.setOpacity(0.0);
            }
            if (TakOrdCust3.getText().equals("first name last name")) {
                TakOrdCust3.setText("No Order");
                TakOrdProBox3.setOpacity(0.0);
                TakOrdFinBox3.setOpacity(0.0);
            }
            if (TakOrdCust4.getText().equals("first name last name")) {
                TakOrdCust4.setText("No Order");
                TakOrdProBox4.setOpacity(0.0);
                TakOrdFinBox4.setOpacity(0.0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When restaurant order 1 has a problem this boxed can be clicked so the chef can
     * remake the order for the customer and updates the relevant information
     * in the database. When the box had been checked it will refresh the page
     *
     * @param actionEvent Check box button
     */
    public void OnClickResOrdProBox1(ActionEvent actionEvent) {
        /*
        when check box has been clicked. this needs to send order
        back to the kitchen to be remade
        UPDATE orders SET complete = 1 WHERE order_ID = orderIDLabel1
        UPDATE orders SET complete = 1 WHERE order_ID = orderIDLabel2
        */
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + orderID1 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Returns void.
     * When restaurant order 2 has a problem this boxed can be clicked so the chef can
     * remake the order for the customer and updates the relevant information
     * in the database. When the box had been checked it will refresh the page
     *
     * @param actionEvent Check box button
     */
    public void OnClickResOrdProBox2(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + orderID2 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When restaurant order 3 has a problem this boxed can be clicked so the chef can
     * remake the order for the customer and updates the relevant information
     * in the database. When the box had been checked it will refresh the page
     *
     * @param actionEvent Check box button
     */
    public void OnClickResOrdProBox3(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + orderID3 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When restaurant order 4 has a problem this boxed can be clicked so the chef can
     * remake the order for the customer and updates the relevant information
     * in the database. When the box had been checked it will refresh the page
     *
     * @param actionEvent Check box button
     */
    public void OnClickResOrdProBox4(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + orderID4 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When restaurant order 1 has been delivered to the table and is all correct
     * a check box can be clicked to complete the order which changes the
     * relevant information on the database and removes the information
     * from the app. When the box has been clicked the page will
     * refresh
     *
     * @param actionEvent Check box button
     */
    public void OnClickResOrdFinBox1(ActionEvent actionEvent) {
        /*
        When check box has been clicked.
         */
        String query = "UPDATE orders SET complete = 1 WHERE order_ID = '" + orderID1 + "'";
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When restaurant order 2 has been delivered to the table and is all correct
     * a check box can be clicked to complete the order which changes the
     * relevant information on the database and removes the information
     * from the app. When the box has been clicked the page will
     * refresh
     *
     * @param actionEvent Check box button
     */
    public void OnClickResOrdFinBox2(ActionEvent actionEvent) {
        String query = "UPDATE orders SET complete = 1 WHERE order_ID = '" + orderID2 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When restaurant order 3 has been delivered to the table and is all correct
     * a check box can be clicked to complete the order which changes the
     * relevant information on the database and removes the information
     * from the app. When the box has been clicked the page will
     * refresh
     *
     * @param actionEvent Check box button
     */
    public void OnClickResOrdFinBox3(ActionEvent actionEvent) {
        String query = "UPDATE orders SET complete = 1 WHERE order_ID = '" + orderID3 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When restaurant order 4 has been delivered to the table and is all correct
     * a check box can be clicked to complete the order which changes the
     * relevant information on the database and removes the information
     * from the app. When the box has been clicked the page will
     * refresh
     *
     * @param actionEvent Check box button
     */
    public void OnClickResOrdFinBox4(ActionEvent actionEvent) {
        String query = "UPDATE orders complete = 1 WHERE order_ID = '" + orderID4 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When takeaway order 1 has a problem this boxed can be clicked so the chef can
     * remake the order for the customer and updates the relevant information
     * in the database. When the box had been checked it will refresh the page
     *
     * @param actionEvent Check box button
     */
    public void OnClickTakOrdProBox1(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + takeawayOrderID1 + "'";
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When takeaway order 2 has a problem this boxed can be clicked so the chef can
     * remake the order for the customer and updates the relevant information
     * in the database. When the box had been checked it will refresh the page
     *
     * @param actionEvent Check box button
     */
    public void OnClickTakOrdProBox2(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + takeawayOrderID2 + "'";
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When takeaway order 3 has a problem this boxed can be clicked so the chef can
     * remake the order for the customer and updates the relevant information
     * in the database. When the box had been checked it will refresh the page
     *
     * @param actionEvent Check box button
     */
    public void OnClickTakOrdProBox3(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + takeawayOrderID3 + "'";
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When takeaway order 4 has a problem this boxed can be clicked so the chef can
     * remake the order for the customer and updates the relevant information
     * in the database. When the box had been checked it will refresh the page
     *
     * @param actionEvent Check box button
     */
    public void OnClickTakOrdProBox4(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + takeawayOrderID4 + "'";
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When takeaway order 1 has been given to the customer and is all correct
     * a check box can be clicked to complete the order which changes the
     * relevant information on the database and removes the information
     * from the app. When the box has been clicked the page will
     * refresh
     *
     * @param actionEvent Check box button
     */
    public void OnClickTakOrdFinBox1(ActionEvent actionEvent) {
        String query = "UPDATE orders SET complete = 1 WHERE order_ID = '" + takeawayOrderID1 + "'";
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When takeaway order 2 has been given to the customer and is all correct
     * a check box can be clicked to complete the order which changes the
     * relevant information on the database and removes the information
     * from the app. When the box has been clicked the page will
     * refresh
     *
     * @param actionEvent Check box button
     */
    public void OnClickTakOrdFinBox2(ActionEvent actionEvent) {
        String query = "UPDATE orders SET complete = 1 WHERE order_ID = '" + takeawayOrderID2 + "'";
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When takeaway order 3 has been given to the customer and is all correct
     * a check box can be clicked to complete the order which changes the
     * relevant information on the database and removes the information
     * from the app. When the box has been clicked the page will
     * refresh
     *
     * @param actionEvent Check box button
     */
    public void OnClickTakOrdFinBox3(ActionEvent actionEvent) {
        String query = "UPDATE orders SET complete = 1 WHERE order_ID = '" + takeawayOrderID3 + "'";
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When takeaway order 4 has been given to the customer and is all correct
     * a check box can be clicked to complete the order which changes the
     * relevant information on the database and removes the information
     * from the app. When the box has been clicked the page will
     * refresh
     *
     * @param actionEvent Check box button
     */
    public void OnClickTakOrdFinBox4(ActionEvent actionEvent) {
        String query = "UPDATE orders SET complete = 1 WHERE order_ID = '" + takeawayOrderID4 + "'";
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When the refresh button has been clicked a new stage is set to refresh
     * all the relevant information on that page. This is done through an on click event
     *
     * @param actionEvent refresh button
     */
    @FXML
    public void refreshClick(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) refreshButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("waiter-view.fxml"));
            Parent newRoot = loader.load();

            WaiterController wCont = loader.getController();
            wCont.setUserText(username);
            wCont.setResOrdTab();
            wCont.setTakeawayOrdTable();
            wCont.resetCheckBoxes();

            stage.centerOnScreen();
            stage.setTitle("Waiter Homepage");
            stage.setHeight(530);
            //stage.setMaximized(true);
            stage.setMaxHeight(530);
            stage.setWidth(620);
            stage.setMaxWidth(620);
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * When this method is called it refreshes the page with the relevant information
     * too load the takeaway and restaurant orders
     */
    @FXML
    public void refresh() {
        try {
            Stage stage = (Stage) refreshButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("waiter-view.fxml"));
            Parent newRoot = loader.load();

            WaiterController wCont = loader.getController();
            wCont.setUserText(username);
            wCont.setResOrdTab();
            wCont.setTakeawayOrdTable();
            wCont.resetCheckBoxes();

            stage.centerOnScreen();
            stage.setTitle("Waiter Homepage");
            stage.setHeight(530);
            //stage.setMaximized(true);
            stage.setMaxHeight(530);
            stage.setWidth(620);
            stage.setMaxWidth(620);
            stage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void
     * This method is used to clear the check boxes on screen
     */
    public void resetCheckBoxes() {
        ResOrdFinBox1.setSelected(false);
        ResOrdFinBox2.setSelected(false);
        ResOrdFinBox3.setSelected(false);
        ResOrdFinBox4.setSelected(false);
        ResOrdProBox1.setSelected(false);
        ResOrdProBox2.setSelected(false);
        ResOrdProBox3.setSelected(false);
        ResOrdProBox4.setSelected(false);
        TakOrdProBox1.setSelected(false);
        TakOrdProBox2.setSelected(false);
        TakOrdProBox3.setSelected(false);
        TakOrdProBox4.setSelected(false);
        TakOrdFinBox1.setSelected(false);
        TakOrdFinBox2.setSelected(false);
        TakOrdFinBox3.setSelected(false);
        TakOrdFinBox4.setSelected(false);
    }
}