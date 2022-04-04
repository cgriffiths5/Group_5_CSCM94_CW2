package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is used to show an order submitted page
 *
 * @author Cameron Turner
 * @version 1.0
 */

public class WaiterEnterCorrectDetails implements Initializable {

    public Button closeTab;

    /**
     * This method closes the page
     *
     * @param actionEvent Click tab button
     */
    public void onClickCloseTab(ActionEvent actionEvent) {
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * Initializes the page
     *
     * @param url            URL
     * @param resourceBundle resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}