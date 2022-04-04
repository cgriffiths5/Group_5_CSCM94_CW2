package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
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
 * Displays key information the chef needs about the
 * customer and is able to click buttons to view order
 * and update the database that an order has been
 * completed
 *
 * @author Cameron Turner
 * @author Adam Tucker
 * @version 1.0
 */
public class ChefOrdersController {
    @FXML
    public Button refreshButton;
    public Button returnToChefHome;

    @FXML
    public CheckBox checkBoxOrder1;
    public CheckBox checkBoxOrder2;
    public CheckBox checkBoxOrder3;
    public CheckBox checkBoxOrder4;
    @FXML
    public Button viewOrder1;
    public Button viewOrder2;
    public Button viewOrder3;
    public Button viewOrder4;
    @FXML
    public Label chefName;
    public Label label1;
    public Label label2;
    public Label label3;
    public Label label4;
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");
    private int orderID1;
    private int orderID2;
    private int orderID3;
    private int orderID4;
    private String username;

    /**
     * @throws SQLException throw a type of Exception that the IDE doesn't support
     */
    public ChefOrdersController() throws SQLException {
    }

    /**
     * Returns void
     * Sets the username
     *
     * @param text The users name
     */
    public void setUserTextOrders(String text) {
        username = text;
        chefName.setText(text);
    }

    /**
     * Returns void.
     * This method refreshes the current page and updates
     * all the information
     *
     * @param actionEvent Refresh button
     */
    @FXML
    public void onClickRefreshPage(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) refreshButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chefOrders.fxml"));
            Parent newRoot = loader.load();

            ChefOrdersController chefOrdCont = loader.getController();
            chefOrdCont.setUserTextOrders(username);
            chefOrdCont.setOrderID();

            stage.centerOnScreen();
            stage.setTitle("Chef Orders");
            stage.setHeight(530);
            stage.setMaxHeight(530);
            stage.setWidth(630);
            stage.setMaxWidth(630);
            stage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * This method changes the page to the chefs home page
     * when a button is pressed
     *
     * @param actionEvent Return to chef home button
     */
    @FXML
    public void onClickReturnChefHome(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) returnToChefHome.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chef-view.fxml"));
            Parent newRoot = loader.load();

            ChefController chefCont = loader.getController();
            chefCont.setUserText(username);

