package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

public class CustBookingController {
    private String username;
    @FXML
    public ScrollPane mainPane;
    public Label userHolder;
    public Button submitReservationButton;

    @FXML
    public void onSubmitReservationButtonClick(ActionEvent actionEvent) {
    }

    public void setUserText(String user) {
        username = user;
        userHolder.setText(user);
    }
}
