package com.cafe.group5a2;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

import static java.lang.Integer.parseInt;

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
    public CheckBox OnClickTakOrdProBox1; //Takeaway problem
    public CheckBox OnClickTakOrdProBox2;
    public CheckBox OnClickTakOrdProBox3;
    public CheckBox OnClickTakOrdProBox4;
    public CheckBox OnClickTakOrdFinBox1; //Takeaway finished
    public CheckBox OnClickTakOrdFinBox2;
    public CheckBox OnClickTakOrdFinBox3;
    public CheckBox OnClickTakOrdFinBox4;
    public CheckBox OnClickResOrdProBox1; //restaurant problem
    public CheckBox OnClickResOrdProBox2;
    public CheckBox OnClickResOrdProBox3;
    public CheckBox OnClickResOrdProBox4;
    public CheckBox OnClickResOrdFinBox1; //restaurant finished
    public CheckBox OnClickResOrdFinBox2;
    public CheckBox OnClickResOrdFinBox3;
    public CheckBox OnClickResOrdFinBox4;


    private String username;
    public String orderID1;
    public String orderID2;
    public String orderID3;
    public String orderID4;



    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");
    public WaiterController() throws SQLException {
    }




    public void setUserText(String text) {
        waiterName.setText(username = text);
    }


    public void logout(ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }


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
            stage.setX(((sBound.getWidth() - stage.getWidth())/2) - (sBound.getWidth() / 10));
            stage.setY(((sBound.getHeight() - stage.getWidth())/2) - (sBound.getHeight() / 4));
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


    public void approveBooking(ActionEvent actionEvent) {

    }


    public void setResOrdTab() {
        String query = "SELECT order_ID, table_number, complete FROM orders WHERE type='seated' AND prepared=1 AND complete=0 ORDER BY date_time LIMIT 4";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int counter = 1;
            while (rs.next()) {
                int result = parseInt(rs.getString("table_number"));
                switch (counter) {
                    case 1 -> ResOrdTab1.setText(String.valueOf(result));
                    case 2 -> ResOrdTab2.setText(String.valueOf(result));
                    case 3 -> ResOrdTab3.setText(String.valueOf(result));
                    case 4 -> ResOrdTab4.setText(String.valueOf(result));
                    default -> {
                    }
                }
                counter++;
            }
            if(ResOrdTab1.getText().equals("Table number")){
                ResOrdTab1.setText("No Order");
                ResOrdProBox1.setOpacity(0.0); ResOrdFinBox1.setOpacity(0.0);
            }
            if(ResOrdTab2.getText().equals("Table number")){
                ResOrdTab2.setText("No Order");
                ResOrdProBox2.setOpacity(0.0); ResOrdFinBox2.setOpacity(0.0);
            }
            if(ResOrdTab3.getText().equals("Table number")){
                ResOrdTab3.setText("No Order");
                ResOrdProBox3.setOpacity(0.0); ResOrdFinBox3.setOpacity(0.0);
            }
            if(ResOrdTab4.getText().equals("Table number")){
                ResOrdTab4.setText("No Order");
                ResOrdProBox4.setOpacity(0.0); ResOrdFinBox4.setOpacity(0.0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setTakeawayOrdTable() {
        String query = "SELECT f_name FROM list_orders WHERE type = 'takeaway' AND prepared = 1 AND complete = 0 ORDER BY date_time ASC LIMIT 4" ;
        String query2 = "SELECT l_name FROM list_orders WHERE type = 'takeaway' AND prepared = 1 AND complete = 0 ORDER BY date_time ASC LIMIT 4" ;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            ResultSet rs2 = stmt.executeQuery(query2);
            int counter = 1;
            while (rs.next() && rs2.next()) {
                String result = (rs.getString("f_name"));
                String result2 = (rs2.getString("l_name"));
                String result3 = result + " " + result2;
                switch (counter) {
                    case 1 -> TakOrdCust1.setText(result3);
                    case 2 -> TakOrdCust2.setText(result3);
                    case 3 -> TakOrdCust3.setText(result3);
                    case 4 -> TakOrdCust4.setText(result3);
                    default -> {
                    }
                }
                counter++;
            }
            if(TakOrdCust1.getText().equals("first name last name")){
                TakOrdCust1.setText("No Order");
                TakOrdProBox1.setOpacity(0.0); TakOrdFinBox1.setOpacity(0.0);
            }
            if(TakOrdCust2.getText().equals("first name last name")){
                TakOrdCust2.setText("No Order");
                TakOrdProBox2.setOpacity(0.0); TakOrdFinBox2.setOpacity(0.0);
            }
            if(TakOrdCust3.getText().equals("first name last name")){
                TakOrdCust3.setText("No Order");
                TakOrdProBox3.setOpacity(0.0); TakOrdFinBox3.setOpacity(0.0);
            }
            if(TakOrdCust4.getText().equals("first name last name")){
                TakOrdCust4.setText("No Order");
                TakOrdProBox4.setOpacity(0.0); TakOrdFinBox4.setOpacity(0.0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //restaurant problem

    public void OnClickResOrdProBox1(ActionEvent actionEvent) {
        /*
        when check box has been clicked. this needs to send order
        back to the kitchen to be remade

        UPDATE orders SET complete = 1 WHERE order_ID = orderIDLabel1

        UPDATE orders SET complete = 1 WHERE order_ID = orderIDLabel2
        */
        
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void OnClickResOrdProBox2(ActionEvent actionEvent) {

    }

    public void OnClickResOrdProBox3(ActionEvent actionEvent) {

    }

    public void OnClickResOrdProBox4(ActionEvent actionEvent) {

    }

    //restaurant finished

    public void OnClickResOrdFinBox1(ActionEvent actionEvent) {
        /*
        When check box has been clicked.
         */
    }

    public void OnClickResOrdFinBox2(ActionEvent actionEvent) {

    }

    public void OnClickResOrdFinBox3(ActionEvent actionEvent) {

    }

    public void OnClickResOrdFinBox4(ActionEvent actionEvent) {

    }

    //Takeaway problem

    public void OnClickTakOrdProBox1(ActionEvent actionEvent) {

    }

    public void OnClickTakOrdProBox2(ActionEvent actionEvent) {

    }

    public void OnClickTakOrdProBox3(ActionEvent actionEvent) {

    }

    public void OnClickTakOrdProBox4(ActionEvent actionEvent) {

    }

    //Takeaway finished

    public void OnClickTakOrdFinBox1(ActionEvent actionEvent) {

    }

    public void OnClickTakOrdFinBox2(ActionEvent actionEvent) {

    }

    public void OnClickTakOrdFinBox3(ActionEvent actionEvent) {

    }

    public void OnClickTakOrdFinBox4(ActionEvent actionEvent) {

    }
}
