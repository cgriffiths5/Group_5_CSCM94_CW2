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
import java.util.Objects;

import static java.lang.Integer.parseInt;

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

    private int orderID1;
    private int orderID2;
    private int orderID3;
    private int orderID4;

    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");
    private String username;
    public ChefOrdersController() throws SQLException {
    }
    @FXML
    public void setUserTextOrders(String text) {
        username = text;
        chefName.setText(text);
    }
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
                        if (type.equals("seated")) label1.setText((rs.getString("table_number")));
                        else label1.setText(type);
                    }
                    case 2 -> {
                        orderID2 = resultID;
                        if (type.equals("seated")) label2.setText((rs.getString("table_number")));
                        else label2.setText(type);
                    }
                    case 3 -> {
                        orderID3 = resultID;
                        if (type.equals("seated")) label3.setText((rs.getString("table_number")));
                        else label3.setText(type);
                    }
                    case 4 -> {
                        orderID4 = resultID;
                        if (type.equals("seated")) label4.setText((rs.getString("table_number")));
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

    @FXML
    public void onClickViewOrder1(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) viewOrder1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chefMenuOrder.fxml"));
            Parent newRoot = loader.load();
            Rectangle2D sBound = Screen.getPrimary().getVisualBounds();

            ChefCustOrderController chefCustOrdCont = loader.getController();
            //

            //
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

    public void onClickViewOrder2(ActionEvent actionEvent) {
    }

    public void onClickViewOrder3(ActionEvent actionEvent) {
    }

    public void onClickViewOrder4(ActionEvent actionEvent) {
    }

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
    @FXML
    public void resetCheckBoxes() {
        checkBoxOrder1.setSelected(false);
        checkBoxOrder2.setSelected(false);
        checkBoxOrder3.setSelected(false);
        checkBoxOrder4.setSelected(false);
    }
}
