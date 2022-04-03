package com.cafe.group5a2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

public class OutstandingOrdersController {

    @FXML
    public Button ChefHomeReturn;
    public Button DisplayOrdersButton;
    public Button SubmitCompleteOrder;
    public TextField OrderID;

    ObservableList<String> list = FXCollections.observableArrayList();

    //Database connection
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    public OutstandingOrdersController() throws SQLException {
    }

    /**
     * A list of outstanding orders are displayed when this button is pressed
     * @throws SQLException
     */

    public void displayOutstandingOrders() throws SQLException {
        String query = "SELECT * FROM orders WHERE complete = 0;";

        list.clear();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                list.add(rs.getString("order_id") + " " + rs.getString("date_time") + " " + rs.getString("type") + "\n");
            }

            ObservableList orderList = list;

            Stage secondStage = new Stage();
            secondStage.setTitle("Outstanding Orders");

            final ListView listView = new ListView(orderList);
            listView.setPrefSize(200, 250);

            listView.setItems(orderList);

            StackPane root = new StackPane();
            root.getChildren().add(listView);
            secondStage.setScene(new Scene(root, 200, 250));
            secondStage.show();

        } catch (SQLException e) {
            System.out.println("Error Detected");
            e.printStackTrace();
        }

    }

    /**
     *
     * @param actionEvent when the order is completed the order id is entered and the corresponding entry for that order
     *                    is updated and marked as complete in the database
     * @throws SQLException
     */

    public void onSubmitCompletedOrderButtonClick(ActionEvent actionEvent) throws SQLException {

        String id = OrderID.getText();
        int order_id = Integer.parseInt(id);

        String query = "UPDATE orders SET prepared = 1 WHERE order_ID = '" + order_id + "';";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Errors Detected");
            e.printStackTrace();
        }
    }



    /**
     *
     * @param event when the return home button is pressed then the chef view FXML page is loaded
     */

    @FXML
    public void onChefHomeReturnClick(ActionEvent event) {
        try {
            Stage stage = (Stage) ChefHomeReturn.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chef-view.fxml")));
            stage.setTitle("Chef");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }


}
