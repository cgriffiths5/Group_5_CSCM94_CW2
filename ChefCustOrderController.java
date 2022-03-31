package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ChefCustOrderController {

    public ScrollPane mainPane;

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

    public Label quantLabel1;
    public Label quantLabel2;
    public Label quantLabel3;
    public Label quantLabel4;
    public Label quantLabel5;
    public Label quantLabel6;
    public Label quantLabel7;
    public Label quantLabel8;
    public Label quantLabel9;
    public Label quantLabel10;
    public Label quantLabel11;
    public Label quantLabel12;
    public Label quantLabel13;
    public Label quantLabel14;
    public Label quantLabel15;
    public Label quantLabel16;
    public Label quantLabel17;
    public Label quantLabel18;
    public Label quantLabel19;
    public Label quantLabel20;

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
                String item21 = rs.getString("21st"); items.add(item21);
                String item22 = rs.getString("22nd"); items.add(item22);
                String item23 = rs.getString("23rd"); items.add(item23);
                String item24 = rs.getString("24th"); items.add(item24);
                String item25 = rs.getString("25th"); items.add(item25);
                String item26 = rs.getString("26th"); items.add(item26);
                String item27 = rs.getString("27th"); items.add(item27);
                String item28 = rs.getString("28th"); items.add(item28);
                String item29 = rs.getString("29th"); items.add(item29);
                String item30 = rs.getString("30th"); items.add(item30);

                int size = items.size() - 1;
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

                for (int i = 1; i < items.size()-1; i++) {
                    System.out.println(i);
                    System.out.println(items.get(i));
                    while (items.get(i).equals(items.get(i + 1))) {
                        if (!items.get(i).equals("") && items.get(i).equals(item1))  count1++;  items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item2))  count2++;  items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item3))  count3++;  items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item4))  count4++;  items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item5))  count5++;  items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item6))  count6++;  items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item7))  count7++;  items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item8))  count8++;  items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item9))  count9++;  items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item10)) count10++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item11)) count11++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item12)) count12++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item13)) count13++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item14)) count14++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item15)) count15++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item16)) count16++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item17)) count17++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item18)) count18++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item19)) count19++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item20)) count20++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item21)) count21++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item22)) count22++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item23)) count23++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item24)) count24++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item25)) count25++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item26)) count26++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item27)) count27++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item28)) count28++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item29)) count29++; items.remove(i);
                        if (!items.get(i).equals("") && items.get(i).equals(item30)) count30++; items.remove(i);
                    }
                }

                size = items.size() - 1;
                int i = 0;
                while (i < size) {
                    if (i == 0) il1.setText(items.get(i));
                    if (i == 1) il2.setText(items.get(i));
                    if (i == 2) il3.setText(items.get(i));
                    if (i == 3) il4.setText(items.get(i));
                    if (i == 4) il5.setText(items.get(i));
                    if (i == 5) il6.setText(items.get(i));
                    if (i == 6) il7.setText(items.get(i));
                    if (i == 7) il8.setText(items.get(i));
                    if (i == 8) il9.setText(items.get(i));
                    if (i == 9) il10.setText(items.get(i));
                    if (i == 10) il11.setText(items.get(i));
                    if (i == 11) il12.setText(items.get(i));
                    if (i == 12) il13.setText(items.get(i));
                    if (i == 13) il14.setText(items.get(i));
                    if (i == 14) il15.setText(items.get(i));
                    if (i == 15) il16.setText(items.get(i));
                    if (i == 16) il17.setText(items.get(i));
                    if (i == 17) il18.setText(items.get(i));
                    if (i == 18) il19.setText(items.get(i));
                    if (i == 19) il20.setText(items.get(i));
                    i++;
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
