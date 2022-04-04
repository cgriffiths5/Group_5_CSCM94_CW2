package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

/**
 * @author Adam Tucker
 * This class allows a customer to make a booking by checking availability using the
 * capacity table and bookings table and users table
 */

public class CustBookingController {


    private final String T_RED = "#860000";
    private final String GREEN = "#25ff37";
    private final String H_RED = "#ff0000";
    public Button Refresh;
    @FXML
    public TextField Guests;
    public Label T11;
    public Label T10;
    public Label T9;
    public Label T8;
    public Label T7;
    public Label T6;
    public Label T5;
    public Label T4;
    public Label T3;
    public Label T2;
    public Label T1;
    public CheckBox T11Select;
    public CheckBox T10Select;
    public CheckBox T9Select;
    public CheckBox T8Select;
    public CheckBox T7Select;
    public CheckBox T6Select;
    public CheckBox T5Select;
    public CheckBox T4Select;
    public CheckBox T3Select;
    public CheckBox T2Select;
    public CheckBox T1Select;
    public Label h22;
    public Label h21;
    public Label h20;
    public Label h19;
    public Label h18;
    public Label h17;
    public Label h16;
    public Label h15;
    public Label h14;
    public Label h13;
    public Label h12;
    public javafx.scene.control.DatePicker DatePicker;
    public Label NotEnoughTables;
    public Label SubmitMsg;
    public ScrollPane mainPane;
    public Label userHolder;
    public Button submitReservationButton;
    public Button goBack;
    public ProgressBar progBar;
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cafedb?user=root&password=");
    private String username;
    private int userID;
    private Date date;
    private int chosenHour;
    private int seatsTotal = 0;
    private int guestNum;
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

    /**
     * @throws SQLException default constructor to avoid JDBC connection error
     */
    public CustBookingController() throws SQLException {
    }

    /**
     * @param user allows transfer of the username which is always unique in the database
     *             we can use this for queries
     */
    public void setUserText(String user) {
        username = user;
        userHolder.setText(user);
        getUserID();
    }

