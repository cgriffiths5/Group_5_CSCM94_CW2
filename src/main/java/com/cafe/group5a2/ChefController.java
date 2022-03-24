package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ChefController {

    @FXML
    public Button homeButton;
    public Label userLabel;
    public Button viewSpecials;
    public Button viewOutstandingOrders;
    public Label Title;

    @FXML
    public void onHomeButtonClick(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}