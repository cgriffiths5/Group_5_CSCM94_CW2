package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Objects;

public class ReportsController {

    @FXML
    public Label item1;
    public Label item2;
    public Label item3;
    public Label firstOrderedNum;
    public Label secondOrderedNum;
    public Label thirdOrderedNum;
    public Label Day;
    public Label DayBookingVal;
    public Label Hour;
    public Label HourBookingVal;
    public Label OrderHour;
    public Label hourAvgOrders;
    public Label Customer;
    public Label customerOrdersVal;
    public Button Refresh;
    public Button GoBack;
    private String username;

    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    public ReportsController() throws SQLException {
    }

    public void setUserText(String text) {
        username = text;
    }

    /**
     * add info
     */
    public void generate() {
        getTop3Items();
        // sets the name of the menu item, and how many times it has been ordered
        getMaxAvgDayBooking();
        // sets day label to the highest booking average day e.g. Monday, and sets the value to the Val label
        getMaxAvgHourBooking();
        // sets hour label to the highest booking average hour eg: 1200, and sets the value to the Val label
        getMaxAvgOrderHour();
        // sets the OrderHour label to the hour with the most frequent orders placed
        getMaxOrderCustomer();
        // gets the customer who placed the most orders and how many orders that is
    }

    private void getMaxAvgOrderHour() {
        String query = "SELECT * FROM most_orders_hour";
        try (Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                hourAvgOrders.setText(String.valueOf(rs.getInt("count") + "  avg"));
                OrderHour.setText(String.valueOf(rs.getInt("hour")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add info
     */
    private void getMaxOrderCustomer() {
        String query = "SELECT * FROM active_customer";
        try (Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String fName = rs.getString("f_name");
                String first = fName.substring(0, 1).toUpperCase() + fName.substring(1);
                String lName = rs.getString("l_name");
                String last = lName.substring(0, 1).toUpperCase() + lName.substring(1);
                String fullName = first + " " + last;
                Customer.setText(fullName + "     Username:   " + rs.getString("username"));
                int orders = rs.getInt("customerMostOrders");
                customerOrdersVal.setText(String.valueOf(orders));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add info
     */
    private void getMaxAvgHourBooking() {
        String query = "SELECT * FROM most_booked_hour";
        try (Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                HourBookingVal.setText(String.valueOf(rs.getInt("count")) + "  avg");
                Hour.setText(String.valueOf(rs.getString("hour")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add info
     */
    private void getMaxAvgDayBooking() {
        String query = "SELECT * FROM most_booked_day";
        try (Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DayBookingVal.setText(String.valueOf(rs.getInt("count")) + "  avg");
                Day.setText(dayOfWeek(rs.getDate("date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> allOrdersItems() {
        ArrayList<String> a = new ArrayList<>();
        String query = "SELECT * FROM items_separate_orders";
        try (Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                a.add(rs.getString("1st"));
                a.add(rs.getString("2nd"));
                a.add(rs.getString("3rd"));
                a.add(rs.getString("4th"));
                a.add(rs.getString("5th"));
                a.add(rs.getString("6th"));
                a.add(rs.getString("7th"));
                a.add(rs.getString("8th"));
                a.add(rs.getString("9th"));
                a.add(rs.getString("10th"));
                a.add(rs.getString("11th"));
                a.add(rs.getString("12th"));
                a.add(rs.getString("13th"));
                a.add(rs.getString("14th"));
                a.add(rs.getString("15th"));
                a.add(rs.getString("16th"));
                a.add(rs.getString("17th"));
                a.add(rs.getString("18th"));
                a.add(rs.getString("19th"));
                a.add(rs.getString("20th"));
                a.add(rs.getString("21st"));
                a.add(rs.getString("22nd"));
                a.add(rs.getString("23rd"));
                a.add(rs.getString("24th"));
                a.add(rs.getString("25th"));
                a.add(rs.getString("26th"));
                a.add(rs.getString("27th"));
                a.add(rs.getString("28th"));
                a.add(rs.getString("29th"));
                a.add(rs.getString("30th"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        a.removeIf(Objects::isNull);
        return a;
    }

    private ArrayList<String> menuItems() {
        ArrayList<String> a = new ArrayList<>();
        String query = "SELECT item FROM menu";
        try (Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                a.add(rs.getString("item"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * first get every single item in items_separate_orders view
     * put them all in a giant arraylist
     * get the first menu item from the menu table and call the string item1
     * get the second menu item etc...
     * put all the menu items in an arraylist
     * set mostFreq item = menu.get(0)
     * set itemCount = 0
     * set maxCount = 0
     * do a loop where you increment itemCount whenever orders(i) = menu(j)
     * inc i every time, once at the end of the list, inc j,
     * each time you go through the list, if maxCount < itemCount
     * mostFreqItem = menu(j)
     * maxCount = itemCount
     * itemCount = 0
     */
    private void getTop3Items() {
        ArrayList<String> orders = allOrdersItems();
        ArrayList<String> menu = menuItems();
        System.out.println(menu);
        String highestItem = menu.get(0);
        String item;
        int maxCount = 0;
        int count = 0;
        for (String s : menu) {
            item = s;
            count = 0;
            for (String order : orders) {
                if (item.equals(order))
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                highestItem = item;
            }
        }
        item1.setText(highestItem);
        firstOrderedNum.setText(String.valueOf(maxCount));
        menu.removeAll(Collections.singleton(highestItem));
        highestItem = menu.get(0);
        maxCount = 0;
        count = 0;
        for (String s : menu) {
            item = s;
            count = 0;
            for (String order : orders) {
                if (item.equals(order))
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                highestItem = item;
            }
        }
        item2.setText(highestItem);
        secondOrderedNum.setText(String.valueOf(maxCount));
        menu.removeAll(Collections.singleton(highestItem));
        highestItem = menu.get(0);
        maxCount = 0;
        count = 0;
        for (String s : menu) {
            item = s;
            count = 0;
            for (String order : orders) {
                if (item.equals(order))
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                highestItem = item;
            }
        }
        item3.setText(highestItem);
        thirdOrderedNum.setText(String.valueOf(maxCount));


    }

    /**
     * add info
     */
    public void refresh() {
        try {
            Stage stage = (Stage) Refresh.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("reports-view.fxml"));
            Parent newRoot = loader.load();
            ReportsController RCont = loader.getController();
            RCont.generate();
            stage.setTitle("Reports");
            stage.setHeight(800.0);
            stage.setMaxHeight(800.0);
            stage.setWidth(550.0);
            stage.setMaxWidth(550.0);
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    /**
     * @param actionEvent add info
     */
    @FXML
    public void onClickRefresh(ActionEvent actionEvent) {
        refresh();
    }

    /**
     * @param actionEvent add info
     */
    @FXML
    public void onClickGoBack(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) GoBack.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("manager-view.fxml"));
            Parent newRoot = loader.load();
            ManagerController mCont = loader.getController();
            Rectangle2D sBound = Screen.getPrimary().getVisualBounds();
            mCont.setUserText(username);
            stage.setTitle("Manager Homepage");
            stage.setY(sBound.getHeight() - (sBound.getHeight()/1.25));
            stage.setX(sBound.getWidth() - (sBound.getWidth()/1.25));
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }

    public String dayOfWeek(Date date) {
        String day = "Date Error";
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayNum = c.get(Calendar.DAY_OF_WEEK);
        return switch (dayNum) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> day;
        };
    }
}
