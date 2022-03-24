package com.cafe.group5a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GenerateReportsController {

    @FXML
    public Button ManagerHomeReturn;

    @FXML
    public void onManagerHomeReturnClick(ActionEvent event) {
        try {
            Stage stage = (Stage) ManagerHomeReturn.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("manager-view.fxml")));

            stage.setTitle("Manager");
            stage.getScene().setRoot(newRoot);
        } catch (IOException e) {
            System.out.println("Error loading page");
        }
    }
}