            stage.setTitle("Chef Home");
            stage.centerOnScreen();
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * Returns void.
     * This method sets the order ID label on the page with the table number
     * If there is no order then a "No Order" label will be shown
     * and the checkboxes will be removed
     */
    @FXML
    public void setOrderID() {
        String query = "SELECT order_ID, table_number, type FROM orders WHERE prepared=0 ORDER BY date_time LIMIT 4";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int counter = 1;
            label1.setText("No Order");
            label2.setText("No Order");
            label3.setText("No Order");
            label4.setText("No Order");
            while (rs.next()) {
                int resultID = parseInt(rs.getString("order_ID"));
                String type = rs.getString("type");
                switch (counter) {
                    case 1 -> {
                        orderID1 = resultID;
                        if (type.equals("seated")) label1.setText(("Table Number: " + rs.getString("table_number")));
                        else label1.setText(type);
                    }
                    case 2 -> {
                        orderID2 = resultID;
                        if (type.equals("seated")) label2.setText(("Table Number: " + rs.getString("table_number")));
                        else label2.setText(type);
                    }
                    case 3 -> {
                        orderID3 = resultID;
                        if (type.equals("seated")) label3.setText(("Table Number: " + rs.getString("table_number")));
                        else label3.setText(type);
                    }
                    case 4 -> {
                        orderID4 = resultID;
                        if (type.equals("seated")) label4.setText(("Table Number: " + rs.getString("table_number")));
                        else label4.setText(type);
                    }
                    default -> {
                    }
                }
                counter++;
            }
            if (label1.getText().equals("NAME")) {
                label1.setText("No Order");
                checkBoxOrder1.setOpacity(0.0);
            }
            if (label2.getText().equals("NAME")) {
                label2.setText("No Order");
                checkBoxOrder2.setOpacity(0.0);
            }
            if (label3.getText().equals("NAME")) {
                label3.setText("No Order");
                checkBoxOrder3.setOpacity(0.0);
            }
            if (label4.getText().equals("NAME")) {
                label4.setText("No Order");
                checkBoxOrder4.setOpacity(0.0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used when a checkbox is clicked to notify the waiter
     * the order is ready to be collected. The order is updated on the database
     *
     * @param actionEvent check box order 1 button
     */
    @FXML
    public void onClickCheckBoxOrder1(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 1 WHERE order_ID = '" + orderID1 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used when a checkbox is clicked to notify the waiter
     * the order is ready to be collected. The order is updated on the database
     *
     * @param actionEvent check box order 2 button
     */
    @FXML
    public void onClickCheckBoxOrder2(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 1 WHERE order_ID = '" + orderID2 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used when a checkbox is clicked to notify the waiter
     * the order is ready to be collected. The order is updated on the database
     *
     * @param actionEvent check box order 3 button
     */
    @FXML
    public void onClickCheckBoxOrder3(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 1 WHERE order_ID = '" + orderID3 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used when a checkbox is clicked to notify the waiter
     * the order is ready to be collected. The order is updated on the database
     *
     * @param actionEvent check box order 4 button
     */
    @FXML
    public void onClickCheckBoxOrder4(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 1 WHERE order_ID = '" + orderID4 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will show the particular customers' menu order
     * by opening a new page
     *
     * @param actionEvent View Order 1 button
     */
    @FXML
    public void onClickViewOrder1(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chefMenuOrder.fxml"));
            Parent newRoot = loader.load();

            ChefCustOrderController chefCustOrdCont = loader.getController();
            chefCustOrdCont.setUserText(username);
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            chefCustOrdCont.setItemsAndQuant(orderID1);
            stage.setTitle("Customers Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * This method will show the particular customers' menu order
     * by opening a new page
     *
     * @param actionEvent View Order 2 button
     */
    @FXML
    public void onClickViewOrder2(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chefMenuOrder.fxml"));
            Parent newRoot = loader.load();

            ChefCustOrderController chefCustOrdCont = loader.getController();
            chefCustOrdCont.setUserText(username);
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            chefCustOrdCont.setItemsAndQuant(orderID2);
            stage.setTitle("Customers Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * This method will show the particular customers' menu order
     * by opening a new page
     *
     * @param actionEvent View Order 3 button
     */
    @FXML
    public void onClickViewOrder3(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chefMenuOrder.fxml"));
            Parent newRoot = loader.load();

            ChefCustOrderController chefCustOrdCont = loader.getController();
            chefCustOrdCont.setUserText(username);
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            chefCustOrdCont.setItemsAndQuant(orderID3);
            stage.setTitle("Customers Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * This method will show the particular customers' menu order
     * by opening a new page
     *
     * @param actionEvent View Order 4 button
     */
    @FXML
    public void onClickViewOrder4(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chefMenuOrder.fxml"));
            Parent newRoot = loader.load();

            ChefCustOrderController chefCustOrdCont = loader.getController();
            chefCustOrdCont.setUserText(username);
            stage.centerOnScreen();
            stage.setY(0);
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(500);
            stage.setMaxWidth(500);
            chefCustOrdCont.setItemsAndQuant(orderID4);
            stage.setTitle("Customers Order");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * Returns void.
     * This method is called when the page needs to be refreshed and
     * all the values are updated
     */
    @FXML
    public void refresh() {
        try {
            Stage stage = (Stage) refreshButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chefOrders.fxml"));
            Parent newRoot = loader.load();

            ChefOrdersController chefOrdCont = loader.getController();
            chefOrdCont.setUserTextOrders(username);
            chefOrdCont.setOrderID();
            chefOrdCont.resetCheckBoxes();

            stage.centerOnScreen();
            stage.setTitle("Chef Orders");
            stage.setHeight(530);
            stage.setMaxHeight(530);
            stage.setWidth(630);
            stage.setMaxWidth(630);
            stage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * This method is called to reset all the checkboxes
     */
    @FXML
    public void resetCheckBoxes() {
        checkBoxOrder1.setSelected(false);
        checkBoxOrder2.setSelected(false);
        checkBoxOrder3.setSelected(false);
        checkBoxOrder4.setSelected(false);
    }
}
