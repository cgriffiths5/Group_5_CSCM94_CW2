package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class WaiterMenuController {

    public Label il1;
    public Label pl1;
    public TextField q1;
    public Label d1;

    public Label il2;
    public Label pl2;
    public TextField q2;
    public Label d2;

    public Label il3;
    public Label pl3;
    public TextField q3;
    public Label d3;

    public Label il4;
    public Label pl4;
    public TextField q4;
    public Label d4;

    public Label il5;
    public Label pl5;
    public TextField q5;
    public Label d5;

    public Label il6;
    public Label pl6;
    public TextField q6;
    public Label d6;

    public Label il7;
    public Label pl7;
    public TextField q7;
    public Label d7;

    public Label il8;
    public Label pl8;
    public TextField q8;
    public Label d8;

    public Label il9;
    public Label pl9;
    public TextField q9;
    public Label d9;

    public Label il10;
    public Label pl10;
    public TextField q10;
    public Label d10;

    public Label il11;
    public Label pl11;
    public TextField q11;
    public Label d11;

    public Label il12;
    public Label pl12;
    public TextField q12;
    public Label d12;

    public Label il13;
    public Label pl13;
    public TextField q13;
    public Label d13;

    public Label il14;
    public Label pl14;
    public TextField q14;
    public Label d14;

    public Label il15;
    public Label pl15;
    public TextField q15;
    public Label d15;

    public Label il16;
    public Label pl16;
    public TextField q16;
    public Label d16;

    public Label il17;
    public Label pl17;
    public TextField q17;
    public Label d17;

    public Label il18;
    public Label pl18;
    public TextField q18;
    public Label d18;

    public Label il19;
    public Label pl19;
    public TextField q19;
    public Label d19;

    public Label il20;
    public Label pl20;
    public TextField q20;
    public Label d20;

    public HBox h20d;
    public HBox h20i;
    public HBox h19d;
    public HBox h19i;
    public HBox h18d;
    public HBox h18i;
    public HBox h17d;
    public HBox h17i;
    public HBox h16d;
    public HBox h16i;
    public HBox h15d;
    public HBox h15i;
    public HBox h14d;
    public HBox h14i;
    public HBox h13d;
    public HBox h13i;
    public HBox h12d;
    public HBox h12i;
    public HBox h11d;
    public HBox h11i;
    public HBox h10d;
    public HBox h10i;
    public HBox h9d;
    public HBox h9i;
    public HBox h8d;
    public HBox h8i;
    public HBox h7d;
    public HBox h7i;
    public HBox h6d;
    public HBox h6i;
    public HBox h5d;
    public HBox h5i;
    public HBox h4d;
    public HBox h4i;
    public HBox h3d;
    public HBox h3i;
    public HBox h2d;
    public HBox h2i;

    public ScrollPane mainPane;
    public Label userHolder;
    public Button restaurantButton;
    public TextField tableNumField;


    public Button goBack;

    private String username;

    Connection connect = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    public WaiterMenuController() throws SQLException {
    }

    public void setUserText(String text) {
        userHolder.setText(username = text);
    }

    @FXML
    public void onRestButtonClick(ActionEvent actionEvent) throws IOException {
        int counter = 0;

        while (counter <= 20) {
            if (!pl1.getText().equals("")) counter++; else break;
            if (!pl2.getText().equals("")) counter++; else break;
            if (!pl3.getText().equals("")) counter++; else break;
            if (!pl4.getText().equals("")) counter++; else break;
            if (!pl5.getText().equals("")) counter++; else break;
            if (!pl6.getText().equals("")) counter++; else break;
            if (!pl7.getText().equals("")) counter++; else break;
            if (!pl8.getText().equals("")) counter++; else break;
            if (!pl9.getText().equals("")) counter++; else break;
            if (!pl10.getText().equals("")) counter++;else break;
            if (!pl11.getText().equals("")) counter++;else break;
            if (!pl12.getText().equals("")) counter++;else break;
            if (!pl13.getText().equals("")) counter++;else break;
            if (!pl14.getText().equals("")) counter++;else break;
            if (!pl15.getText().equals("")) counter++;else break;
            if (!pl16.getText().equals("")) counter++;else break;
            if (!pl17.getText().equals("")) counter++;else break;
            if (!pl18.getText().equals("")) counter++;else break;
            if (!pl19.getText().equals("")) counter++;else break;
            if (!pl20.getText().equals("")) counter++;else break;
        }
        //System.out.println(counter);
        String itemList = getOrderList(counter);
        int id = getUserId(username);

        int check = 0;
        if (!q1.getText().isEmpty()) check++;
        if (!q2.getText().isEmpty()) check++;
        if (!q3.getText().isEmpty()) check++;
        if (!q4.getText().isEmpty()) check++;
        if (!q5.getText().isEmpty()) check++;
        if (!q6.getText().isEmpty()) check++;
        if (!q7.getText().isEmpty()) check++;
        if (!q8.getText().isEmpty()) check++;
        if (!q9.getText().isEmpty()) check++;
        if (!q10.getText().isEmpty()) check++;
        if (!q11.getText().isEmpty()) check++;
        if (!q12.getText().isEmpty()) check++;
        if (!q13.getText().isEmpty()) check++;
        if (!q14.getText().isEmpty()) check++;
        if (!q15.getText().isEmpty()) check++;
        if (!q16.getText().isEmpty()) check++;
        if (!q17.getText().isEmpty()) check++;
        if (!q18.getText().isEmpty()) check++;
        if (!q19.getText().isEmpty()) check++;
        if (!q20.getText().isEmpty()) check++;

        if (check == 0 || tableNumField.getText().isEmpty()) { //send error message
            //trying to get error message when no table number is entered
            Parent newRoot1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("waiterMenu-EnterCorrectDetails.fxml")));
            Scene scene1 = new Scene(newRoot1);
            Stage stage1 = new Stage();

            stage1.setTitle("Details Incorrect");
            stage1.setScene(scene1);
            stage1.initModality(Modality.WINDOW_MODAL);
            stage1.show();
        } else {
            int tableNum = parseInt(tableNumField.getText());
            String type = "seated";

            String query =
                    "INSERT INTO orders (FK_user_ID, type, table_number, item_list) VALUES ("
                            + id + "," + "'" + type + "'," + tableNum + ", '" + itemList + "')";
            try (Statement stmt = connect.createStatement()) {
                stmt.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            q1.setText("");
            q2.setText("");
            q3.setText("");
            q4.setText("");
            q5.setText("");
            q6.setText("");
            q7.setText("");
            q8.setText("");
            q9.setText("");
            q10.setText("");
            q11.setText("");
            q12.setText("");
            q13.setText("");
            q14.setText("");
            q15.setText("");
            q16.setText("");
            q17.setText("");
            q18.setText("");
            q19.setText("");
            q20.setText("");
            tableNumField.setText("");

            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("waiterMenu-OrderSubmitted.fxml")));
            Scene scene = new Scene(newRoot);
            Stage stage = new Stage();

            stage.setTitle("Order submitted");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        }

    }

    public int getUserId(String username) {
        String query = "SELECT user_ID FROM users WHERE username = '" + username + "'";
        ResultSet rs = null;
        int a = 0;
        try (Statement stmt = connect.createStatement()) {
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                a = parseInt(rs.getNString("user_ID"));
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public String getOrderList(int counter) {
        int i = counter;
        int value1 = 0, value2 = 0, value3 =0,value4 = 0, value5 = 0, value6 =0,value7 = 0, value8 = 0, value9 =0,value10 = 0, value11 = 0, value12 =0,value13 = 0, value14 = 0, value15 =0,value16 = 0, value17 = 0, value18 =0,value19=0,value20=0;
        StringBuilder itemList = new StringBuilder();
        String c = ",";
        String query = "SELECT * FROM menu ORDER BY category DESC";
        //get q1 string, i--;
        //get q2 string, i--;
        ResultSet rs = null;
        try (Statement stmt = connect.createStatement()) {
            rs = stmt.executeQuery(query);
            while (rs.next() && i > 0) {
                if (!q1.getText().isEmpty() && i==counter){
                    value1= Integer.parseInt( q1.getText().replaceAll("[^\\d.]", "").trim());
                    while (value1 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value1--;
                    }
                }
                if (!q2.getText().isEmpty() && i==counter-1){
                    value2= Integer.parseInt( q2.getText().replaceAll("[^\\d.]", "").trim());
                    while (value2 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value2--;
                    }
                }
                if (!q3.getText().isEmpty() && i==counter-2){
                    value3= Integer.parseInt( q3.getText().replaceAll("[^\\d.]", "").trim());
                    while (value3 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value3--;
                    }
                }
                if (!q4.getText().isEmpty() && i==counter-3){
                    value4= Integer.parseInt( q4.getText().replaceAll("[^\\d.]", "").trim());
                    while (value4 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value4--;
                    }
                }
                if (!q5.getText().isEmpty() && i==counter-4){
                    value5= Integer.parseInt( q5.getText().replaceAll("[^\\d.]", "").trim());
                    while (value5 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value5--;
                    }
                }
                if (!q6.getText().isEmpty() && i==counter-5){
                    value6= Integer.parseInt( q6.getText().replaceAll("[^\\d.]", "").trim());
                    while (value6 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value6--;
                    }
                }
                if (!q7.getText().isEmpty() && i==counter-6){
                    value7= Integer.parseInt( q7.getText().replaceAll("[^\\d.]", "").trim());
                    while (value7 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value7--;
                    }
                }
                if (!q8.getText().isEmpty() && i==counter-7){
                    value8= Integer.parseInt( q8.getText().replaceAll("[^\\d.]", "").trim());
                    while (value8 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value8--;
                    }
                }
                if (!q9.getText().isEmpty() && i==counter-8){
                    value9= Integer.parseInt( q9.getText().replaceAll("[^\\d.]", "").trim());
                    while (value9 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value9--;
                    }
                }
                if (!q10.getText().isEmpty() && i==counter-9){
                    value10=Integer.parseInt(q10.getText().replaceAll("[^\\d.]", "").trim());
                    while (value10 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value10--;
                    }
                }
                if (!q11.getText().isEmpty() && i==counter-10){
                    value11=Integer.parseInt(q11.getText().replaceAll("[^\\d.]", "").trim());
                    while (value11 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value11--;
                    }
                }
                if (!q12.getText().isEmpty() && i==counter-11) {
                    value12=Integer.parseInt(q12.getText().replaceAll("[^\\d.]", "").trim());
                    while (value12 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value12--;
                    }
                }
                if (!q13.getText().isEmpty() && i==counter-12) {
                    value13=Integer.parseInt(q13.getText().replaceAll("[^\\d.]", "").trim());
                    while (value13 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value13--;
                    }
                }
                if (!q14.getText().isEmpty() && i==counter-13) {
                    value14=Integer.parseInt(q14.getText().replaceAll("[^\\d.]", "").trim());
                    while (value14 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value14--;
                    }
                }
                if (!q15.getText().isEmpty() && i==counter-14) {
                    value15=Integer.parseInt(q15.getText().replaceAll("[^\\d.]", "").trim());
                    while (value15 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value15--;
                    }
                }
                if (!q16.getText().isEmpty() && i==counter-15) {
                    value16=Integer.parseInt(q16.getText().replaceAll("[^\\d.]", "").trim());
                    while (value16 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value16--;
                    }
                }
                if (!q17.getText().isEmpty() && i==counter-16) {
                    value17=Integer.parseInt(q17.getText().replaceAll("[^\\d.]", "").trim());
                    while (value17 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value17--;
                    }
                }
                if (!q18.getText().isEmpty() && i==counter-17) {
                    value18=Integer.parseInt(q18.getText().replaceAll("[^\\d.]", "").trim());
                    while (value18 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value18--;
                    }
                }
                if (!q19.getText().isEmpty() && i==counter-18) {
                    value19=Integer.parseInt(q19.getText().replaceAll("[^\\d.]", "").trim());
                    while (value19 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value19--;
                    }
                }
                if (!q20.getText().isEmpty() && i==counter-19) {
                    value20=Integer.parseInt(q20.getText().replaceAll("[^\\d.]", "").trim());
                    while (value20 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value20--;
                    }
                }
                i--;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList.toString();
    }

    @FXML
    public String getItem(int num) throws SQLException {
        String val = "";
        String query = "SELECT * FROM menu ORDER BY category DESC";
        ResultSet rs = null;
        try (Statement stmt = connect.createStatement()) {
            rs = stmt.executeQuery(query);
            int i = 0;
            while(rs.next()) {
                val = rs.getString("item");
                i++;
                if (i==num) {
                    return val;
                }
            }
            return "";

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert rs != null;
            rs.close();
        }
        return val;
    }

    public void setItemLabels() throws SQLException {
        il1.setText(getItem(1));
        il2.setText(getItem(2));
        il3.setText(getItem(3));
        il4.setText(getItem(4));
        il5.setText(getItem(5));
        il6.setText(getItem(6));
        il7.setText(getItem(7));
        il8.setText(getItem(8));
        il9.setText(getItem(9));
        il10.setText(getItem(10));
        il11.setText(getItem(11));
        il12.setText(getItem(12));
        il13.setText(getItem(13));
        il14.setText(getItem(14));
        il15.setText(getItem(15));
        il16.setText(getItem(16));
        il17.setText(getItem(17));
        il18.setText(getItem(18));
        il19.setText(getItem(19));
        il20.setText(getItem(20));
    }

    public String getPrice(int num) throws SQLException {
        String val = "";
        String query = "SELECT * FROM menu ORDER BY category DESC";
        ResultSet rs = null;
        try (Statement stmt = connect.createStatement()) {
            rs = stmt.executeQuery(query);
            int i = 0;
            while(rs.next()) {
                val = rs.getString("price");
                i++;
                if (i==num) {
                    return val;
                }
            }
            return "";

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert rs != null;
            rs.close();
        }
        return val;
    }

    public void setPriceLabels() throws SQLException {
        pl1.setText(getPrice(1));
        pl2.setText(getPrice(2));
        pl3.setText(getPrice(3));
        pl4.setText(getPrice(4));
        pl5.setText(getPrice(5));
        pl6.setText(getPrice(6));
        pl7.setText(getPrice(7));
        pl8.setText(getPrice(8));
        pl9.setText(getPrice(9));
        pl10.setText(getPrice(10));
        pl11.setText(getPrice(11));
        pl12.setText(getPrice(12));
        pl13.setText(getPrice(13));
        pl14.setText(getPrice(14));
        pl15.setText(getPrice(15));
        pl16.setText(getPrice(16));
        pl17.setText(getPrice(17));
        pl18.setText(getPrice(18));
        pl19.setText(getPrice(19));
        pl20.setText(getPrice(20));
    }

    public String getDesc(int num) throws SQLException {
        String val = "";
        String query = "SELECT * FROM menu ORDER BY category DESC";
        ResultSet rs = null;
        try (Statement stmt = connect.createStatement()) {
            rs = stmt.executeQuery(query);
            int i = 0;
            while(rs.next()) {
                val = rs.getString("description");
                i++;
                if (i==num) {
                    return val;
                }
            }
            return "";

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert rs != null;
            rs.close();
        }
        return val;
    }

    public void setDescLabels() throws SQLException {
        d1.setText(getDesc(1));
        d2.setText(getDesc(2));
        d3.setText(getDesc(3));
        d4.setText(getDesc(4));
        d5.setText(getDesc(5));
        d6.setText(getDesc(6));
        d7.setText(getDesc(7));
        d8.setText(getDesc(8));
        d9.setText(getDesc(9));
        d10.setText(getDesc(10));
        d11.setText(getDesc(11));
        d12.setText(getDesc(12));
        d13.setText(getDesc(13));
        d14.setText(getDesc(14));
        d15.setText(getDesc(15));
        d16.setText(getDesc(16));
        d17.setText(getDesc(17));
        d18.setText(getDesc(18));
        d19.setText(getDesc(19));
        d20.setText(getDesc(20));
        if (d1.getText().equals("")) {
            q1.setOpacity(0.0);
            // delete the hbox... ? will need to set fx:id
        }
        if (d2.getText().equals("")) {
            q2.setOpacity(0.0);
            h2d.setMaxHeight(0.1);
            h2i.setMaxHeight(0.1);
        }
        if (d3.getText().equals("")) {
            q3.setOpacity(0.0);
            h3d.setMaxHeight(0.1);
            h3i.setMaxHeight(0.1);

        }
        if (d4.getText().equals("")) {
            q4.setOpacity(0.0);
            h4d.setMaxHeight(0.1);
            h4i.setMaxHeight(0.1);

        }
        if (d5.getText().equals("")) {
            q5.setOpacity(0.0);
            h5d.setMaxHeight(0.1);
            h5i.setMaxHeight(0.1);

        }
        if (d6.getText().equals("")) {
            q6.setOpacity(0.0);
            h6d.setMaxHeight(0.1);
            h6i.setMaxHeight(0.1);

        }
        if (d7.getText().equals("")) {
            q7.setOpacity(0.0);
            h7d.setMaxHeight(0.1);
            h7i.setMaxHeight(0.1);

        }
        if (d8.getText().equals("")) {
            q8.setOpacity(0.0);
            h8d.setMaxHeight(0.1);
            h8i.setMaxHeight(0.1);

        }
        if (d9.getText().equals("")) {
            q9.setOpacity(0.0);
            h9d.setMaxHeight(0.1);
            h9i.setMaxHeight(0.1);

        }
        if (d10.getText().equals("")) {
            q10.setOpacity(0.0);
            h10d.setMaxHeight(0.1);
            h10i.setMaxHeight(0.1);

        }
        if (d11.getText().equals("")) {
            q11.setOpacity(0.0);
            h11d.setMaxHeight(0.1);
            h11i.setMaxHeight(0.1);

        }
        if (d12.getText().equals("")) {
            q12.setOpacity(0.0);
            h12d.setMaxHeight(0.1);
            h12i.setMaxHeight(0.1);

        }
        if (d13.getText().equals("")) {
            q13.setOpacity(0.0);
            h13d.setMaxHeight(0.1);
            h13i.setMaxHeight(0.1);

        }
        if (d14.getText().equals("")) {
            q14.setOpacity(0.0);
            h14d.setMaxHeight(0.1);
            h14i.setMaxHeight(0.1);

        }
        if (d15.getText().equals("")) {
            q15.setOpacity(0.0);
            h15d.setMaxHeight(0.1);
            h15i.setMaxHeight(0.1);

        }
        if (d16.getText().equals("")) {
            q16.setOpacity(0.0);
            h16d.setMaxHeight(0.1);
            h16i.setMaxHeight(0.1);

        }
        if (d17.getText().equals("")) {
            q17.setOpacity(0.0);
            h17d.setMaxHeight(0.1);
            h17i.setMaxHeight(0.1);

        }
        if (d18.getText().equals("")) {
            q18.setOpacity(0.0);
            h18d.setMaxHeight(0.1);
            h18i.setMaxHeight(0.1);

        }
        if (d19.getText().equals("")) {
            q19.setOpacity(0.0);
            h19d.setMaxHeight(0.1);
            h19i.setMaxHeight(0.1);

        }
        if (d20.getText().equals("")) {
            q20.setOpacity(0.0);
            h20d.setMaxHeight(0.1);
            h20i.setMaxHeight(0.1);

        }
    }

    //goBack
    public void onClickGoBack(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) goBack.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("waiter-view.fxml"));
            Parent newRoot = loader.load();

            WaiterController wCont = loader.getController();
            wCont.setUserText(username);
            wCont.setResOrdTab();
            wCont.setTakeawayOrdTable();


            stage.setTitle(username);
            stage.centerOnScreen();
            stage.setHeight(534);
            stage.setMaxHeight(534);
            stage.setWidth(616);
            stage.setMaxWidth(616);
            stage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }
}
