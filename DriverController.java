package com.cafe.group5a2;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

import static java.lang.Integer.parseInt;

public class DriverController {
    @FXML
    public Label waiterName;
    public Label ResOrdTab1;
    public Label ResOrdTab2;
    public Label ResOrdTab3;
    public Label ResOrdTab4;


    public Button logoutBut;

    @FXML
    public CheckBox ResOrdFinBox1; //Delivery problem
    public CheckBox ResOrdFinBox2;
    public CheckBox ResOrdFinBox3;
    public CheckBox ResOrdFinBox4;
    public CheckBox ResOrdProBox1; //Delivery problem
    public CheckBox ResOrdProBox2;
    public CheckBox ResOrdProBox3;
    public CheckBox ResOrdProBox4;


    @FXML
    public Button refreshButton;


    private String username;
    private int orderID1;
    private int orderID2;
    private int orderID3;
    private int orderID4;


    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");
    public DriverController() throws SQLException {
    }


    public void setUserText(String text) {
        waiterName.setText(username = text);
    }


    public void logout(ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }


    public void setDevTab() {
        String query = "SELECT order_ID, house_number, postcode, complete FROM list_orders WHERE type='delivery' AND prepared=1 AND complete=0 ORDER BY date_time LIMIT 4";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int counter = 1;
            ResOrdTab1.setText("No Order");
            ResOrdTab2.setText("No Order");
            ResOrdTab3.setText("No Order");
            ResOrdTab4.setText("No Order");
            while (rs.next()) {
                String result = rs.getString("postcode");
                int resultID = parseInt(rs.getString("order_ID"));
                switch (counter) {
                    case 1 -> {
                        ResOrdTab1.setText(result);
                        orderID1 = resultID;
                    }
                    case 2 -> {
                        ResOrdTab2.setText(result);
                        orderID2 = resultID;
                    }
                    case 3 -> {
                        ResOrdTab3.setText(result);
                        orderID3 = resultID;
                    }
                    case 4 -> {
                        ResOrdTab4.setText(result);
                        orderID4 = resultID;
                    }
                    default -> {
                    }
                }
                counter++;
            }
            if(ResOrdTab1.getText().equals("postcode")){
                ResOrdTab1.setText("No Order");
                ResOrdProBox1.setOpacity(0.0); ResOrdFinBox1.setOpacity(0.0);
            }
            if(ResOrdTab2.getText().equals("postcode")){
                ResOrdTab2.setText("No Order");
                ResOrdProBox2.setOpacity(0.0); ResOrdFinBox2.setOpacity(0.0);
            }
            if(ResOrdTab3.getText().equals("postcode")){
                ResOrdTab3.setText("No Order");
                ResOrdProBox3.setOpacity(0.0); ResOrdFinBox3.setOpacity(0.0);
            }
            if(ResOrdTab4.getText().equals("postcode")){
                ResOrdTab4.setText("No Order");
                ResOrdProBox4.setOpacity(0.0); ResOrdFinBox4.setOpacity(0.0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //Delivery problem

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

    public void OnClickResOrdProBox2(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + orderID2 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void OnClickResOrdProBox3(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + orderID3 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void OnClickResOrdProBox4(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + orderID4 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Delivery finished

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

    public void OnClickResOrdFinBox2(ActionEvent actionEvent) {
        String query = "UPDATE orders SET complete = 1 WHERE order_ID = '" + orderID2 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void OnClickResOrdFinBox3(ActionEvent actionEvent) {
        String query = "UPDATE orders SET complete = 1 WHERE order_ID = '" + orderID3 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void OnClickResOrdFinBox4(ActionEvent actionEvent) {
        String query = "UPDATE orders complete = 1 WHERE order_ID = '" + orderID4 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void refreshClick(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) refreshButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("driver-view.fxml"));
            Parent newRoot = loader.load();

            DriverController dCont = loader.getController();
            dCont.setUserText(username);
            dCont.setDevTab();
            dCont.resetCheckBoxes();

            stage.centerOnScreen();
            stage.setTitle("Driver Homepage");
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

    @FXML
    public void refresh() {
        try {
            Stage stage = (Stage) refreshButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("driver-view.fxml"));
            Parent newRoot = loader.load();

            DriverController dCont = loader.getController();
            dCont.setUserText(username);
            dCont.setDevTab();
            dCont.resetCheckBoxes();

            stage.centerOnScreen();
            stage.setTitle("Driver Homepage");
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


    public void resetCheckBoxes() {
        ResOrdFinBox1.setSelected(false);
        ResOrdFinBox2.setSelected(false);
        ResOrdFinBox3.setSelected(false);
        ResOrdFinBox4.setSelected(false);
        ResOrdProBox1.setSelected(false);
        ResOrdProBox2.setSelected(false);
        ResOrdProBox3.setSelected(false);
        ResOrdProBox4.setSelected(false);

    }
}