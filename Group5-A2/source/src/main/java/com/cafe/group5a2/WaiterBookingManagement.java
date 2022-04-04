package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

/**
 * This class displays and shows all the bookings that have
 * been made by a customer. It gives the waiter the ability
 * to approve or reject the booking.
 * All the information is taken from the database and when
 * a decision has been made the database is updated
 *
 * @author Adam Tucker
 * @author Cameron Turner
 * @version 1.0
 */

public class WaiterBookingManagement {
    public Button refreshButton;
    public Button returnButton;

    public CheckBox reject1;
    public CheckBox reject2;
    public CheckBox reject3;
    public CheckBox reject4;
    public CheckBox reject5;
    public CheckBox reject6;
    public CheckBox reject7;
    public CheckBox reject8;
    public CheckBox reject9;
    public CheckBox reject10;
    public CheckBox reject11;
    public CheckBox reject12;
    public CheckBox reject13;
    public CheckBox reject14;
    public CheckBox reject15;
    public CheckBox reject16;
    public CheckBox reject17;
    public CheckBox reject18;
    public CheckBox reject19;
    public CheckBox reject20;
    public CheckBox reject21;
    public CheckBox reject22;

    public CheckBox approve1;
    public CheckBox approve2;
    public CheckBox approve3;
    public CheckBox approve4;
    public CheckBox approve5;
    public CheckBox approve6;
    public CheckBox approve7;
    public CheckBox approve8;
    public CheckBox approve9;
    public CheckBox approve10;
    public CheckBox approve11;
    public CheckBox approve12;
    public CheckBox approve13;
    public CheckBox approve14;
    public CheckBox approve15;
    public CheckBox approve16;
    public CheckBox approve17;
    public CheckBox approve18;
    public CheckBox approve19;
    public CheckBox approve20;
    public CheckBox approve21;
    public CheckBox approve22;

    public Label name1;
    public Label name2;
    public Label name3;
    public Label name4;
    public Label name5;
    public Label name6;
    public Label name7;
    public Label name8;
    public Label name9;
    public Label name10;
    public Label name11;
    public Label name12;
    public Label name13;
    public Label name14;
    public Label name15;
    public Label name16;
    public Label name17;
    public Label name18;
    public Label name19;
    public Label name20;
    public Label name21;
    public Label name22;

    public Label data1;
    public Label data2;
    public Label data3;
    public Label data4;
    public Label data5;
    public Label data6;
    public Label data7;
    public Label data8;
    public Label data9;
    public Label data10;
    public Label data11;
    public Label data12;
    public Label data13;
    public Label data14;
    public Label data15;
    public Label data16;
    public Label data17;
    public Label data18;
    public Label data19;
    public Label data20;
    public Label data21;
    public Label data22;

    public Label tables1;
    public Label tables2;
    public Label tables3;
    public Label tables4;
    public Label tables5;
    public Label tables6;
    public Label tables7;
    public Label tables8;
    public Label tables9;
    public Label tables10;
    public Label tables11;
    public Label tables12;
    public Label tables13;
    public Label tables14;
    public Label tables15;
    public Label tables16;
    public Label tables17;
    public Label tables18;
    public Label tables19;
    public Label tables20;
    public Label tables21;
    public Label tables22;

    Connection connect = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");

    private String username;
    private String date1;
    private String date2;
    private String date3;
    private String date4;
    private String date5;
    private String date6;
    private String date7;
    private String date8;
    private String date9;
    private String date10;
    private String date11;
    private String date12;
    private String date13;
    private String date14;
    private String date15;
    private String date16;
    private String date17;
    private String date18;
    private String date19;
    private String date20;
    private String date21;
    private String date22;
    private int hour1;
    private int hour2;
    private int hour3;
    private int hour4;
    private int hour5;
    private int hour6;
    private int hour7;
    private int hour8;
    private int hour9;
    private int hour10;
    private int hour11;
    private int hour12;
    private int hour13;
    private int hour14;
    private int hour15;
    private int hour16;
    private int hour17;
    private int hour18;
    private int hour19;
    private int hour20;
    private int hour21;
    private int hour22;
    private int capID1;
    private int capID2;
    private int capID3;
    private int capID4;
    private int capID5;
    private int capID6;
    private int capID7;
    private int capID8;
    private int capID9;
    private int capID10;
    private int capID11;
    private int userID1;
    private int userID2;
    private int userID3;
    private int userID4;
    private int userID5;
    private int userID6;
    private int userID7;
    private int userID8;
    private int userID9;
    private int userID10;
    private int userID11;
    private int userID12;
    private int userID13;
    private int userID14;
    private int userID15;
    private int userID16;
    private int userID17;
    private int userID18;
    private int userID19;
    private int userID20;
    private int userID21;
    private int userID22;

    /**
     * @throws SQLException throw a type of Exception that the IDE doesn't support
     */
    public WaiterBookingManagement() throws SQLException {
    }

