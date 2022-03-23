package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class ChefController {

    @FXML
    public Button homeButton;

    @FXML
    public void onHomeButtonClick(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
