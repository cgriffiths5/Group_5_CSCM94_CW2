package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import static java.lang.Integer.parseInt;

/**
 * This controller represents a view for a driver after they have logged in on the system
 *
 * @author Chris Griffiths
 * @author Cameron Turner
 * @author Adam Tucker
 */
public class DriverController {
    @FXML
    public Label waiterName;
    public Label DevOrdTab1;
    public Label DevOrdTab2;
    public Label DevOrdTab3;
    public Label DevOrdTab4;


    public Button logoutBut;

    @FXML
    public CheckBox DevOrdFinBox1; //Delivery problem
    public CheckBox DevOrdFinBox2;
    public CheckBox DevOrdFinBox3;
    public CheckBox DevOrdFinBox4;
    public CheckBox DevOrdProBox1; //Delivery problem
    public CheckBox DevOrdProBox2;
    public CheckBox DevOrdProBox3;
    public CheckBox DevOrdProBox4;


    @FXML
    public Button refreshButton;
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");
    private String username;
    private int orderID1;
    private int orderID2;
    private int orderID3;
    private int orderID4;

    public DriverController() throws SQLException {
    }

    /**
     * Set label waiterName as text
     *
     * @param text
     */

    public void setUserText(String text) {
        waiterName.setText(username = text);
    }

    /**
     * When actionEvent is executed log out of the system
     *
     * @param actionEvent
     */


    public void logout(ActionEvent actionEvent) {
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * Sets the DevOrdTab labels with orders if delivery is required. Once executed if there is a delivery waiting the
     * text is set to the postcode of that delivery destination
     */

    public void setDevTab() {
        String query = "SELECT order_ID, house_number, postcode, complete FROM list_orders WHERE type='delivery' AND prepared=1 AND complete=0 ORDER BY date_time LIMIT 4";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int counter = 1;
            DevOrdTab1.setText("No Order");
            DevOrdTab2.setText("No Order");
            DevOrdTab3.setText("No Order");
            DevOrdTab4.setText("No Order");
            while (rs.next()) {
                String result = rs.getString("postcode");
                String hNumber = rs.getString("house_number");
                int resultID = parseInt(rs.getString("order_ID"));
                switch (counter) {
                    case 1 -> {
                        DevOrdTab1.setText(result + "  House Number: " + hNumber);
                        orderID1 = resultID;
                    }
                    case 2 -> {
                        DevOrdTab2.setText(result + "  House Number: " + hNumber);
                        orderID2 = resultID;
                    }
                    case 3 -> {
                        DevOrdTab3.setText(result + "  House Number: " + hNumber);
                        orderID3 = resultID;
                    }
                    case 4 -> {
                        DevOrdTab4.setText(result + "  House Number: " + hNumber);
                        orderID4 = resultID;
                    }
                    default -> {
                    }
                }
                counter++;
            }
            if (DevOrdTab1.getText().equals("postcode")) {
                DevOrdTab1.setText("No Order");
                DevOrdProBox1.setOpacity(0.0);
                DevOrdFinBox1.setOpacity(0.0);
            }
            if (DevOrdTab2.getText().equals("postcode")) {
                DevOrdTab2.setText("No Order");
                DevOrdProBox2.setOpacity(0.0);
                DevOrdFinBox2.setOpacity(0.0);
            }
            if (DevOrdTab3.getText().equals("postcode")) {
                DevOrdTab3.setText("No Order");
                DevOrdProBox3.setOpacity(0.0);
                DevOrdFinBox3.setOpacity(0.0);
            }
            if (DevOrdTab4.getText().equals("postcode")) {
                DevOrdTab4.setText("No Order");
                DevOrdProBox4.setOpacity(0.0);
                DevOrdFinBox4.setOpacity(0.0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * When actionEvent is triggered by a checkbox being checked then the order is marked as unprepared as there is
     * a problem with the delivered order.
     *
     * @param actionEvent
     */

    public void OnClickDevOrdProBox1(ActionEvent actionEvent) {
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
     * When actionEvent is triggered by a checkbox being checked then the order is marked as unprepared as there is
     * a problem with the delivered order.
     *
     * @param actionEvent
     */
    public void OnClickDevOrdProBox2(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + orderID2 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * When actionEvent is triggered by a checkbox being checked then the order is marked as unprepared as there is
     * a problem with the delivered order.
     *
     * @param actionEvent
     */
    public void OnClickDevOrdProBox3(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + orderID3 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * When actionEvent is triggered by a checkbox being checked then the order is marked as unprepared as there is
     * a problem with the delivered order.
     *
     * @param actionEvent
     */
    public void OnClickDevOrdProBox4(ActionEvent actionEvent) {
        String query = "UPDATE orders SET prepared = 0 WHERE order_ID = '" + orderID4 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * When actionEvent is triggered by a checkbox being checked the order is marked as complete in the database as
     * it has been delivered
     *
     * @param actionEvent
     */
    public void OnClickDevOrdFinBox1(ActionEvent actionEvent) {
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
     * When actionEvent is triggered by a checkbox being checked the order is marked as complete in the database as
     * it has been delivered
     *
     * @param actionEvent
     */
    public void OnClickDevOrdFinBox2(ActionEvent actionEvent) {
        String query = "UPDATE orders SET complete = 1 WHERE order_ID = '" + orderID2 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * When actionEvent is triggered by a checkbox being checked the order is marked as complete in the database as
     * it has been delivered
     *
     * @param actionEvent
     */
    public void OnClickDevOrdFinBox3(ActionEvent actionEvent) {
        String query = "UPDATE orders SET complete = 1 WHERE order_ID = '" + orderID3 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * When actionEvent is triggered by a checkbox being checked the order is marked as complete in the database as
     * it has been delivered
     *
     * @param actionEvent
     */
    public void OnClickDevOrdFinBox4(ActionEvent actionEvent) {
        String query = "UPDATE orders complete = 1 WHERE order_ID = '" + orderID4 + "'";

        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery(query);
            refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * When actionEvent is triggered by pressing the refresh button the page is reloaded and the deliveries are
     * updated
     *
     * @param actionEvent
     */
    @FXML
    public void refreshClick(ActionEvent actionEvent) {
        refresh();
    }

    /**
     * Whenever an order is clicked on and marked as finished or has problem then the page is refreshed and the
     * deliveries are updated
     */
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
            stage.setHeight(610);
            //stage.setMaximized(true);
            stage.setMaxHeight(610);
            stage.setWidth(675);
            stage.setMaxWidth(675);
            stage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetCheckBoxes() {
        DevOrdFinBox1.setSelected(false);
        DevOrdFinBox2.setSelected(false);
        DevOrdFinBox3.setSelected(false);
        DevOrdFinBox4.setSelected(false);
        DevOrdProBox1.setSelected(false);
        DevOrdProBox2.setSelected(false);
        DevOrdProBox3.setSelected(false);
        DevOrdProBox4.setSelected(false);

    }
}