    /**
     * use the username to get the user_ID from the database
     * this works because username is a unique field in the database
     */
    public void getUserID() {
        String query = "SELECT user_ID FROM users WHERE username = '" + username + "'";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                userID = parseInt(rs.getString("user_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            userID = -1;
        }
    }

    /**
     * we need to get all the ID's in the capacity table where the hour and date are the same
     * there will be max 11 because there are 11 tables in the restaurant
     */
    private void getCapIDs() {

        String query =
                "SELECT cap_ID FROM capacity where hour = '" + chosenHour + "' AND date = '" + date + "'";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int i = 1;
            capID1 = 0;
            capID2 = 0;
            capID3 = 0;
            capID4 = 0;
            capID5 = 0;
            capID6 = 0;
            capID7 = 0;
            capID8 = 0;
            capID9 = 0;
            capID10 = 0;
            capID11 = 0;
            while (rs.next()) {
                if (T1Select.isSelected() && i == 1) capID1 = parseInt(rs.getString("cap_ID"));
                if (T2Select.isSelected() && i == 2) capID2 = parseInt(rs.getString("cap_ID"));
                if (T3Select.isSelected() && i == 3) capID3 = parseInt(rs.getString("cap_ID"));
                if (T4Select.isSelected() && i == 4) capID4 = parseInt(rs.getString("cap_ID"));
                if (T5Select.isSelected() && i == 5) capID5 = parseInt(rs.getString("cap_ID"));
                if (T6Select.isSelected() && i == 6) capID6 = parseInt(rs.getString("cap_ID"));
                if (T7Select.isSelected() && i == 7) capID7 = parseInt(rs.getString("cap_ID"));
                if (T8Select.isSelected() && i == 8) capID8 = parseInt(rs.getString("cap_ID"));
                if (T9Select.isSelected() && i == 9) capID9 = parseInt(rs.getString("cap_ID"));
                if (T10Select.isSelected() && i == 10) capID10 = parseInt(rs.getString("cap_ID"));
                if (T11Select.isSelected() && i == 11) capID11 = parseInt(rs.getString("cap_ID"));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param e ScheduledExecutorService that allows me to show elements on the GUI that
     *          make the user wait for a period of time to stop them submitting forms
     *          rapidly, I then shutdown the thread and hide the elements after that time
     */
    private void myTask(ScheduledExecutorService e) {
        SubmitMsg.setText("ORDER SUBMITTED");
        progBar.setOpacity(0);
        submitReservationButton.setDisable(false);
        SubmitMsg.setOpacity(1);
        e.shutdown();
    }

    /**
     * to submit a booking we need all the tables that booking will use
     * that means finding the capacity ID corresponding to each of the tables
     * so, I get the capIDs and put them in an ArrayList
     * I also want to stop the customer from rapid spamming the submit button, so I disable it
     * Then I remove all null capID's
     * What I'm left with is an arraylist of all the capIDs I need to set to not available
     * so other customers can't book those tables for that hour for that date
     * then I just do a for loop where I set the right rows in the database
     * I set is_available to 0 so other customers can't book it
     * I insert a new booking into the bookings table
     * I call the ScheduledExecutorService to show the progress bar
     * after a period of time I hide the bar and show the message "BOOKING SUBMITTED" or something
     * and stop the user from spamming the submit button
     *
     * @param actionEvent autogen from scene builder
     */
    @FXML
    public void onSubmitReservationButtonClick(ActionEvent actionEvent) {
        progBar.setOpacity(1);
        submitReservationButton.setDisable(true);
        getUserID();
        getCapIDs();
        ArrayList<Integer> capIDList = new ArrayList<>();
        if (capID1 > 0) capIDList.add(capID1);
        if (capID2 > 0) capIDList.add(capID2);
        if (capID3 > 0) capIDList.add(capID3);
        if (capID4 > 0) capIDList.add(capID4);
        if (capID5 > 0) capIDList.add(capID5);
        if (capID6 > 0) capIDList.add(capID6);
        if (capID7 > 0) capIDList.add(capID7);
        if (capID8 > 0) capIDList.add(capID8);
        if (capID9 > 0) capIDList.add(capID9);
        if (capID10 > 0) capIDList.add(capID10);
        if (capID11 > 0) capIDList.add(capID11);
        capIDList.removeIf(Objects::isNull);
        boolean submitted = false;
        for (Integer integer : capIDList) {
            getUserID();
            String query =
                    "INSERT INTO bookings (b_user_ID, b_cap_ID, guests) " +
                            "VALUES (" + userID + "," + integer + "," + guestNum + ")";
            String q2 =
                    "UPDATE capacity SET is_available = 0 WHERE cap_ID = '" + integer + "'";
            try (Statement stmt = con.createStatement()) {
                stmt.executeQuery(query);
                stmt.executeQuery(q2);
                submitted = true;
            } catch (SQLException e) {
                e.printStackTrace();
                submitted = false;
            }
        }

        if (submitted) {
            final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(() ->
                    myTask(executorService), 3, 2, TimeUnit.SECONDS);
        } else {
            progBar.setOpacity(0.0);
            SubmitMsg.setText("Error, reload and try another booking");
            SubmitMsg.setOpacity(1.0);
        }
    }


    /**
     * when the user clicks the go back button, they go back to the customer menu
     * which for them is the "Main menu"
     *
     * @param actionEvent scene builder autogen
     * @throws IOException handles fxml issues with loading the page
     */
    @FXML
    public void onClickGoBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goBack.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull
                (getClass().getResource("customer-view.fxml")));
        stage.setTitle("Main Menu");
        stage.setHeight(550.0);
        stage.setMaxHeight(550.0);
        stage.setWidth(550.0);
        stage.setMaxWidth(550.0);
        stage.centerOnScreen();
        stage.getScene().setRoot(newRoot);
    }

    /**
     * @param mouseEvent scene builder autogen not used
     * @author Adam Tucker
     * when the user clicks the green hour box with the text
     * "22:00" check what tables are available and set them to green
     */
    @FXML
    public void onh22Click(MouseEvent mouseEvent) {
        checkTables(date, 2200);
        chosenHour = 2200;
    }

    @FXML
    public void onh21Click(MouseEvent mouseEvent) {
        checkTables(date, 2100);
        chosenHour = 2100;
    }

    @FXML
    public void onh20Click(MouseEvent mouseEvent) {
        checkTables(date, 2000);
        chosenHour = 2000;
    }

    @FXML
    public void onh19Click(MouseEvent mouseEvent) {
        checkTables(date, 1900);
        chosenHour = 1900;
    }

    @FXML
    public void onh18Click(MouseEvent mouseEvent) {
        checkTables(date, 1800);
        chosenHour = 1800;
    }

    @FXML
    public void onh17Click(MouseEvent mouseEvent) {
        checkTables(date, 1700);
        chosenHour = 1700;
    }

    @FXML
    public void onh16Click(MouseEvent mouseEvent) {
        checkTables(date, 1600);
        chosenHour = 1600;
    }

    @FXML
    public void onh15Click(MouseEvent mouseEvent) {
        checkTables(date, 1500);
        chosenHour = 1500;
    }

    @FXML
    public void onh14Click(MouseEvent mouseEvent) {
        checkTables(date, 1400);
        chosenHour = 1400;
    }

    @FXML
    public void onh13Click(MouseEvent mouseEvent) {
        checkTables(date, 1300);
        chosenHour = 1300;
    }

    @FXML
    public void onh12Click(MouseEvent mouseEvent) {
        checkTables(date, 1200);
        chosenHour = 1200;
    }

    /**
     * When a user chooses a date they want to make a booking for,
     * I need to change the date to the sql date format
     * then I need to make sure the date is after today's date,
     * so they can't make bookings in the past
     * If they chose a valid date then,
     * check each hour for that date to see if there are enough tables,
     * available for the number of guests input,
     * If there is, set that hour label to green and make it clickable,
     * If not, set it to red and make it unclickable
     *
     * @param actionEvent scene builder autogen ignored
     */
    @FXML
    public void onDateChosenUpdateHours(ActionEvent actionEvent) {

        int guests = 0;
        guestNum = 0;
        seatsTotal = 0;
        T1Select.setSelected(false);
        T2Select.setSelected(false);
        T3Select.setSelected(false);
        T4Select.setSelected(false);
        T5Select.setSelected(false);
        T6Select.setSelected(false);
        T7Select.setSelected(false);
        T8Select.setSelected(false);
        T9Select.setSelected(false);
        T10Select.setSelected(false);
        T11Select.setSelected(false);
        if (!Guests.getText().isEmpty()) {
            guests = parseInt(Guests.getText());
            guestNum = guests;
        }
        LocalDate localDate = DatePicker.getValue();
        LocalDate currentDate = LocalDate.now();
        if (localDate.compareTo(currentDate) < 1) {
            NotEnoughTables.setText("Choose a date after today's date!");
            NotEnoughTables.setOpacity(1);
            submitReservationButton.setDisable(true);
        } else {
            NotEnoughTables.setOpacity(0);
            date = Date.valueOf(localDate);
            if (guests > 0 && checkHour(date, 1200, guests)) {
                h12.setTextFill(Color.web(GREEN, 1.0));
                h12.setDisable(false);
            } else {
                h12.setTextFill(Color.web(H_RED, 1.0));
                h12.setDisable(true);
            }
            if (guests > 0 && checkHour(date, 1300, guests)) {
                h13.setTextFill(Color.web(GREEN, 1.0));
                h13.setDisable(false);
            } else {
                h13.setTextFill(Color.web(H_RED, 1.0));
                h13.setDisable(true);
            }
            if (guests > 0 && checkHour(date, 1400, guests)) {
                h14.setTextFill(Color.web(GREEN, 1.0));
                h14.setDisable(false);
            } else {
                h14.setTextFill(Color.web(H_RED, 1.0));
                h14.setDisable(true);
            }
            if (guests > 0 && checkHour(date, 1500, guests)) {
                h15.setTextFill(Color.web(GREEN, 1.0));
                h15.setDisable(false);
            } else {
                h15.setTextFill(Color.web(H_RED, 1.0));
                h15.setDisable(true);
            }
            if (guests > 0 && checkHour(date, 1600, guests)) {
                h16.setTextFill(Color.web(GREEN, 1.0));
                h16.setDisable(false);
            } else {
                h16.setTextFill(Color.web(H_RED, 1.0));
                h16.setDisable(true);
            }
            if (guests > 0 && checkHour(date, 1700, guests)) {
                h17.setTextFill(Color.web(GREEN, 1.0));
                h17.setDisable(false);
            } else {
                h17.setTextFill(Color.web(H_RED, 1.0));
                h17.setDisable(true);
            }
            if (guests > 0 && checkHour(date, 1800, guests)) {
                h18.setTextFill(Color.web(GREEN, 1.0));
                h18.setDisable(false);
            } else {
                h18.setTextFill(Color.web(H_RED, 1.0));
                h18.setDisable(true);
            }
            if (guests > 0 && checkHour(date, 1900, guests)) {
                h19.setTextFill(Color.web(GREEN, 1.0));
                h19.setDisable(false);
            } else {
                h19.setTextFill(Color.web(H_RED, 1.0));
                h19.setDisable(true);
            }
            if (guests > 0 && checkHour(date, 2000, guests)) {
                h20.setTextFill(Color.web(GREEN, 1.0));
                h20.setDisable(false);
            } else {
                h20.setTextFill(Color.web(H_RED, 1.0));
                h20.setDisable(true);
            }
            if (guests > 0 && checkHour(date, 2100, guests)) {
                h21.setTextFill(Color.web(GREEN, 1.0));
                h21.setDisable(false);
            } else {
                h21.setTextFill(Color.web(H_RED, 1.0));
                h21.setDisable(true);
            }
            if (guests > 0 && checkHour(date, 2200, guests)) {
                h22.setTextFill(Color.web(GREEN, 1.0));
                h22.setDisable(false);
            } else {
                h22.setTextFill(Color.web(H_RED, 1.0));
                h22.setDisable(true);
            }

        }
    }

    /**
     * @param date   from date picker chosen by user for a booking
     * @param hour   hour chosen by clicking the green hour label which indicates there is enough
     *               availability for the number of guests input
     * @param guests the number of guests input into the guests text box
     * @return returns true if the hour, date are available for the number of guests
     * i.e. there are enough tables to seat everyone
     */
    public boolean checkHour(Date date, int hour, int guests) {
        String query =
                "SELECT * FROM capacity WHERE is_available = 1 AND (hour = '" + hour + "' AND ((hour >= (HOUR(CURRENT_TIME) * 100)) + 2000)) AND date = '" + date + "'";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int sumSeats = 0;
            while (rs.next()) {
                sumSeats += parseInt(rs.getString("seats"));
                if (sumSeats >= guests) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * I need to check each table (1,2,3,4,5,6,7,8,9,10,11)
     * to see that it is not booked,
     * If it isn't book make it selectable, and indicate this by making the label green
     *
     * @param date from date picker chosen by user for a booking
     * @param hour hour chosen by clicking the green hour label which indicates there is enough
     *             availability for the number of guests input
     */
    public void checkTables(Date date, int hour) {
        resetVals();
        String query =
                "SELECT * FROM capacity WHERE hour = '" + hour + "' AND date = '" + date + "' ORDER BY table_number";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int tableCounter = 1;
            while (rs.next()) {
                int available = parseInt(rs.getString("is_available"));
                if (available > 0 && tableCounter == 1 && (guestNum < 3 || guestNum > 40)) {
                    T1.setTextFill(Color.web(GREEN, 1.0));
                    T1Select.setDisable(false);
                } else if (tableCounter == 1) {
                    T1.setTextFill(Color.web(T_RED, 1.0));
                    T1Select.setDisable(true);
                }
                if (available > 0 && tableCounter == 2 && (guestNum < 3 || guestNum > 40)) {
                    T2.setTextFill(Color.web(GREEN, 1.0));
                    T2Select.setDisable(false);
                } else if (tableCounter == 2) {
                    T2.setTextFill(Color.web(T_RED, 1.0));
                    T2Select.setDisable(true);
                }
                if (available > 0 && tableCounter == 3 && (guestNum < 3 || guestNum > 40)) {
                    T3.setTextFill(Color.web(GREEN, 1.0));
                    T3Select.setDisable(false);
                } else if (tableCounter == 3) {
                    T3.setTextFill(Color.web(T_RED, 1.0));
                    T3Select.setDisable(true);
                }
                if (available > 0 && tableCounter == 4 && (guestNum < 3 || guestNum > 40)) {
                    T4.setTextFill(Color.web(GREEN, 1.0));
                    T4Select.setDisable(false);
                } else if (tableCounter == 4) {
                    T4.setTextFill(Color.web(T_RED, 1.0));
                    T4Select.setDisable(true);
                }
                if (available > 0 && tableCounter == 5 && guestNum > 2) {
                    T5.setTextFill(Color.web(GREEN, 1.0));
                    T5Select.setDisable(false);
                } else if (tableCounter == 5) {
                    T5.setTextFill(Color.web(T_RED, 1.0));
                    T5Select.setDisable(true);
                }
                if (available > 0 && tableCounter == 6 && guestNum > 2) {
                    T6.setTextFill(Color.web(GREEN, 1.0));
                    T6Select.setDisable(false);
                } else if (tableCounter == 6) {
                    T6.setTextFill(Color.web(T_RED, 1.0));
                    T6Select.setDisable(true);
                }
                if (available > 0 && tableCounter == 7 && guestNum > 2) {
                    T7.setTextFill(Color.web(GREEN, 1.0));
                    T7Select.setDisable(false);
                } else if (tableCounter == 7) {
                    T7.setTextFill(Color.web(T_RED, 1.0));
                    T7Select.setDisable(true);
                }
                if (available > 0 && tableCounter == 8 && guestNum > 2) {
                    T8.setTextFill(Color.web(GREEN, 1.0));
                    T8Select.setDisable(false);
                } else if (tableCounter == 8) {
                    T8.setTextFill(Color.web(T_RED, 1.0));
                    T8Select.setDisable(true);
                }
                if (available > 0 && tableCounter == 9 && guestNum > 4) {
                    T9.setTextFill(Color.web(GREEN, 1.0));
                    T9Select.setDisable(false);
                } else if (tableCounter == 9) {
                    T9.setTextFill(Color.web(T_RED, 1.0));
                    T9Select.setDisable(true);
                }
                if (available > 0 && tableCounter == 10 && guestNum > 4) {
                    T10.setTextFill(Color.web(GREEN, 1.0));
                    T10Select.setDisable(false);
                } else if (tableCounter == 10) {
                    T10.setTextFill(Color.web(T_RED, 1.0));
                    T10Select.setDisable(true);
                }
                if (available > 0 && tableCounter == 11 && guestNum > 8) {
                    T11.setTextFill(Color.web(GREEN, 1.0));
                    T11Select.setDisable(false);
                } else if (tableCounter == 11) {
                    T11.setTextFill(Color.web(T_RED, 1.0));
                    T11Select.setDisable(true);
                }
                tableCounter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * once enough seats have been chosen by selecting tables,
     * make the other tables unselectable, so they can't book extra tables
     */
    public void disableUnselectedSelBoxes() {
        if (!T1Select.isSelected() && seatsTotal >= guestNum) T1Select.setDisable(true);
        if (!T2Select.isSelected() && seatsTotal >= guestNum) T2Select.setDisable(true);
        if (!T3Select.isSelected() && seatsTotal >= guestNum) T3Select.setDisable(true);
        if (!T4Select.isSelected() && seatsTotal >= guestNum) T4Select.setDisable(true);
        if (!T5Select.isSelected() && seatsTotal >= guestNum) T5Select.setDisable(true);
        if (!T6Select.isSelected() && seatsTotal >= guestNum) T6Select.setDisable(true);
        if (!T7Select.isSelected() && seatsTotal >= guestNum) T7Select.setDisable(true);
        if (!T8Select.isSelected() && seatsTotal >= guestNum) T8Select.setDisable(true);
        if (!T9Select.isSelected() && seatsTotal >= guestNum) T9Select.setDisable(true);
        if (!T10Select.isSelected() && seatsTotal >= guestNum) T10Select.setDisable(true);
        if (!T11Select.isSelected() && seatsTotal >= guestNum) T11Select.setDisable(true);
    }

    /**
     * enables the boxes when called
     */
    public void enableBoxes() {
        T1Select.setDisable(false);
        T2Select.setDisable(false);
        T3Select.setDisable(false);
        T4Select.setDisable(false);
        T5Select.setDisable(false);
        T6Select.setDisable(false);
        T7Select.setDisable(false);
        T8Select.setDisable(false);
        T9Select.setDisable(false);
        T10Select.setDisable(false);
        T11Select.setDisable(false);
    }

    /**
     * Table is selected with capacity being checked
     *
     * @param actionEvent ignored scene builder param
     */
    @FXML
    public void onT11Select(ActionEvent actionEvent) {
        if (T11Select.isSelected()) seatsTotal += 10;
        else {
            seatsTotal -= 10;
            if (seatsTotal < guestNum) enableBoxes();
        }
        if (seatsTotal >= guestNum) {
            submitReservationButton.setDisable(false);
            NotEnoughTables.setOpacity(0);
        } else {
            NotEnoughTables.setText("Not enough tables selected! You have " + (guestNum - seatsTotal) + " guests with no seat!");
            NotEnoughTables.setOpacity(1);
            submitReservationButton.setDisable(true);
        }
        disableUnselectedSelBoxes();
    }

    /**
     * Table is selected with capacity being checked
     *
     * @param actionEvent ignored scene builder param
     */
    @FXML
    public void onT10Select(ActionEvent actionEvent) {
        if (T10Select.isSelected()) seatsTotal += 8;
        else {
            seatsTotal -= 8;
            if (seatsTotal < guestNum) enableBoxes();
        }
        if (seatsTotal >= guestNum) {
            submitReservationButton.setDisable(false);
            NotEnoughTables.setOpacity(0);
        } else {
            NotEnoughTables.setText("Not enough tables selected! You have " + (guestNum - seatsTotal) + " guests with no seat!");
            NotEnoughTables.setOpacity(1);
            submitReservationButton.setDisable(true);
        }
        disableUnselectedSelBoxes();
    }

    /**
     * Table is selected with capacity being checked
     *
     * @param actionEvent ignored scene builder param
     */
    @FXML
    public void onT9Select(ActionEvent actionEvent) {
        if (T9Select.isSelected()) seatsTotal += 8;
        else {
            seatsTotal -= 8;
            if (seatsTotal < guestNum) enableBoxes();
        }
        if (seatsTotal >= guestNum) {
            submitReservationButton.setDisable(false);
            NotEnoughTables.setOpacity(0);
        } else {
            NotEnoughTables.setText("Not enough tables selected! You have " + (guestNum - seatsTotal) + " guests with no seat!");
            NotEnoughTables.setOpacity(1);
            submitReservationButton.setDisable(true);
        }
        disableUnselectedSelBoxes();
    }

    /**
     * Table is selected with capacity being checked
     *
     * @param actionEvent ignored scene builder param
     */
    @FXML
    public void onT8Select(ActionEvent actionEvent) {
        if (T8Select.isSelected()) seatsTotal += 4;
        else {
            seatsTotal -= 4;
            if (seatsTotal < guestNum) enableBoxes();
        }
        if (seatsTotal >= guestNum) {
            submitReservationButton.setDisable(false);
            NotEnoughTables.setOpacity(0);
        } else {
            NotEnoughTables.setText("Not enough tables selected! You have " + (guestNum - seatsTotal) + " guests with no seat!");
            NotEnoughTables.setOpacity(1);
            submitReservationButton.setDisable(true);
        }
        disableUnselectedSelBoxes();
    }

    /**
     * Table is selected with capacity being checked
     *
     * @param actionEvent ignored scene builder param
     */
    @FXML
    public void onT7Select(ActionEvent actionEvent) {
        if (T7Select.isSelected()) seatsTotal += 4;
        else {
            seatsTotal -= 4;
            if (seatsTotal < guestNum) enableBoxes();
        }
        if (seatsTotal >= guestNum) {
            submitReservationButton.setDisable(false);
            NotEnoughTables.setOpacity(0);
        } else {
            NotEnoughTables.setText("Not enough tables selected! You have " + (guestNum - seatsTotal) + " guests with no seat!");
            NotEnoughTables.setOpacity(1);
            submitReservationButton.setDisable(true);
        }
        disableUnselectedSelBoxes();
    }

    /**
     * Table is selected with capacity being checked
     *
     * @param actionEvent ignored scene builder param
     */
    @FXML
    public void onT6Select(ActionEvent actionEvent) {
        if (T6Select.isSelected()) seatsTotal += 4;
        else {
            seatsTotal -= 4;
            if (seatsTotal < guestNum) enableBoxes();
        }
        if (seatsTotal >= guestNum) {
            submitReservationButton.setDisable(false);
            NotEnoughTables.setOpacity(0);
        } else {
            NotEnoughTables.setText("Not enough tables selected! You have " + (guestNum - seatsTotal) + " guests with no seat!");
            NotEnoughTables.setOpacity(1);
            submitReservationButton.setDisable(true);
        }
        disableUnselectedSelBoxes();
    }

    /**
     * Table is selected with capacity being checked
     *
     * @param actionEvent ignored scene builder param
     */
    @FXML
    public void onT5Select(ActionEvent actionEvent) {
        if (T5Select.isSelected()) seatsTotal += 4;
        else {
            seatsTotal -= 4;
            if (seatsTotal < guestNum) enableBoxes();
        }
        if (seatsTotal >= guestNum) {
            submitReservationButton.setDisable(false);
            NotEnoughTables.setOpacity(0);
        } else {
            NotEnoughTables.setText("Not enough tables selected! You have " + (guestNum - seatsTotal) + " guests with no seat!");
            NotEnoughTables.setOpacity(1);
            submitReservationButton.setDisable(true);
        }
        disableUnselectedSelBoxes();
    }

    /**
     * Table is selected with capacity being checked
     *
     * @param actionEvent ignored scene builder param
     */
    @FXML
    public void onT4Select(ActionEvent actionEvent) {
        if (T4Select.isSelected()) seatsTotal += 2;
        else {
            seatsTotal -= 2;
            if (seatsTotal < guestNum) enableBoxes();
        }
        if (seatsTotal >= guestNum) {
            submitReservationButton.setDisable(false);
            NotEnoughTables.setOpacity(0);
        } else {
            NotEnoughTables.setText("Not enough tables selected! You have " + (guestNum - seatsTotal) + " guests with no seat!");
            NotEnoughTables.setOpacity(1);
            submitReservationButton.setDisable(true);
        }
        disableUnselectedSelBoxes();
    }

    /**
     * Table is selected with capacity being checked
     *
     * @param actionEvent ignored scene builder param
     */
    @FXML
    public void onT3Select(ActionEvent actionEvent) {
        if (T3Select.isSelected()) seatsTotal += 2;
        else {
            seatsTotal -= 2;
            if (seatsTotal < guestNum) enableBoxes();
        }
        if (seatsTotal >= guestNum) {
            submitReservationButton.setDisable(false);
            NotEnoughTables.setOpacity(0);
        } else {
            NotEnoughTables.setText("Not enough tables selected! You have " + (guestNum - seatsTotal) + " guests with no seat!");
            NotEnoughTables.setOpacity(1);
            submitReservationButton.setDisable(true);
        }
        disableUnselectedSelBoxes();
    }

    /**
     * Table is selected with capacity being checked
     *
     * @param actionEvent ignored scene builder param
     */
    @FXML
    public void onT2Select(ActionEvent actionEvent) {
        if (T2Select.isSelected()) seatsTotal += 2;
        else {
            seatsTotal -= 2;
            if (seatsTotal < guestNum) enableBoxes();
        }
        if (seatsTotal >= guestNum) {
            submitReservationButton.setDisable(false);
            NotEnoughTables.setOpacity(0);
        } else {
            NotEnoughTables.setText("Not enough tables selected! You have " + (guestNum - seatsTotal) + " guests with no seat!");
            NotEnoughTables.setOpacity(1);
            submitReservationButton.setDisable(true);
        }
        disableUnselectedSelBoxes();
    }

    /**
     * Table is selected with capacity being checked
     *
     * @param actionEvent ignored scene builder param
     */
    @FXML
    public void onT1Select(ActionEvent actionEvent) {
        if (T1Select.isSelected()) seatsTotal += 2;
        else {
            seatsTotal -= 2;
            if (seatsTotal < guestNum) enableBoxes();
        }
        if (seatsTotal >= guestNum) {
            submitReservationButton.setDisable(false);
            NotEnoughTables.setOpacity(0);
        } else {
            NotEnoughTables.setText("Not enough tables selected! You have " + (guestNum - seatsTotal) + " guests with no seat!");
            NotEnoughTables.setOpacity(1);
            submitReservationButton.setDisable(true);
        }
        disableUnselectedSelBoxes();
    }

    /**
     * Values are reset on mouse click
     *
     * @param mouseEvent is triggered when date is clicked to update page availability using new date
     */
    @FXML
    public void onDateClick(MouseEvent mouseEvent) {
        resetVals();
    }

    /**
     * Values are reset when this method is triggered
     */
    public void resetVals() {
        seatsTotal = 0;
        guestNum = 0;
        if (!Guests.getText().isEmpty()) {
            guestNum = parseInt(Guests.getText());
        }
        T1Select.setSelected(false);
        T2Select.setSelected(false);
        T3Select.setSelected(false);
        T4Select.setSelected(false);
        T5Select.setSelected(false);
        T6Select.setSelected(false);
        T7Select.setSelected(false);
        T8Select.setSelected(false);
        T9Select.setSelected(false);
        T10Select.setSelected(false);
        T11Select.setSelected(false);
    }

    /**
     * Values are reset on mouseEvent
     *
     * @param mouseEvent when the guest value is changed, update the page using new guest value
     */
    @FXML
    public void onGuestClick(MouseEvent mouseEvent) {
        resetVals();
    }

    /**
     * Values are reset on key release
     *
     * @param keyEvent when any key other than escape is pressed, update the screen using the new guest value
     */
    @FXML
    public void onGuestKeyRelease(KeyEvent keyEvent) {
        if (keyEvent.getCode() != KeyCode.ESCAPE) {
            resetVals();
        }
    }

    /**
     * This refreshes the customer booking page
     */
    @FXML
    public void onClickRefresh() {
        try {
            Stage stage = (Stage) Refresh.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customer-booking.fxml"));
            Parent newRoot = loader.load();

            CustBookingController cBCont = loader.getController();
            cBCont.setUserText(username);

            stage.setTitle("Booking Page");
            stage.setHeight(1000.0);
            stage.setMaxHeight(1113.0);
            stage.setWidth(658.0);
            stage.setMaxWidth(658.0);
            stage.centerOnScreen();
            stage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
