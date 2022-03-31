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

public class ChefCustOrderController {

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

    private String username;

    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    public ChefCustOrderController() throws SQLException {
    }

    public void setItemsAndQuant(int orderID) {
        String query = "SELECT * FROM items_separate_orders WHERE prepared=0 AND complete=0 AND order_ID = '" + orderID + "' ORDER BY date_time";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<String> items = new ArrayList<>();
            while (rs.next()) {
                String item1 = rs.getString("1st");
                items.add(item1);
                String item2 = rs.getString("2nd");
                items.add(item2);
                String item3 = rs.getString("3rd");
                items.add(item3);
                String item4 = rs.getString("4th");
                items.add(item4);
                String item5 = rs.getString("5th");
                items.add(item5);
                String item6 = rs.getString("6th");
                items.add(item6);
                String item7 = rs.getString("7th");
                items.add(item7);
                String item8 = rs.getString("8th");
                items.add(item8);
                String item9 = rs.getString("9th");
                items.add(item9);
                String item10 = rs.getString("10th");
                items.add(item10);
                String item11 = rs.getString("11th");
                items.add(item11);
                String item12 = rs.getString("12th");
                items.add(item12);
                String item13 = rs.getString("13th");
                items.add(item13);
                String item14 = rs.getString("14th");
                items.add(item14);
                String item15 = rs.getString("15th");
                items.add(item15);
                String item16 = rs.getString("16th");
                items.add(item16);
                String item17 = rs.getString("17th");
                items.add(item17);
                String item18 = rs.getString("18th");
                items.add(item18);
                String item19 = rs.getString("19th");
                items.add(item19);
                String item20 = rs.getString("20th");
                items.add(item20);
                String item21 = rs.getString("21st");
                items.add(item21);
                String item22 = rs.getString("22nd");
                items.add(item22);
                String item23 = rs.getString("23rd");
                items.add(item23);
                String item24 = rs.getString("24th");
                items.add(item24);
                String item25 = rs.getString("25th");
                items.add(item25);
                String item26 = rs.getString("26th");
                items.add(item26);
                String item27 = rs.getString("27th");
                items.add(item27);
                String item28 = rs.getString("28th");
                items.add(item28);
                String item29 = rs.getString("29th");
                items.add(item29);
                String item30 = rs.getString("30th");
                items.add(item30);

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
                int count21 = 0;
                int count22 = 0;
                int count23 = 0;
                int count24 = 0;
                int count25 = 0;
                int count26 = 0;
                int count27 = 0;
                int count28 = 0;
                int count29 = 0;
                int count30 = 0;


                items.removeIf(String::isEmpty);
                if (items.size() > 0) {
                    for (int i = 0; i < items.size() - 1; i++) {
                        if (i == 0) {
                            count1++;
                        } else {
                            String previous = items.get(i - 1);
                            if (items.get(i).equals(previous)) {
                                if (previous.equals(item1)) {
                                    items.remove(i);
                                    count1++;
                                } else if (previous.equals(item2)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item3)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item4)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item5)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item6)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item7)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item8)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item9)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item10)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item11)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item12)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item13)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item14)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item15)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item16)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item17)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item18)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item19)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item20)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item21)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item22)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item23)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item24)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item25)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item26)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item27)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item28)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item29)) {
                                    items.remove(i);
                                    count2++;
                                } else if (previous.equals(item30)) {
                                    items.remove(i);
                                    count2++;
                                }
                            }
                        }
                    }
                    int size = items.size() - 1;
                    int i = 0;
                    while (i < size) {
                        if (i == 0) il1.setText(items.get(i));   ql1.setText( String.valueOf(count1 ));
                        if (i == 1) il2.setText(items.get(i));   ql2.setText( String.valueOf(count2 ));
                        if (i == 2) il3.setText(items.get(i));   ql3.setText( String.valueOf(count3 ));
                        if (i == 3) il4.setText(items.get(i));   ql4.setText( String.valueOf(count4 ));
                        if (i == 4) il5.setText(items.get(i));   ql5.setText( String.valueOf(count5 ));
                        if (i == 5) il6.setText(items.get(i));   ql6.setText( String.valueOf(count6 ));
                        if (i == 6) il7.setText(items.get(i));   ql7.setText( String.valueOf(count7 ));
                        if (i == 7) il8.setText(items.get(i));   ql8.setText( String.valueOf(count8 ));
                        if (i == 8) il9.setText(items.get(i));   ql9.setText( String.valueOf(count9 ));
                        if (i == 9) il10.setText(items.get(i));  ql10.setText(String.valueOf(count10));
                        if (i == 10) il11.setText(items.get(i)); ql11.setText(String.valueOf(count11));
                        if (i == 11) il12.setText(items.get(i)); ql12.setText(String.valueOf(count12));
                        if (i == 12) il13.setText(items.get(i)); ql13.setText(String.valueOf(count13));
                        if (i == 13) il14.setText(items.get(i)); ql14.setText(String.valueOf(count14));
                        if (i == 14) il15.setText(items.get(i)); ql15.setText(String.valueOf(count15));
                        if (i == 15) il16.setText(items.get(i)); ql16.setText(String.valueOf(count16));
                        if (i == 16) il17.setText(items.get(i)); ql17.setText(String.valueOf(count17));
                        if (i == 17) il18.setText(items.get(i)); ql18.setText(String.valueOf(count18));
                        if (i == 18) il19.setText(items.get(i)); ql19.setText(String.valueOf(count19));
                        if (i == 19) il20.setText(items.get(i)); ql20.setText(String.valueOf(count20));
                        i++;
                    }
                    double paneSize = 890;
                    double interval = 59;
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
                        paneSize-=interval;
                    }
                    if (il11.getText().equals("Item")) {
                        il11.setOpacity(0);
                        ql11.setOpacity(0);
                        paneSize-=interval;
                    }
                    if (il12.getText().equals("Item")) {
                        il12.setOpacity(0);
                        ql12.setOpacity(0);
                        paneSize-=interval;
                    }
                    if (il13.getText().equals("Item")) {
                        il13.setOpacity(0);
                        ql13.setOpacity(0);
                        paneSize -= interval;
                    }
                    if (il14.getText().equals("Item")) {
                        il14.setOpacity(0);
                        ql14.setOpacity(0);
                        paneSize-=interval;
                    }
                    if (il15.getText().equals("Item")) {
                        il15.setOpacity(0);
                        ql15.setOpacity(0);
                        paneSize-=interval;
                    }
                    if (il16.getText().equals("Item")) {
                        il16.setOpacity(0);
                        ql16.setOpacity(0);
                        paneSize-=interval;
                    }
                    if (il17.getText().equals("Item")) {
                        il17.setOpacity(0);
                        ql17.setOpacity(0);
                        paneSize-=interval;
                    }
                    if (il18.getText().equals("Item")) {
                        il18.setOpacity(0);
                        ql18.setOpacity(0);
                        paneSize-=interval;
                    }
                    if (il19.getText().equals("Item")) {
                        il19.setOpacity(0);
                        ql19.setOpacity(0);
                        paneSize-=interval;
                    }
                    if (il20.getText().equals("Item")) {
                        il20.setOpacity(0);
                        ql20.setOpacity(0);
                        paneSize-=interval;
                    }
                    aPane.setMaxHeight(paneSize);
                    mainPane.setMaxHeight(paneSize);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void onClickGoBack(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) goBack.getScene().getWindow();
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
            System.out.println("Error loading page");
        }
    }
}
