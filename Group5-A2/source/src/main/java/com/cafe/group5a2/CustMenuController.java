package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * This controller represents a view for the Customer Menu
 *
 * @author Adam Tucker
 * @version 1.6
 */
public class CustMenuController {

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

    public Button takeawayButton;
    public Button deliveryButton;
    public ScrollPane mainPane;
    public Label userHolder;
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
    public VBox vBox;
    public Label totalPLabel;
    public AnchorPane aPane;
    public ProgressBar progBar;
    public Button backButt;
    public HBox hTbox;
    public Label orderSubL;
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");
    private String username;

    public CustMenuController() throws SQLException {
    }

    /**
     * Set label username as text
     *
     * @param text username passed from previous view
     */
    public void setUserText(String text) {
        username = text;
        userHolder.setText(text);
        orderSubL.setOpacity(0.0);
    }

    private void myTask(ScheduledExecutorService e) throws IOException {
        progBar.setOpacity(0);
        orderSubL.setOpacity(1.0);
        e.shutdown();
    }

    /**
     * The actionEvent creates a takeaway order in the database using item, time, amount and is a takeaway
     *
     * @param actionEvent is entered when a user presses the Order Takeaway button
     */
    @FXML
    public void onTakeawayButtonClick(ActionEvent actionEvent) throws InterruptedException {

        int counter = 0;
        while (counter <= 20) {
            if (!d1.getText().isEmpty()) counter++;
            else break;
            if (!d2.getText().isEmpty()) counter++;
            else break;
            if (!d3.getText().isEmpty()) counter++;
            else break;
            if (!d4.getText().isEmpty()) counter++;
            else break;
            if (!d5.getText().isEmpty()) counter++;
            else break;
            if (!d6.getText().isEmpty()) counter++;
            else break;
            if (!d7.getText().isEmpty()) counter++;
            else break;
            if (!d8.getText().isEmpty()) counter++;
            else break;
            if (!d9.getText().isEmpty()) counter++;
            else break;
            if (!d10.getText().isEmpty()) counter++;
            else break;
            if (!d11.getText().isEmpty()) counter++;
            else break;
            if (!d12.getText().isEmpty()) counter++;
            else break;
            if (!d13.getText().isEmpty()) counter++;
            else break;
            if (!d14.getText().isEmpty()) counter++;
            else break;
            if (!d15.getText().isEmpty()) counter++;
            else break;
            if (!d16.getText().isEmpty()) counter++;
            else break;
            if (!d17.getText().isEmpty()) counter++;
            else break;
            if (!d18.getText().isEmpty()) counter++;
            else break;
            if (!d19.getText().isEmpty()) counter++;
            else break;
            if (!d20.getText().isEmpty()) counter++;
            else break;
        }
        String itemList = getOrderList(counter);
        int id = getUserId(username);
        String type = "takeaway";
        if (!(q1.getText().isEmpty()) || !(q2.getText().isEmpty()) || !(q3.getText().isEmpty()) || !(q4.getText().isEmpty())
                || !(q5.getText().isEmpty()) || !(q6.getText().isEmpty()) || !(q7.getText().isEmpty()) || !(q8.getText().isEmpty())
                || !(q9.getText().isEmpty()) || !(q10.getText().isEmpty()) || !(q11.getText().isEmpty()) || !(q12.getText().isEmpty())
                || !(q13.getText().isEmpty()) || !(q14.getText().isEmpty()) || !(q15.getText().isEmpty()) || !(q16.getText().isEmpty())
                || !(q17.getText().isEmpty()) || !(q18.getText().isEmpty()) || !(q19.getText().isEmpty()) || !(q20.getText().isEmpty())) {
            String query =
                    "INSERT INTO orders (FK_user_ID, type, item_list) VALUES ("
                            + id + "," + "'" + type + "'," + "'" + itemList + "')";
            try (Statement stmt = con.createStatement()) {
                stmt.executeQuery(query);
                progBar.setOpacity(1);
                takeawayButton.setDisable(true);
                deliveryButton.setDisable(true);


                final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
                executorService.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            myTask(executorService);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, 3, 5, TimeUnit.SECONDS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * The actionEvent creates a delivery order in the database using item, time, amount and is a delivery
     *
     * @param actionEvent is entered when a user presses the Order Delivery button
     */
    @FXML
    public void onDeliveryButtonClick(ActionEvent actionEvent) throws InterruptedException {

        int counter = 0;
        while (counter <= 20) {
            if (!d1.getText().isEmpty()) counter++;
            else break;
            if (!d2.getText().isEmpty()) counter++;
            else break;
            if (!d3.getText().isEmpty()) counter++;
            else break;
            if (!d4.getText().isEmpty()) counter++;
            else break;
            if (!d5.getText().isEmpty()) counter++;
            else break;
            if (!d6.getText().isEmpty()) counter++;
            else break;
            if (!d7.getText().isEmpty()) counter++;
            else break;
            if (!d8.getText().isEmpty()) counter++;
            else break;
            if (!d9.getText().isEmpty()) counter++;
            else break;
            if (!d10.getText().isEmpty()) counter++;
            else break;
            if (!d11.getText().isEmpty()) counter++;
            else break;
            if (!d12.getText().isEmpty()) counter++;
            else break;
            if (!d13.getText().isEmpty()) counter++;
            else break;
            if (!d14.getText().isEmpty()) counter++;
            else break;
            if (!d15.getText().isEmpty()) counter++;
            else break;
            if (!d16.getText().isEmpty()) counter++;
            else break;
            if (!d17.getText().isEmpty()) counter++;
            else break;
            if (!d18.getText().isEmpty()) counter++;
            else break;
            if (!d19.getText().isEmpty()) counter++;
            else break;
            if (!d20.getText().isEmpty()) counter++;
            else break;
        }
        String itemList = getOrderList(counter);
        int id = getUserId(username);
        String type = "delivery";
        if (!(q1.getText().isEmpty()) || !(q2.getText().isEmpty()) || !(q3.getText().isEmpty()) || !(q4.getText().isEmpty())
                || !(q5.getText().isEmpty()) || !(q6.getText().isEmpty()) || !(q7.getText().isEmpty()) || !(q8.getText().isEmpty())
                || !(q9.getText().isEmpty()) || !(q10.getText().isEmpty()) || !(q11.getText().isEmpty()) || !(q12.getText().isEmpty())
                || !(q13.getText().isEmpty()) || !(q14.getText().isEmpty()) || !(q15.getText().isEmpty()) || !(q16.getText().isEmpty())
                || !(q17.getText().isEmpty()) || !(q18.getText().isEmpty()) || !(q19.getText().isEmpty()) || !(q20.getText().isEmpty())) {
            String query =
                    "INSERT INTO orders (FK_user_ID, type, item_list) VALUES ("
                            + id + "," + "'" + type + "'," + "'" + itemList + "')";
            try (Statement stmt = con.createStatement()) {
                stmt.executeQuery(query);
                progBar.setOpacity(1);
                deliveryButton.setDisable(true);
                takeawayButton.setDisable(true);

                final ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();
                executorService2.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            myTask(executorService2);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, 3, 5, TimeUnit.SECONDS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Grabs User ID Number from database and converts it to username
     *
     * @return username
     */
    public int getUserId(String username) {
        String query = "SELECT user_ID FROM users WHERE username = '" + username + "'";
        ResultSet rs = null;
        int a = 0;
        try (Statement stmt = con.createStatement()) {
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                a = Integer.parseInt(rs.getNString("user_ID"));
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * Grabs all items from database and arranges in descending order
     *
     * @param counter used to decide what data to show on what label
     */
    public String getOrderList(int counter) {
        int i = counter;
        int value1 = 0, value2 = 0, value3 = 0, value4 = 0, value5 = 0, value6 = 0, value7 = 0, value8 = 0, value9 = 0, value10 = 0, value11 = 0, value12 = 0, value13 = 0, value14 = 0, value15 = 0, value16 = 0, value17 = 0, value18 = 0, value19 = 0, value20 = 0;
        StringBuilder itemList = new StringBuilder();
        String c = ",";
        String query = "SELECT * FROM menu ORDER BY category DESC";
        ResultSet rs = null;
        try (Statement stmt = con.createStatement()) {
            rs = stmt.executeQuery(query);
            while (rs.next() && i > 0) {
                if (!q1.getText().isEmpty() && i == counter) {
                    value1 = Integer.parseInt(q1.getText().replaceAll("[^\\d.]", "").trim());
                    while (value1 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value1--;
                    }
                }
                if (!q2.getText().isEmpty() && i == counter - 1) {
                    value2 = Integer.parseInt(q2.getText().replaceAll("[^\\d.]", "").trim());
                    while (value2 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value2--;
                    }
                }
                if (!q3.getText().isEmpty() && i == counter - 2) {
                    value3 = Integer.parseInt(q3.getText().replaceAll("[^\\d.]", "").trim());
                    while (value3 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value3--;
                    }
                }
                if (!q4.getText().isEmpty() && i == counter - 3) {
                    value4 = Integer.parseInt(q4.getText().replaceAll("[^\\d.]", "").trim());
                    while (value4 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value4--;
                    }
                }
                if (!q5.getText().isEmpty() && i == counter - 4) {
                    value5 = Integer.parseInt(q5.getText().replaceAll("[^\\d.]", "").trim());
                    while (value5 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value5--;
                    }
                }
                if (!q6.getText().isEmpty() && i == counter - 5) {
                    value6 = Integer.parseInt(q6.getText().replaceAll("[^\\d.]", "").trim());
                    while (value6 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value6--;
                    }
                }
                if (!q7.getText().isEmpty() && i == counter - 6) {
                    value7 = Integer.parseInt(q7.getText().replaceAll("[^\\d.]", "").trim());
                    while (value7 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value7--;
                    }
                }
                if (!q8.getText().isEmpty() && i == counter - 7) {
                    value8 = Integer.parseInt(q8.getText().replaceAll("[^\\d.]", "").trim());
                    while (value8 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value8--;
                    }
                }
                if (!q9.getText().isEmpty() && i == counter - 8) {
                    value9 = Integer.parseInt(q9.getText().replaceAll("[^\\d.]", "").trim());
                    while (value9 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value9--;
                    }
                }
                if (!q10.getText().isEmpty() && i == counter - 9) {
                    value10 = Integer.parseInt(q10.getText().replaceAll("[^\\d.]", "").trim());
                    while (value10 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value10--;
                    }
                }
                if (!q11.getText().isEmpty() && i == counter - 10) {
                    value11 = Integer.parseInt(q11.getText().replaceAll("[^\\d.]", "").trim());
                    while (value11 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value11--;
                    }
                }
                if (!q12.getText().isEmpty() && i == counter - 11) {
                    value12 = Integer.parseInt(q12.getText().replaceAll("[^\\d.]", "").trim());
                    while (value12 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value12--;
                    }
                }
                if (!q13.getText().isEmpty() && i == counter - 12) {
                    value13 = Integer.parseInt(q13.getText().replaceAll("[^\\d.]", "").trim());
                    while (value13 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value13--;
                    }
                }
                if (!q14.getText().isEmpty() && i == counter - 13) {
                    value14 = Integer.parseInt(q14.getText().replaceAll("[^\\d.]", "").trim());
                    while (value14 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value14--;
                    }
                }
                if (!q15.getText().isEmpty() && i == counter - 14) {
                    value15 = Integer.parseInt(q15.getText().replaceAll("[^\\d.]", "").trim());
                    while (value15 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value15--;
                    }
                }
                if (!q16.getText().isEmpty() && i == counter - 15) {
                    value16 = Integer.parseInt(q16.getText().replaceAll("[^\\d.]", "").trim());
                    while (value16 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value16--;
                    }
                }
                if (!q17.getText().isEmpty() && i == counter - 16) {
                    value17 = Integer.parseInt(q17.getText().replaceAll("[^\\d.]", "").trim());
                    while (value17 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value17--;
                    }
                }
                if (!q18.getText().isEmpty() && i == counter - 17) {
                    value18 = Integer.parseInt(q18.getText().replaceAll("[^\\d.]", "").trim());
                    while (value18 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value18--;
                    }
                }
                if (!q19.getText().isEmpty() && i == counter - 18) {
                    value19 = Integer.parseInt(q19.getText().replaceAll("[^\\d.]", "").trim());
                    while (value19 > 0) {
                        itemList.append(rs.getString("item")).append(c);
                        value19--;
                    }
                }
                if (!q20.getText().isEmpty() && i == counter - 19) {
                    value20 = Integer.parseInt(q20.getText().replaceAll("[^\\d.]", "").trim());
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

    /**
     * This returns an item according to its place in the database
     *
     * @param num
     */
    @FXML
    public String getItem(int num) throws SQLException {
        String val = "";
        String query = "SELECT * FROM menu ORDER BY category DESC";
        ResultSet rs = null;
        try (Statement stmt = con.createStatement()) {
            rs = stmt.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                val = rs.getString("item");
                i++;
                if (i == num) {
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

    /**
     * This sets the text to fetch the items from the database
     */
    public void setItemLabels() throws SQLException {
        progBar.setOpacity(0);
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

    /**
     * This returns the menu item at the location of the given number
     *
     * @param num is the location in the database
     */
    public String getPrice(int num) throws SQLException {
        String val = "";
        String query = "SELECT * FROM menu ORDER BY category DESC";
        ResultSet rs = null;
        try (Statement stmt = con.createStatement()) {
            rs = stmt.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                val = rs.getString("price");
                i++;
                if (i == num) {
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

    /**
     * This sets the text of the labels to match those fetched from the getPrice method
     */
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

    /**
     * This fetches the description of the item at the location of the inputted number
     *
     * @param num is inputted to find the location of the item description
     */
    public String getDesc(int num) throws SQLException {
        String val = "";
        String query = "SELECT * FROM menu ORDER BY category DESC";
        ResultSet rs = null;
        try (Statement stmt = con.createStatement()) {
            rs = stmt.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                val = rs.getString("description");
                i++;
                if (i == num) {
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

    /**
     * This method sets the description labels with the item descriptions fetched from the database
     *
     * @throws SQLException there will likely not be a full 20 menu items, so a sql error will occur
     */
    public void setDescLabels() throws SQLException {

        d1.setText(getDesc(1));
        d1.setMinHeight(100);
        d1.setWrapText(true);
        d1.setTextAlignment(TextAlignment.LEFT);
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

        double scaleV = 210.0;
        double scaleA = 170.0;
        if (d1.getText().equals("")) {
            q1.setOpacity(0.0);
        }
        if (d2.getText().equals("")) {
            q2.setOpacity(0.0);

            h2d.setMinHeight(0.1);
            h2i.setMinHeight(0.1);

            h2d.setMaxHeight(0.1);
            h2i.setMaxHeight(0.1);

            d2.setMaxHeight(0.1);
            il2.setMaxHeight(0.1);
            pl2.setMaxHeight(0.1);
            q2.setMaxHeight(0.1);
        }
        if (d3.getText().equals("")) {
            q3.setOpacity(0.0);

            h3d.setMinHeight(0.1);
            h3i.setMinHeight(0.1);

            h3d.setMaxHeight(0.1);
            h3i.setMaxHeight(0.1);

            d3.setMaxHeight(0.1);
            il3.setMaxHeight(0.1);
            pl3.setMaxHeight(0.1);
            q3.setMaxHeight(0.1);

        }
        if (d4.getText().equals("")) {
            q4.setOpacity(0.0);

            h4d.setMinHeight(0.1);
            h4i.setMinHeight(0.1);

            h4d.setMaxHeight(0.1);
            h4i.setMaxHeight(0.1);

            d4.setMaxHeight(0.1);
            il4.setMaxHeight(0.1);
            pl4.setMaxHeight(0.1);
            q4.setMaxHeight(0.1);

        }
        if (d5.getText().equals("")) {
            q5.setOpacity(0.0);

            h5d.setMinHeight(0.1);
            h5i.setMinHeight(0.1);

            h5d.setMaxHeight(0.1);
            h5i.setMaxHeight(0.1);

            d5.setMaxHeight(0.1);
            il5.setMaxHeight(0.1);
            pl5.setMaxHeight(0.1);
            q5.setMaxHeight(0.1);

        }
        if (d6.getText().equals("")) {
            q6.setOpacity(0.0);

            h6d.setMinHeight(0.1);
            h6i.setMinHeight(0.1);

            h6d.setMaxHeight(0.1);
            h6i.setMaxHeight(0.1);

            d6.setMaxHeight(0.1);
            il6.setMaxHeight(0.1);
            pl6.setMaxHeight(0.1);
            q6.setMaxHeight(0.1);

        }
        if (d7.getText().equals("")) {
            q7.setOpacity(0.0);

            h7d.setMinHeight(0.1);
            h7i.setMinHeight(0.1);

            h7d.setMaxHeight(0.1);
            h7i.setMaxHeight(0.1);

            d7.setMaxHeight(0.1);
            il7.setMaxHeight(0.1);
            pl7.setMaxHeight(0.1);
            q7.setMaxHeight(0.1);

        }
        if (d8.getText().equals("")) {
            q8.setOpacity(0.0);

            h8d.setMinHeight(0.1);
            h8i.setMinHeight(0.1);

            h8d.setMaxHeight(0.1);
            h8i.setMaxHeight(0.1);

            d8.setMaxHeight(0.1);
            il8.setMaxHeight(0.1);
            pl8.setMaxHeight(0.1);
            q8.setMaxHeight(0.1);

        }
        if (d9.getText().equals("")) {
            q9.setOpacity(0.0);

            h9d.setMinHeight(0.1);
            h9i.setMinHeight(0.1);

            h9d.setMaxHeight(0.1);
            h9i.setMaxHeight(0.1);

            d9.setMaxHeight(0.1);
            il9.setMaxHeight(0.1);
            pl9.setMaxHeight(0.1);
            q9.setMaxHeight(0.1);

        }
        if (d10.getText().equals("")) {
            q10.setOpacity(0.0);

            h10d.setMinHeight(0.1);
            h10i.setMinHeight(0.1);

            h10d.setMaxHeight(0.1);
            h10i.setMaxHeight(0.1);

            d10.setMaxHeight(0.1);
            il10.setMaxHeight(0.1);
            pl10.setMaxHeight(0.1);
            q10.setMaxHeight(0.1);

        }
        if (d11.getText().equals("")) {
            q11.setOpacity(0.0);

            h11d.setMinHeight(0.1);
            h11i.setMinHeight(0.1);

            h11d.setMaxHeight(0.1);
            h11i.setMaxHeight(0.1);

            d11.setMaxHeight(0.1);
            il11.setMaxHeight(0.1);
            pl11.setMaxHeight(0.1);
            q11.setMaxHeight(0.1);

        }
        if (d12.getText().equals("")) {
            q12.setOpacity(0.0);

            h12d.setMinHeight(0.1);
            h12i.setMinHeight(0.1);

            h12d.setMaxHeight(0.1);
            h12i.setMaxHeight(0.1);

            d12.setMaxHeight(0.1);
            il12.setMaxHeight(0.1);
            pl12.setMaxHeight(0.1);
            q12.setMaxHeight(0.1);

        }
        if (d13.getText().equals("")) {
            q13.setOpacity(0.0);

            h13d.setMinHeight(0.1);
            h13i.setMinHeight(0.1);

            h13d.setMaxHeight(0.1);
            h13i.setMaxHeight(0.1);

            d13.setMaxHeight(0.1);
            il13.setMaxHeight(0.1);
            pl13.setMaxHeight(0.1);
            q13.setMaxHeight(0.1);

        }
        if (d14.getText().equals("")) {
            q14.setOpacity(0.0);

            h14d.setMinHeight(0.1);
            h14i.setMinHeight(0.1);

            h14d.setMaxHeight(0.1);
            h14i.setMaxHeight(0.1);

            d14.setMaxHeight(0.1);
            il14.setMaxHeight(0.1);
            pl14.setMaxHeight(0.1);
            q14.setMaxHeight(0.1);

        }
        if (d15.getText().equals("")) {
            q15.setOpacity(0.0);

            h15d.setMinHeight(0.1);
            h15i.setMinHeight(0.1);

            h15d.setMaxHeight(0.1);
            h15i.setMaxHeight(0.1);

            d15.setMaxHeight(0.1);
            il15.setMaxHeight(0.1);
            pl15.setMaxHeight(0.1);
            q15.setMaxHeight(0.1);

        }
        if (d16.getText().equals("")) {
            q16.setOpacity(0.0);

            h16d.setMinHeight(0.1);
            h16i.setMinHeight(0.1);

            h16d.setMaxHeight(0.1);
            h16i.setMaxHeight(0.1);

            d16.setMaxHeight(0.1);
            il16.setMaxHeight(0.1);
            pl16.setMaxHeight(0.1);
            q16.setMaxHeight(0.1);
        }
        if (d17.getText().equals("")) {
            q17.setOpacity(0.0);

            h17d.setMinHeight(0.1);
            h17i.setMinHeight(0.1);

            h17d.setMaxHeight(0.1);
            h17i.setMaxHeight(0.1);

            d17.setMaxHeight(0.1);
            il17.setMaxHeight(0.1);
            pl17.setMaxHeight(0.1);
            q17.setMaxHeight(0.1);

        }
        if (d18.getText().equals("")) {
            q18.setOpacity(0.0);

            h18d.setMinHeight(0.1);
            h18i.setMinHeight(0.1);

            h18d.setMaxHeight(0.1);
            h18i.setMaxHeight(0.1);

            d18.setMaxHeight(0.1);
            il18.setMaxHeight(0.1);
            pl18.setMaxHeight(0.1);
            q18.setMaxHeight(0.1);

        }
        if (d19.getText().equals("")) {
            q19.setOpacity(0.0);

            h19d.setMinHeight(0.1);
            h19i.setMinHeight(0.1);

            h19d.setMaxHeight(0.1);
            h19i.setMaxHeight(0.1);

            d19.setMaxHeight(0.1);
            il19.setMaxHeight(0.1);
            pl19.setMaxHeight(0.1);
            q19.setMaxHeight(0.1);

        }
        if (d20.getText().equals("")) {
            q20.setOpacity(0.0);

            h20d.setMinHeight(0.1);
            h20i.setMinHeight(0.1);

            h20d.setMaxHeight(0.1);
            h20i.setMaxHeight(0.1);

            d20.setMaxHeight(0.1);
            il20.setMaxHeight(0.1);
            pl20.setMaxHeight(0.1);
            q20.setMaxHeight(0.1);

            vBox.setPrefHeight(3673 - scaleV);
            aPane.setPrefHeight(3840 - scaleA);
            if (d19.getText().equals("")) {
                vBox.setPrefHeight(3673 - (scaleV * 2.0));
                aPane.setPrefHeight(3840 - (scaleA * 2.0));
                if (d18.getText().equals("")) {
                    vBox.setPrefHeight(3673 - (scaleV * 3.0));
                    aPane.setPrefHeight(3840 - (scaleA * 3.0));
                    if (d17.getText().equals("")) {
                        vBox.setPrefHeight(3673 - (scaleV * 4.0));
                        aPane.setPrefHeight(3840 - (scaleA * 4.0));
                        if (d16.getText().equals("")) {
                            vBox.setPrefHeight(3673 - (scaleV * 5.0));
                            aPane.setPrefHeight(3840 - (scaleA * 5.0));
                            if (d15.getText().equals("")) {
                                vBox.setPrefHeight(3673 - (scaleV * 6.0));
                                aPane.setPrefHeight(3840 - (scaleA * 6.0));
                                if (d14.getText().equals("")) {
                                    vBox.setPrefHeight(3673 - (scaleV * 7.0));
                                    aPane.setPrefHeight(3840 - (scaleA * 7.0));
                                    if (d13.getText().equals("")) {
                                        vBox.setPrefHeight(3673 - (scaleV * 8.0));
                                        aPane.setPrefHeight(3840 - (scaleA * 8.0));
                                        if (d12.getText().equals("")) {
                                            vBox.setPrefHeight(3673 - (scaleV * 9.0));
                                            aPane.setPrefHeight(3840 - (scaleA * 9.0));
                                            if (d11.getText().equals("")) {
                                                vBox.setPrefHeight(3673 - (scaleV * 10.0));
                                                aPane.setPrefHeight(3840 - (scaleA * 10.0));
                                                if (d10.getText().equals("")) {
                                                    vBox.setPrefHeight(3673 - (scaleV * 11.0));
                                                    aPane.setPrefHeight(3840 - (scaleA * 11.0));
                                                    if (d9.getText().equals("")) {
                                                        vBox.setPrefHeight(3673 - (scaleV * 12.0));
                                                        aPane.setPrefHeight(3840 - (scaleA * 12.0));
                                                        if (d8.getText().equals("")) {
                                                            vBox.setPrefHeight(3673 - (scaleV * 13.0));
                                                            aPane.setPrefHeight(3840 - (scaleA * 13.0));
                                                            if (d7.getText().equals("")) {
                                                                vBox.setPrefHeight(3673 - (scaleV * 14.0));
                                                                aPane.setPrefHeight(3840 - (scaleA * 14.0));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    /**
     * This method updates the total price of what a customer is ordering
     */
    private void updateTotal() {
        double t = 0.00;
        double add = 0.00;
        try {
            if (!(pl1.getText().isEmpty() && !(q1.getText().isEmpty()))) {
                add = Double.parseDouble(pl1.getText()) * Double.parseDouble(q1.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl2.getText().isEmpty() && !(q2.getText().isEmpty()))) {
                add = Double.parseDouble(pl2.getText()) * Double.parseDouble(q2.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl3.getText().isEmpty() && !(q3.getText().isEmpty()))) {
                add = Double.parseDouble(pl3.getText()) * Double.parseDouble(q3.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl4.getText().isEmpty() && !(q4.getText().isEmpty()))) {
                add = Double.parseDouble(pl4.getText()) * Double.parseDouble(q4.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl5.getText().isEmpty() && !(q5.getText().isEmpty()))) {
                add = Double.parseDouble(pl5.getText()) * Double.parseDouble(q5.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl6.getText().isEmpty() && !(q6.getText().isEmpty()))) {
                add = Double.parseDouble(pl6.getText()) * Double.parseDouble(q6.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl7.getText().isEmpty() && !(q7.getText().isEmpty()))) {
                add = Double.parseDouble(pl7.getText()) * Double.parseDouble(q7.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl8.getText().isEmpty() && !(q8.getText().isEmpty()))) {
                add = Double.parseDouble(pl8.getText()) * Double.parseDouble(q8.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl9.getText().isEmpty() && !(q9.getText().isEmpty()))) {
                add = Double.parseDouble(pl9.getText()) * Double.parseDouble(q9.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl10.getText().isEmpty() && !(q10.getText().isEmpty()))) {
                add = Double.parseDouble(pl10.getText()) * Double.parseDouble(q10.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl11.getText().isEmpty() && !(q11.getText().isEmpty()))) {
                add = Double.parseDouble(pl11.getText()) * Double.parseDouble(q11.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl12.getText().isEmpty() && !(q12.getText().isEmpty()))) {
                add = Double.parseDouble(pl12.getText()) * Double.parseDouble(q12.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl13.getText().isEmpty() && !(q13.getText().isEmpty()))) {
                add = Double.parseDouble(pl13.getText()) * Double.parseDouble(q13.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl14.getText().isEmpty() && !(q14.getText().isEmpty()))) {
                add = Double.parseDouble(pl14.getText()) * Double.parseDouble(q14.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl15.getText().isEmpty() && !(q15.getText().isEmpty()))) {
                add = Double.parseDouble(pl15.getText()) * Double.parseDouble(q15.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl16.getText().isEmpty() && !(q16.getText().isEmpty()))) {
                add = Double.parseDouble(pl16.getText()) * Double.parseDouble(q16.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl17.getText().isEmpty() && !(q17.getText().isEmpty()))) {
                add = Double.parseDouble(pl17.getText()) * Double.parseDouble(q17.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl18.getText().isEmpty() && !(q18.getText().isEmpty()))) {
                add = Double.parseDouble(pl18.getText()) * Double.parseDouble(q18.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl19.getText().isEmpty() && !(q19.getText().isEmpty()))) {
                add = Double.parseDouble(pl19.getText()) * Double.parseDouble(q19.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }
        try {
            if (!(pl20.getText().isEmpty() && !(q20.getText().isEmpty()))) {
                add = Double.parseDouble(pl20.getText()) * Double.parseDouble(q20.getText());
                t += add;
            }
        } catch (NumberFormatException ignored) {
        }

        totalPLabel.setText(String.format("%.2f", t));
    }

    /**
     * This updates the total when the keyboard is used
     *
     * @param keyEvent is triggered when a user uses the keyboard
     */

    @FXML
    public void onKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() != KeyCode.ESCAPE) {
            updateTotal();
        }
    }

    /**
     * This method updates the page when a scrollEvent occurs
     *
     * @param scrollEvent is triggered when the page is scrolled
     */

    @FXML
    public void onScrollFin(ScrollEvent scrollEvent) {
        updateTotal();
    }

    /**
     * This method returns a user to the customer home page
     *
     * @param actionEvent is triggered when the go back button is pressed
     */

    @FXML
    public void onBackButtClick(ActionEvent actionEvent) {
        Parent newRoot;
        try {
            Stage stage = (Stage) backButt.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customer-view.fxml"));
            newRoot = loader.load();

            CustomerController cCont = loader.getController();
            cCont.setUserText(username);//550, 523

            stage.setTitle("Main menu");
            stage.setHeight(550);
            stage.setMaxHeight(550);
            stage.setWidth(550);
            stage.setMaxWidth(550);
            stage.centerOnScreen();
            stage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTboxEntered(MouseEvent mouseEvent) {
        hTbox.setOnMouseEntered((event) -> {
            updateTotal();
        });
    }

    /**
     * The total is updated when a mouse is clicked
     *
     * @param mouseEvent is triggered when the mouse is moved
     */

    public void onQClick(MouseEvent mouseEvent) {
        q1.setOnMouseClicked((event) -> {
            updateTotal();
        });
        q2.setOnMouseClicked((event) -> {
            updateTotal();
        });
        q3.setOnMouseClicked((event) -> {
            updateTotal();
        });
        q4.setOnMouseClicked((event) -> {
            updateTotal();
        });
        q5.setOnMouseClicked((event) -> {
            updateTotal();
        });
    }
}