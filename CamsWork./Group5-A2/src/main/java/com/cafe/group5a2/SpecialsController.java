package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SpecialsController {

    @FXML public Button ChefHomeReturn;

    /**
     *
     * @param event when the return back button is pressed the chef view FXML page is loaded
     */

    @FXML
    public void onChefHomeReturnClick(ActionEvent event) {
        try {
            Stage stage = (Stage) ChefHomeReturn.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chef-view.fxml")));

            stage.setTitle("Chef");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }


}