    /**
     * Returns void
     * sets the username of the user
     *
     * @param text the user name
     */
    @FXML
    public void setUser(String text) {
        username = text;
    }

    /**
     * Returns void
     * When refresh button has been clicked this method
     * refreshes the page and updates the information
     *
     * @param actionEvent refresh button
     */
    @FXML
    public void onClickRefreshPage(ActionEvent actionEvent) {
        refresh();
    }

    /**
     * Returns void
     * This is called when the refresh button has been pressed
     */
    private void refresh() {
        try {
            Stage stage = (Stage) refreshButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("waiterApproveBooking.fxml"));
            Parent newRoot = loader.load();

            WaiterBookingManagement wBMng = loader.getController();
            wBMng.setUser(username);
            wBMng.setLabels();
            wBMng.hideEmpty();

            stage.centerOnScreen();
            stage.setTitle("Booking Management");
            stage.setHeight(800);
            stage.setWidth(800);
            stage.setMaxWidth(800);
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * This method sets labels 2-22 to hidden
     * if there is no data to show
     */
    public void hideBelow1() {
        if (name2.getText().equals("Name")) {
            name2.setOpacity(0.0);
            data2.setOpacity(0.0);
            tables2.setOpacity(0.0);
            approve2.setOpacity(0.0);
            reject2.setOpacity(0.0);
        }
        if (name3.getText().equals("Name")) {
            name3.setOpacity(0.0);
            data3.setOpacity(0.0);
            tables3.setOpacity(0.0);
            approve3.setOpacity(0.0);
            reject3.setOpacity(0.0);
        }
        if (name4.getText().equals("Name")) {
            name4.setOpacity(0.0);
            data4.setOpacity(0.0);
            tables4.setOpacity(0.0);
            approve4.setOpacity(0.0);
            reject4.setOpacity(0.0);
        }
        if (name5.getText().equals("Name")) {
            name5.setOpacity(0.0);
            data5.setOpacity(0.0);
            tables5.setOpacity(0.0);
            approve5.setOpacity(0.0);
            reject5.setOpacity(0.0);
        }
        if (name6.getText().equals("Name")) {
            name6.setOpacity(0.0);
            data6.setOpacity(0.0);
            tables6.setOpacity(0.0);
            approve6.setOpacity(0.0);
            reject6.setOpacity(0.0);
        }
        if (name7.getText().equals("Name")) {
            name7.setOpacity(0.0);
            data7.setOpacity(0.0);
            tables7.setOpacity(0.0);
            approve7.setOpacity(0.0);
            reject7.setOpacity(0.0);
        }
        if (name8.getText().equals("Name")) {
            name8.setOpacity(0.0);
            data8.setOpacity(0.0);
            tables8.setOpacity(0.0);
            approve8.setOpacity(0.0);
            reject8.setOpacity(0.0);
        }
        if (name9.getText().equals("Name")) {
            name9.setOpacity(0.0);
            data9.setOpacity(0.0);
            tables9.setOpacity(0.0);
            approve9.setOpacity(0.0);
            reject9.setOpacity(0.0);
        }
        if (name10.getText().equals("Name")) {
            name10.setOpacity(0.0);
            data10.setOpacity(0.0);
            tables10.setOpacity(0.0);
            approve10.setOpacity(0.0);
            reject10.setOpacity(0.0);
        }
        if (name11.getText().equals("Name")) {
            name11.setOpacity(0.0);
            data11.setOpacity(0.0);
            tables11.setOpacity(0.0);
            approve11.setOpacity(0.0);
            reject11.setOpacity(0.0);
        }
        if (name12.getText().equals("Name")) {
            name12.setOpacity(0.0);
            data12.setOpacity(0.0);
            tables12.setOpacity(0.0);
            approve12.setOpacity(0.0);
            reject12.setOpacity(0.0);
        }
        if (name13.getText().equals("Name")) {
            name13.setOpacity(0.0);
            data13.setOpacity(0.0);
            tables13.setOpacity(0.0);
            approve13.setOpacity(0.0);
            reject13.setOpacity(0.0);
        }
        if (name14.getText().equals("Name")) {
            name14.setOpacity(0.0);
            data14.setOpacity(0.0);
            tables14.setOpacity(0.0);
            approve14.setOpacity(0.0);
            reject14.setOpacity(0.0);
        }
        if (name15.getText().equals("Name")) {
            name15.setOpacity(0.0);
            data15.setOpacity(0.0);
            tables15.setOpacity(0.0);
            approve15.setOpacity(0.0);
            reject15.setOpacity(0.0);
        }
        if (name16.getText().equals("Name")) {
            name16.setOpacity(0.0);
            data16.setOpacity(0.0);
            tables16.setOpacity(0.0);
            approve16.setOpacity(0.0);
            reject16.setOpacity(0.0);
        }
        if (name17.getText().equals("Name")) {
            name17.setOpacity(0.0);
            data17.setOpacity(0.0);
            tables17.setOpacity(0.0);
            approve17.setOpacity(0.0);
            reject17.setOpacity(0.0);
        }
        if (name18.getText().equals("Name")) {
            name18.setOpacity(0.0);
            data18.setOpacity(0.0);
            tables18.setOpacity(0.0);
            approve18.setOpacity(0.0);
            reject18.setOpacity(0.0);
        }
        if (name19.getText().equals("Name")) {
            name19.setOpacity(0.0);
            data19.setOpacity(0.0);
            tables19.setOpacity(0.0);
            approve19.setOpacity(0.0);
            reject19.setOpacity(0.0);
        }
        if (name20.getText().equals("Name")) {
            name20.setOpacity(0.0);
            data20.setOpacity(0.0);
            tables20.setOpacity(0.0);
            approve20.setOpacity(0.0);
            reject20.setOpacity(0.0);
        }
        if (name21.getText().equals("Name")) {
            name21.setOpacity(0.0);
            data21.setOpacity(0.0);
            tables21.setOpacity(0.0);
            approve21.setOpacity(0.0);
            reject21.setOpacity(0.0);
        }
        if (name22.getText().equals("Name")) {
            name22.setOpacity(0.0);
            data22.setOpacity(0.0);
            tables22.setOpacity(0.0);
            approve22.setOpacity(0.0);
            reject22.setOpacity(0.0);
        }
    }

    /**
     * Returns void.
     * When there is only one booking the rest of the
     * labels are hidden and the check boxes are
     * set to be see through
     */
    public void noBookings() {
        if (name1.getText().equals("Name")) {
            name1.setText("No Unapproved Bookings");
            data1.setOpacity(0.0);
            tables1.setOpacity(0.0);
            approve1.setOpacity(0.0);
            reject1.setOpacity(0.0);
        }
        hideBelow1();
    }

    /**
     * Returns void.
     * looks at the first line and if there is
     * no bookings then it hides all data
     */
    public void hideEmpty() {
        if (name1.getText().equals("Name")) {
            noBookings();
        } else {
            hideBelow1();
        }
    }

    /**
     * Returns void.
     * This method is called when a button is clicked
     * and returns from the current page to the
     * page before which is the waiter view
     *
     * @param actionEvent Return button
     */
    @FXML
    public void onClickReturnButton(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) returnButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("waiter-view.fxml"));
            Parent newRoot = loader.load();

