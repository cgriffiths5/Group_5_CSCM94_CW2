package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * This class shows the customer an order that they had made previously
 *
 * @author Adam Tucker
 * @version 1.0
 */
public class CustomerViewOrderController {

    public ScrollPane mainPane;
    public AnchorPane aPane;
    public Label il1;
    public Label il2;
    public Label il3;
    public Label il4;
    public Label il5;
    public Label il6;
    public Label il7;
    public Label il8;
    public Label il9;
    public Label il10;
    public Label il11;
    public Label il12;
    public Label il13;
    public Label il14;
    public Label il15;
    public Label il16;
    public Label il17;
    public Label il18;
    public Label il19;
    public Label il20;
    public Label ql1;
    public Label ql2;
    public Label ql3;
    public Label ql4;
    public Label ql5;
    public Label ql6;
    public Label ql7;
    public Label ql8;
    public Label ql9;
    public Label ql10;
    public Label ql11;
    public Label ql12;
    public Label ql13;
    public Label ql14;
    public Label ql15;
    public Label ql16;
    public Label ql17;
    public Label ql18;
    public Label ql19;
    public Label ql20;
    public HBox h2i;
    public HBox h3i;
    public HBox h4i;
    public HBox h5i;
    public HBox h6i;
    public HBox h7i;
    public HBox h8i;
    public HBox h9i;
    public HBox h10i;
    public HBox h11i;
    public HBox h12d;
    public HBox h13i;
    public HBox h14i;
    public HBox h15i;
    public HBox h16i;
    public HBox h17i;
    public HBox h18i;
    public HBox h19i;
    public HBox h20i;

    public Button goBack;
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");
    private String username;

    /**
     * @throws SQLException throw a type of Exception that the IDE doesn't support
     */
    public CustomerViewOrderController() throws SQLException {
    }

    /**
     *
     * @param text username from previous view
     */
    public void setUser(String text) {
        username = text;
    }

    /**
     * Returns void.
     * This method puts all the items and the quantity of items
     * ordered by the customer on the page
     *
     * @param orderID The customers orderID
     */
    public void setItemsAndQuant(int orderID) {

        String query = "SELECT * FROM items_separate_orders WHERE complete= 1 AND order_ID = '" + orderID + "' ORDER BY date_time";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int count1 = 0;
                int count2 = 0;
                int count3 = 0;
                int count4 = 0;
                int count5 = 0;
                int count6 = 0;
                int count7 = 0;
                int count8 = 0;
                int count9 = 0;
                int count10 = 0;
                int count11 = 0;
                int count12 = 0;
                int count13 = 0;
                int count14 = 0;
                int count15 = 0;
                int count16 = 0;
                int count17 = 0;
                int count18 = 0;
                int count19 = 0;
                int count20 = 0;
                String r1 = rs.getString("1st");
                String r2 = rs.getString("2nd");
                String r3 = rs.getString("3rd");
                String r4 = rs.getString("4th");
                String r5 = rs.getString("5th");
                String r6 = rs.getString("6th");
                String r7 = rs.getString("7th");
                String r8 = rs.getString("8th");
                String r9 = rs.getString("9th");
                String r10 = rs.getString("10th");
                String r11 = rs.getString("11th");
                String r12 = rs.getString("12th");
                String r13 = rs.getString("13th");
                String r14 = rs.getString("14th");
                String r15 = rs.getString("15th");
                String r16 = rs.getString("16th");
                String r17 = rs.getString("17th");
                String r18 = rs.getString("18th");
                String r19 = rs.getString("19th");
                String r20 = rs.getString("20th");
                String r21 = rs.getString("21st");
                String r22 = rs.getString("22nd");
                String r23 = rs.getString("23rd");
                String r24 = rs.getString("24th");
                String r25 = rs.getString("25th");
                String r26 = rs.getString("26th");
                String r27 = rs.getString("27th");
                String r28 = rs.getString("28th");
                String r29 = rs.getString("29th");
                String r30 = rs.getString("30th");

                String[] r = new String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17,
                        r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30};
                List<String> itemsUnique = new ArrayList<>(new LinkedHashSet<>(List.of(r)));
                String[] items = new String[itemsUnique.size()];
                if (!itemsUnique.isEmpty()) {
                    items = itemsUnique.toArray(items);
                }

                int i = 0;
                int previousPointer = 0;
                int k = 0;
                if (items.length > 0) {

                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1 - 1) {
                        i++;
                    }
                    count1 = i - previousPointer;
                    previousPointer = i;

                    k = 1;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1 - 1) {
                        i++;
                    }
                    count2 = i - previousPointer;
                    previousPointer = i;

                    k = 2;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1 - 1) {
                        i++;
                    }
                    count3 = i - previousPointer;
                    previousPointer = i;

                    k = 3;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count4 = i - previousPointer;
                    previousPointer = i;

                    k = 4;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count5 = i - previousPointer;
                    previousPointer = i;
                    k = 5;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count6 = i - previousPointer;
                    previousPointer = i;
                    k = 6;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count7 = i - previousPointer;
                    previousPointer = i;
                    k = 7;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count8 = i - previousPointer;
                    previousPointer = i;
                    k = 8;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count9 = i - previousPointer;
                    previousPointer = i;
                    k = 9;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count10 = i - previousPointer;
                    previousPointer = i;
                    k = 10;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count11 = i - previousPointer;
                    previousPointer = i;
                    k = 11;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count12 = i - previousPointer;
                    previousPointer = i;
                    k = 12;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count13 = i - previousPointer;
                    previousPointer = i;
                    k = 13;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count14 = i - previousPointer;
                    previousPointer = i;
                    k = 14;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count15 = i - previousPointer;
                    previousPointer = i;
                    k = 15;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count16 = i - previousPointer;
                    previousPointer = i;
                    k = 16;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count17 = i - previousPointer;
                    previousPointer = i;
                    k = 17;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count18 = i - previousPointer;
                    previousPointer = i;
                    k = 18;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count19 = i - previousPointer;
                    previousPointer = i;
                    k = 19;
                    while (k < items.length && items[k].equals(r[i]) && i < r.length - 1) {
                        i++;
                    }
                    count20 = i - previousPointer;
                    previousPointer = i;

                }


                int length = items.length - 1;
                int j = 0;
                while (j < length) {
                    if (j == 0) {
                        il1.setText(items[j]);
                        ql1.setText(String.valueOf(count1));
                    }
                    if (j == 1) {
                        il2.setText(items[j]);
                        ql2.setText(String.valueOf(count2));
                    }
                    if (j == 2) {
                        il3.setText(items[j]);
                        ql3.setText(String.valueOf(count3));
                    }
                    if (j == 3) {
                        il4.setText(items[j]);
                        ql4.setText(String.valueOf(count4));
                    }
                    if (j == 4) {
                        il5.setText(items[j]);
                        ql5.setText(String.valueOf(count5));
                    }
                    if (j == 5) {
                        il6.setText(items[j]);
                        ql6.setText(String.valueOf(count6));
                    }
                    if (j == 6) {
                        il7.setText(items[j]);
                        ql7.setText(String.valueOf(count7));
                    }
                    if (j == 7) {
                        il8.setText(items[j]);
                        ql8.setText(String.valueOf(count8));
                    }
                    if (j == 8) {
                        il9.setText(items[j]);
                        ql9.setText(String.valueOf(count9));
                    }
                    if (j == 9) {
                        il10.setText(items[j]);
                        ql10.setText(String.valueOf(count10));
                    }
                    if (j == 10) {
                        il11.setText(items[j]);
                        ql11.setText(String.valueOf(count11));
                    }
                    if (j == 11) {
                        il12.setText(items[j]);
                        ql12.setText(String.valueOf(count12));
                    }
                    if (j == 12) {
                        il13.setText(items[j]);
                        ql13.setText(String.valueOf(count13));
                    }
                    if (j == 13) {
                        il14.setText(items[j]);
                        ql14.setText(String.valueOf(count14));
                    }
                    if (j == 14) {
                        il15.setText(items[j]);
                        ql15.setText(String.valueOf(count15));
                    }
                    if (j == 15) {
                        il16.setText(items[j]);
                        ql16.setText(String.valueOf(count16));
                    }
                    if (j == 16) {
                        il17.setText(items[j]);
                        ql17.setText(String.valueOf(count17));
                    }
                    if (j == 17) {
                        il18.setText(items[j]);
                        ql18.setText(String.valueOf(count18));
                    }
                    if (j == 18) {
                        il19.setText(items[j]);
                        ql19.setText(String.valueOf(count19));
                    }
                    if (j == 19) {
                        il20.setText(items[j]);
                        ql20.setText(String.valueOf(count20));
                    }
                    j++;
                }
                double paneSize = 890;
                double interval = 49;
                if (il1.getText().equals("Item")) {
                    il1.setOpacity(0);
                    ql1.setOpacity(0);
                }
                if (il2.getText().equals("Item")) {
                    il2.setOpacity(0);
                    ql2.setOpacity(0);
                }
                if (il3.getText().equals("Item")) {
                    il3.setOpacity(0);
                    ql3.setOpacity(0);
                }
                if (il4.getText().equals("Item")) {
                    il4.setOpacity(0);
                    ql4.setOpacity(0);
                }
                if (il5.getText().equals("Item")) {
                    il5.setOpacity(0);
                    ql5.setOpacity(0);
                }
                if (il6.getText().equals("Item")) {
                    il6.setOpacity(0);
                    ql6.setOpacity(0);
                }
                if (il7.getText().equals("Item")) {
                    il7.setOpacity(0);
                    ql7.setOpacity(0);
                }
                if (il8.getText().equals("Item")) {
                    il8.setOpacity(0);
                    ql8.setOpacity(0);
                }
                if (il9.getText().equals("Item")) {
                    il9.setOpacity(0);
                    ql9.setOpacity(0);
                }
                if (il10.getText().equals("Item")) {
                    il10.setOpacity(0);
                    ql10.setOpacity(0);
                    paneSize -= interval;
                }
                if (il11.getText().equals("Item")) {
                    il11.setOpacity(0);
                    ql11.setOpacity(0);
                    paneSize -= interval;
                }
                if (il12.getText().equals("Item")) {
                    il12.setOpacity(0);
                    ql12.setOpacity(0);
                    paneSize -= interval;
                }
                if (il13.getText().equals("Item")) {
                    il13.setOpacity(0);
                    ql13.setOpacity(0);
                    paneSize -= interval;
                }
                if (il14.getText().equals("Item")) {
                    il14.setOpacity(0);
                    ql14.setOpacity(0);
                    paneSize -= interval;
                }
                if (il15.getText().equals("Item")) {
                    il15.setOpacity(0);
                    ql15.setOpacity(0);
                    paneSize -= interval;
                }
                if (il16.getText().equals("Item")) {
                    il16.setOpacity(0);
                    ql16.setOpacity(0);
                    paneSize -= interval;
                }
                if (il17.getText().equals("Item")) {
                    il17.setOpacity(0);
                    ql17.setOpacity(0);
                    paneSize -= interval;
                }
                if (il18.getText().equals("Item")) {
                    il18.setOpacity(0);
                    ql18.setOpacity(0);
                    paneSize -= interval;
                }
                if (il19.getText().equals("Item")) {
                    il19.setOpacity(0);
                    ql19.setOpacity(0);
                    paneSize -= interval;
                }
                if (il20.getText().equals("Item")) {
                    il20.setOpacity(0);
                    ql20.setOpacity(0);
                    paneSize -= interval;
                }
                aPane.setMaxHeight(paneSize);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void
     * takes the user back to the Order History page when the Go back button is
     * clicked
     *
     * @param actionEvent is entered when a user presses the home button
     */
    public void onClickGoBack(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) goBack.getScene().getWindow();
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
}