            WaiterController wCont = loader.getController();
            wCont.setUserText(username);
            wCont.setUserText(username);
            wCont.setResOrdTab();
            wCont.setTakeawayOrdTable();
            wCont.resetCheckBoxes();

            stage.setTitle("Waiter Homepage");
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


    /**
     * Returns void
     * Updates the page with all the relevant information from the database
     * about the customer bookings that need to be approve
     * or rejected
     */
    public void setLabels() {

        String query = "SELECT * FROM waiter_booking_view";

        try (Statement stmt = connect.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);
            int i = 1;
            int u1 = 0;
            int u2 = 0;
            int u3 = 0;
            int u4 = 0;
            int u5 = 0;
            int u6 = 0;
            int u7 = 0;
            int u8 = 0;
            int u9 = 0;
            int u10 = 0;
            int u11 = 0;
            int u12 = 0;
            int u13 = 0;
            int u14 = 0;
            int u15 = 0;
            int u16 = 0;
            int u17 = 0;
            int u18 = 0;
            int u19 = 0;
            int u20 = 0;
            int u21 = 0;
            int u22 = 0;
            String d1 = "0000-00-00";
            String d2 = "0000-00-00";
            String d3 = "0000-00-00";
            String d4 = "0000-00-00";
            String d5 = "0000-00-00";
            String d6 = "0000-00-00";
            String d7 = "0000-00-00";
            String d8 = "0000-00-00";
            String d9 = "0000-00-00";
            String d10 = "0000-00-00";
            String d11 = "0000-00-00";
            String d12 = "0000-00-00";
            String d13 = "0000-00-00";
            String d14 = "0000-00-00";
            String d15 = "0000-00-00";
            String d16 = "0000-00-00";
            String d17 = "0000-00-00";
            String d18 = "0000-00-00";
            String d19 = "0000-00-00";
            String d20 = "0000-00-00";
            String d21 = "0000-00-00";
            String d22 = "0000-00-00";
            int h1 = 0;
            int h2 = 0;
            int h3 = 0;
            int h4 = 0;
            int h5 = 0;
            int h6 = 0;
            int h7 = 0;
            int h8 = 0;
            int h9 = 0;
            int h10 = 0;
            int h11 = 0;
            int h12 = 0;
            int h13 = 0;
            int h14 = 0;
            int h15 = 0;
            int h16 = 0;
            int h17 = 0;
            int h18 = 0;
            int h19 = 0;
            int h20 = 0;
            int h21 = 0;
            int h22 = 0;
            while (rs.next()) {
                String d = rs.getDate("date").toString();
                int h = rs.getInt("hour");
                int g = rs.getInt("guests");
                int u = rs.getInt("user_ID");
                String l = rs.getString("l_name");
                int t = rs.getInt("table_number");
                if (u1 == 0 && d1.equals("0000-00-00") && h1 == 0 && i == 1) {
                    tables1.setText("Table(s): " + t);
                    userID1 = u;
                    date1 = d;
                    hour1 = h;
                    name1.setText(l);
                    data1.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u1 = u;
                    d1 = d;
                    h1 = h;
                } else if (i == 1) {
                    if (d.compareTo(d1) == 0 && h == h1 && u == u1)
                        tables1.setText(tables1.getText() + ", " + t);
                    else i++;


                }
                if (u2 == 0 && d2.equals("0000-00-00") && h2 == 0 && i == 2) {
                    tables2.setText("Table(s): " + t);
                    userID2 = u;
                    date2 = d;
                    hour2 = h;
                    name2.setText(l);
                    data2.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u2 = u;
                    d2 = d;
                    h2 = h;
                } else if (i == 2) {
                    if (d.compareTo(d2) == 0 && h == h2 && u == u2)
                        tables2.setText(tables2.getText() + ", " + t);
                    else i++;
                }
                if (u3 == 0 && d3.equals("0000-00-00") && h3 == 0 && i == 3) {
                    tables3.setText("Table(s): " + t);
                    userID3 = u;
                    date3 = d;
                    hour3 = h;
                    name3.setText(l);
                    data3.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u3 = u;
                    d3 = d;
                    h3 = h;
                } else if (i == 3) {
                    if (d.compareTo(d3) == 0 && h == h3 && u == u3)
                        tables3.setText(tables3.getText() + ", " + t);
                    else i++;
                }
                if (u4 == 0 && d4.equals("0000-00-00") && h4 == 0 && i == 4) {
                    tables4.setText("Table(s): " + t);
                    userID4 = u;
                    date4 = d;
                    hour4 = h;
                    name4.setText(l);
                    data4.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u4 = u;
                    d4 = d;
                    h4 = h;
                } else if (i == 4) {
                    if (d.compareTo(d4) == 0 && h == h4 && u == u4)
                        tables4.setText(tables4.getText() + ", " + t);
                    else i++;
                }
                if (u5 == 0 && d5.equals("0000-00-00") && h5 == 0 && i == 5) {
                    tables5.setText("Table(s): " + t);
                    userID5 = u;
                    date5 = d;
                    hour5 = h;
                    name5.setText(l);
                    data5.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u5 = u;
                    d5 = d;
                    h5 = h;
                } else if (i == 5) {
                    if (d.compareTo(d5) == 0 && h == h5 && u == u5)
                        tables5.setText(tables5.getText() + ", " + t);
                    else i++;
                }
                if (u6 == 0 && d6.equals("0000-00-00") && h6 == 0 && i == 6) {
                    tables6.setText("Table(s): " + t);
                    userID6 = u;
                    date6 = d;
                    hour6 = h;
                    name6.setText(l);
                    data6.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u6 = u;
                    d6 = d;
                    h6 = h;
                } else if (i == 6) {
                    if (d.compareTo(d6) == 0 && h == h6 && u == u6)
                        tables6.setText(tables6.getText() + ", " + t);
                    else i++;
                }
                if (u7 == 0 && d7.equals("0000-00-00") && h7 == 0 && i == 7) {
                    tables7.setText("Table(s): " + t);
                    userID7 = u;
                    date7 = d;
                    hour7 = h;
                    name7.setText(l);
                    data7.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u7 = u;
                    d7 = d;
                    h7 = h;
                } else if (i == 7) {
                    if (d.compareTo(d7) == 0 && h == h7 && u == u7)
                        tables7.setText(tables7.getText() + ", " + t);
                    else i++;
                }
                if (u8 == 0 && d8.equals("0000-00-00") && h8 == 0 && i == 8) {
                    tables8.setText("Table(s): " + t);
                    userID8 = u;
                    date8 = d;
                    hour8 = h;
                    name8.setText(l);
                    data8.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u8 = u;
                    d8 = d;
                    h8 = h;
                } else if (i == 8) {
                    if (d.compareTo(d8) == 0 && h == h8 && u == u8)
                        tables8.setText(tables8.getText() + ", " + t);
                    else i++;
                }
                if (u9 == 0 && d9.equals("0000-00-00") && h9 == 0 && i == 9) {
                    tables9.setText("Table(s): " + t);
                    userID9 = u;
                    date9 = d;
                    hour9 = h;
                    name9.setText(l);
                    data9.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u9 = u;
                    d9 = d;
                    h9 = h;
                } else if (i == 9) {
                    if (d.compareTo(d9) == 0 && h == h9 && u == u9)
                        tables9.setText(tables9.getText() + ", " + t);
                    else i++;
                }
                if (u10 == 0 && d10.equals("0000-00-00") && h10 == 0 && i == 10) {
                    tables10.setText("Table(s): " + t);
                    userID10 = u;
                    date10 = d;
                    hour10 = h;
                    name10.setText(l);
                    data10.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u10 = u;
                    d10 = d;
                    h10 = h;
                } else if (i == 10) {
                    if (d.compareTo(d10) == 0 && h == h10 && u == u10)
                        tables10.setText(tables10.getText() + ", " + t);
                    else i++;
                }
                if (u11 == 0 && d11.equals("0000-00-00") && h11 == 0 && i == 11) {
                    tables11.setText("Table(s): " + t);
                    userID11 = u;
                    date11 = d;
                    hour11 = h;
                    name11.setText(l);
                    data11.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u11 = u;
                    d11 = d;
                    h11 = h;
                } else if (i == 11) {
                    if (d.compareTo(d11) == 0 && h == h11 && u == u11)
                        tables11.setText(tables11.getText() + ", " + t);
                    else i++;
                }
                if (u12 == 0 && d12.equals("0000-00-00") && h12 == 0 && i == 12) {
                    tables12.setText("Table(s): " + t);
                    userID12 = u;
                    date12 = d;
                    hour12 = h;
                    name12.setText(l);
                    data12.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u12 = u;
                    d12 = d;
                    h12 = h;
                } else if (i == 12) {
                    if (d.compareTo(d12) == 0 && h == h12 && u == u12)
                        tables12.setText(tables12.getText() + ", " + t);
                    else i++;
                }
                if (u13 == 0 && d13.equals("0000-00-00") && h13 == 0 && i == 13) {
                    tables13.setText("Table(s): " + t);
                    userID13 = u;
                    date13 = d;
                    hour13 = h;
                    name13.setText(l);
                    data13.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u13 = u;
                    d13 = d;
                    h13 = h;
                } else if (i == 13) {
                    if (d.compareTo(d13) == 0 && h == h13 && u == u13)
                        tables13.setText(tables13.getText() + ", " + t);
                    else i++;
                }
                if (u14 == 0 && d14.equals("0000-00-00") && h14 == 0 && i == 14) {
                    tables14.setText("Table(s): " + t);
                    userID14 = u;
                    date14 = d;
                    hour14 = h;
                    name14.setText(l);
                    data14.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u14 = u;
                    d14 = d;
                    h14 = h;
                } else if (i == 14) {
                    if (d.compareTo(d14) == 0 && h == h14 && u == u14)
                        tables14.setText(tables14.getText() + ", " + t);
                    else i++;
                }
                if (u15 == 0 && d15.equals("0000-00-00") && h15 == 0 && i == 15) {
                    tables15.setText("Table(s): " + t);
                    userID15 = u;
                    date15 = d;
                    hour15 = h;
                    name15.setText(l);
                    data15.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u15 = u;
                    d15 = d;
                    h15 = h;
                } else if (i == 15) {
                    if (d.compareTo(d15) == 0 && h == h15 && u == u15)
                        tables15.setText(tables15.getText() + ", " + t);
                    else i++;
                }
                if (u16 == 0 && d16.equals("0000-00-00") && h16 == 0 && i == 16) {
                    tables16.setText("Table(s): " + t);
                    userID16 = u;
                    date16 = d;
                    hour16 = h;
                    name16.setText(l);
                    data16.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u16 = u;
                    d16 = d;
                    h16 = h;
                } else if (i == 16) {
                    if (d.compareTo(d16) == 0 && h == h16 && u == u16)
                        tables16.setText(tables16.getText() + ", " + t);
                    else i++;
                }
                if (u17 == 0 && d17.equals("0000-00-00") && h17 == 0 && i == 17) {
                    tables17.setText("Table(s): " + t);
                    userID17 = u;
                    date17 = d;
                    hour17 = h;
                    name17.setText(l);
                    data17.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u17 = u;
                    d17 = d;
                    h17 = h;
                } else if (i == 17) {
                    if (d.compareTo(d17) == 0 && h == h17 && u == u17)
                        tables17.setText(tables17.getText() + ", " + t);
                    else i++;
                }
                if (u18 == 0 && d18.equals("0000-00-00") && h18 == 0 && i == 18) {
                    tables18.setText("Table(s): " + t);
                    userID18 = u;
                    date18 = d;
                    hour18 = h;
                    name18.setText(l);
                    data18.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u18 = u;
                    d18 = d;
                    h18 = h;
                } else if (i == 18) {
                    if (d.compareTo(d18) == 0 && h == h18 && u == u18)
                        tables18.setText(tables18.getText() + ", " + t);
                    else i++;
                }
                if (u19 == 0 && d19.equals("0000-00-00") && h19 == 0 && i == 19) {
                    tables19.setText("Table(s): " + t);
                    userID19 = u;
                    date19 = d;
                    hour19 = h;
                    name19.setText(l);
                    data19.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u19 = u;
                    d19 = d;
                    h19 = h;
                } else if (i == 19) {
                    if (d.compareTo(d19) == 0 && h == h19 && u == u19)
                        tables19.setText(tables19.getText() + ", " + t);
                    else i++;
                }
                if (u20 == 0 && d20.equals("0000-00-00") && h20 == 0 && i == 20) {
                    tables20.setText("Table(s): " + t);
                    userID20 = u;
                    date20 = d;
                    hour20 = h;
                    name20.setText(l);
                    data20.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u20 = u;
                    d20 = d;
                    h20 = h;
                } else if (i == 20) {
                    if (d.compareTo(d20) == 0 && h == h20 && u == u20)
                        tables20.setText(tables20.getText() + ", " + t);
                    else i++;
                }
                if (u21 == 0 && d21.equals("0000-00-00") && h21 == 0 && i == 21) {
                    tables21.setText("Table(s): " + t);
                    userID21 = u;
                    date21 = d;
                    hour21 = h;
                    name21.setText(l);
                    data21.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u21 = u;
                    d21 = d;
                    h21 = h;
                } else if (i == 21) {
                    if (d.compareTo(d21) == 0 && h == h21 && u == u21)
                        tables21.setText(tables21.getText() + ", " + t);
                    else i++;
                }
                if (u22 == 0 && d22.equals("0000-00-00") && h22 == 0 && i == 22) {
                    tables22.setText("Table(s): " + t);
                    userID22 = u;
                    date22 = d;
                    hour22 = h;
                    name22.setText(l);
                    data22.setText(d + "    " + h / 100 + ":00    Guests: " + g);
                    u22 = u;
                    d22 = d;
                    h22 = h;
                } else if (i == 22) {
                    if (d.compareTo(d22) == 0 && h == h22 && u == u22)
                        tables22.setText(tables22.getText() + ", " + t);
                    else i++;
                }


            }

        } catch (SQLException e) {
            hideEmpty();
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * sets the capacity ids using the userId, data and hour
     * of the booking
     *
     * @param uID  user ID
     * @param d    the date
     * @param hour hour in the day
     */
    public void setCapIDs(int uID, String d, int hour) {
        Date date = Date.valueOf(d);
        String query = "SELECT * FROM waiter_booking_view WHERE user_ID = " + uID + " AND date = '" + date + "' AND hour = " + hour + "";
        try (Statement stmt = connect.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int i = 1;
            while (rs.next()) {
                if (i == 1) capID1 = rs.getInt("cap_ID");
                if (i == 2) capID2 = rs.getInt("cap_ID");
                if (i == 3) capID3 = rs.getInt("cap_ID");
                if (i == 4) capID4 = rs.getInt("cap_ID");
                if (i == 5) capID5 = rs.getInt("cap_ID");
                if (i == 6) capID6 = rs.getInt("cap_ID");
                if (i == 7) capID7 = rs.getInt("cap_ID");
                if (i == 8) capID8 = rs.getInt("cap_ID");
                if (i == 9) capID9 = rs.getInt("cap_ID");
                if (i == 10) capID10 = rs.getInt("cap_ID");
                if (i == 11) capID11 = rs.getInt("cap_ID");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * This method will update the capacity table
     * availability to one using and SQL query
     *
     * @param cID customer ID
     */
    public void updateCapacityTableAvailabilityTo1(int cID) {
        String query = "UPDATE capacity SET is_available = 1 WHERE cap_ID = " + cID + "";
        try (Statement stmt = connect.createStatement()) {
            stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * This will delete a booking by using an
     * SQL query
     *
     * @param cID customer ID
     */
    public void deleteBooking(int cID) {
        String query = "DELETE FROM bookings WHERE b_cap_ID = " + cID + "";
        try (Statement stmt = connect.createStatement()) {
            stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void.
     * This method will approve the booking and
     * using an SQL query will update the database
     *
     * @param cID customer ID
     */
    public void approveBooking(int cID) {
        String query = "UPDATE bookings SET approved = 1 WHERE b_cap_ID = " + cID + "";
        try (Statement stmt = connect.createStatement()) {
            stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns void
     * Gets correct capID and marks approve to all of them
     */
    public void approve() {
        approveBooking(capID1);
        approveBooking(capID2);
        approveBooking(capID3);
        approveBooking(capID4);
        approveBooking(capID5);
        approveBooking(capID6);
        approveBooking(capID7);
        approveBooking(capID8);
        approveBooking(capID9);
        approveBooking(capID10);
        approveBooking(capID11);
    }

    /**
     * Returns void
     * Gets the capacity id and updates the availability to one
     * then deletes the id on each booking
     */
    public void remove() {
        updateCapacityTableAvailabilityTo1(capID1);
        deleteBooking(capID1);
        updateCapacityTableAvailabilityTo1(capID2);
        deleteBooking(capID2);
        updateCapacityTableAvailabilityTo1(capID3);
        deleteBooking(capID3);
        updateCapacityTableAvailabilityTo1(capID4);
        deleteBooking(capID4);
        updateCapacityTableAvailabilityTo1(capID5);
        deleteBooking(capID5);
        updateCapacityTableAvailabilityTo1(capID6);
        deleteBooking(capID6);
        updateCapacityTableAvailabilityTo1(capID7);
        deleteBooking(capID7);
        updateCapacityTableAvailabilityTo1(capID8);
        deleteBooking(capID8);
        updateCapacityTableAvailabilityTo1(capID9);
        deleteBooking(capID9);
        updateCapacityTableAvailabilityTo1(capID10);
        deleteBooking(capID10);
        updateCapacityTableAvailabilityTo1(capID11);
        deleteBooking(capID11);
    }

    /**
     * Returns void.
     * This method rejects booking 1 and updates database
     *
     * @param actionEvent check box reject 1
     */
    @FXML
    public void onClickReject1(ActionEvent actionEvent) {
        setCapIDs(userID1, date1, hour1);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 2 and updates database
     *
     * @param actionEvent check box reject 2
     */
    @FXML
    public void onClickReject2(ActionEvent actionEvent) {
        setCapIDs(userID2, date2, hour2);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 3 and updates database
     *
     * @param actionEvent check box reject 3
     */
    @FXML
    public void onClickReject3(ActionEvent actionEvent) {
        setCapIDs(userID3, date3, hour3);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 4 and updates database
     *
     * @param actionEvent check box reject 4
     */
    @FXML
    public void onClickReject4(ActionEvent actionEvent) {
        setCapIDs(userID4, date4, hour4);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 5 and updates database
     *
     * @param actionEvent check box reject 5
     */
    @FXML
    public void onClickReject5(ActionEvent actionEvent) {
        setCapIDs(userID5, date5, hour5);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 6 and updates database
     *
     * @param actionEvent check box reject 6
     */
    @FXML
    public void onClickReject6(ActionEvent actionEvent) {
        setCapIDs(userID6, date6, hour6);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 7 and updates database
     *
     * @param actionEvent check box reject 7
     */
    @FXML
    public void onClickReject7(ActionEvent actionEvent) {
        setCapIDs(userID7, date7, hour7);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 8 and updates database
     *
     * @param actionEvent check box reject 8
     */
    @FXML
    public void onClickReject8(ActionEvent actionEvent) {
        setCapIDs(userID8, date8, hour8);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 9 and updates database
     *
     * @param actionEvent check box reject 9
     */
    @FXML
    public void onClickReject9(ActionEvent actionEvent) {
        setCapIDs(userID9, date9, hour9);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 10 and updates database
     *
     * @param actionEvent check box reject 10
     */
    @FXML
    public void onClickReject10(ActionEvent actionEvent) {
        setCapIDs(userID10, date10, hour10);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 11 and updates database
     *
     * @param actionEvent check box reject 11
     */
    @FXML
    public void onClickReject11(ActionEvent actionEvent) {
        setCapIDs(userID11, date11, hour11);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 12 and updates database
     *
     * @param actionEvent check box reject 12
     */
    @FXML
    public void onClickReject12(ActionEvent actionEvent) {
        setCapIDs(userID12, date12, hour12);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 13 and updates database
     *
     * @param actionEvent check box reject 13
     */
    @FXML
    public void onClickReject13(ActionEvent actionEvent) {
        setCapIDs(userID13, date13, hour13);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 14 and updates database
     *
     * @param actionEvent check box reject 14
     */
    @FXML
    public void onClickReject14(ActionEvent actionEvent) {
        setCapIDs(userID14, date14, hour14);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 15 and updates database
     *
     * @param actionEvent check box reject 15
     */
    @FXML
    public void onClickReject15(ActionEvent actionEvent) {
        setCapIDs(userID15, date15, hour15);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 16 and updates database
     *
     * @param actionEvent check box reject 16
     */
    @FXML
    public void onClickReject16(ActionEvent actionEvent) {
        setCapIDs(userID16, date16, hour16);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 17 and updates database
     *
     * @param actionEvent check box reject 17
     */
    @FXML
    public void onClickReject17(ActionEvent actionEvent) {
        setCapIDs(userID17, date17, hour17);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 18 and updates database
     *
     * @param actionEvent check box reject 18
     */
    @FXML
    public void onClickReject18(ActionEvent actionEvent) {
        setCapIDs(userID18, date18, hour18);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 19 and updates database
     *
     * @param actionEvent check box reject 19
     */
    @FXML
    public void onClickReject19(ActionEvent actionEvent) {
        setCapIDs(userID19, date19, hour19);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 20 and updates database
     *
     * @param actionEvent check box reject 20
     */
    @FXML
    public void onClickReject20(ActionEvent actionEvent) {
        setCapIDs(userID20, date20, hour20);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 21 and updates database
     *
     * @param actionEvent check box reject 21
     */
    @FXML
    public void onClickReject21(ActionEvent actionEvent) {
        setCapIDs(userID21, date21, hour21);
        remove();
        refresh();
    }

    /**
     * Returns void.
     * This method rejects booking 22 and updates database
     *
     * @param actionEvent check box reject 22
     */
    @FXML
    public void onClickReject22(ActionEvent actionEvent) {
        setCapIDs(userID22, date22, hour22);
        remove();
        refresh();
    }


    /**
     * Returns void.
     * This method approves booking 1 and updates database
     *
     * @param actionEvent check box approve 1
     */
    @FXML
    public void onClickApprove1(ActionEvent actionEvent) {
        setCapIDs(userID1, date1, hour1);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 2 and updates database
     *
     * @param actionEvent check box approve 2
     */
    @FXML
    public void onClickApprove2(ActionEvent actionEvent) {
        setCapIDs(userID2, date2, hour2);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 3 and updates database
     *
     * @param actionEvent check box approve 3
     */
    @FXML
    public void onClickApprove3(ActionEvent actionEvent) {
        setCapIDs(userID3, date3, hour3);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 4 and updates database
     *
     * @param actionEvent check box approve 4
     */
    public void onClickApprove4(ActionEvent actionEvent) {
        setCapIDs(userID4, date4, hour4);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 5 and updates database
     *
     * @param actionEvent check box approve 5
     */
    @FXML
    public void onClickApprove5(ActionEvent actionEvent) {
        setCapIDs(userID5, date5, hour5);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 6 and updates database
     *
     * @param actionEvent check box approve 6
     */
    @FXML
    public void onClickApprove6(ActionEvent actionEvent) {
        setCapIDs(userID6, date6, hour6);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 7 and updates database
     *
     * @param actionEvent check box approve 7
     */
    @FXML
    public void onClickApprove7(ActionEvent actionEvent) {
        setCapIDs(userID7, date7, hour7);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 8 and updates database
     *
     * @param actionEvent check box approve 8
     */
    @FXML
    public void onClickApprove8(ActionEvent actionEvent) {
        setCapIDs(userID8, date8, hour8);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 9 and updates database
     *
     * @param actionEvent check box approve 9
     */
    @FXML
    public void onClickApprove9(ActionEvent actionEvent) {
        setCapIDs(userID9, date9, hour9);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 10 and updates database
     *
     * @param actionEvent check box approve 10
     */
    @FXML
    public void onClickApprove10(ActionEvent actionEvent) {
        setCapIDs(userID10, date10, hour10);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 11 and updates database
     *
     * @param actionEvent check box approve 11
     */
    @FXML
    public void onClickApprove11(ActionEvent actionEvent) {
        setCapIDs(userID11, date11, hour11);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 12 and updates database
     *
     * @param actionEvent check box approve 12
     */
    @FXML
    public void onClickApprove12(ActionEvent actionEvent) {
        setCapIDs(userID12, date12, hour12);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 13 and updates database
     *
     * @param actionEvent check box approve 13
     */
    @FXML
    public void onClickApprove13(ActionEvent actionEvent) {
        setCapIDs(userID13, date13, hour13);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 14 and updates database
     *
     * @param actionEvent check box approve 14
     */
    @FXML
    public void onClickApprove14(ActionEvent actionEvent) {
        setCapIDs(userID14, date14, hour14);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 15 and updates database
     *
     * @param actionEvent check box approve 15
     */
    @FXML
    public void onClickApprove15(ActionEvent actionEvent) {
        setCapIDs(userID15, date15, hour15);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 16 and updates database
     *
     * @param actionEvent check box approve 16
     */
    @FXML
    public void onClickApprove16(ActionEvent actionEvent) {
        setCapIDs(userID16, date16, hour16);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 17 and updates database
     *
     * @param actionEvent check box approve 17
     */
    @FXML
    public void onClickApprove17(ActionEvent actionEvent) {
        setCapIDs(userID17, date17, hour17);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 18 and updates database
     *
     * @param actionEvent check box approve 18
     */
    @FXML
    public void onClickApprove18(ActionEvent actionEvent) {
        setCapIDs(userID18, date18, hour18);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 19 and updates database
     *
     * @param actionEvent check box approve 19
     */
    @FXML
    public void onClickApprove19(ActionEvent actionEvent) {
        setCapIDs(userID19, date19, hour19);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 20 and updates database
     *
     * @param actionEvent check box approve 20
     */
    @FXML
    public void onClickApprove20(ActionEvent actionEvent) {
        setCapIDs(userID20, date20, hour20);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 21 and updates database
     *
     * @param actionEvent check box approve 21
     */
    @FXML
    public void onClickApprove21(ActionEvent actionEvent) {
        setCapIDs(userID21, date21, hour21);
        approve();
        refresh();
    }

    /**
     * Returns void.
     * This method approves booking 22 and updates database
     *
     * @param actionEvent check box approve 22
     */
    @FXML
    public void onClickApprove22(ActionEvent actionEvent) {
        setCapIDs(userID22, date22, hour22);
        approve();
        refresh();
    }

}