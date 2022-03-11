package com.example.cscm94_gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

import java.io.IOException;

public class HelloController {

   @FXML
   public Button custButton;

   @FXML
   public void onCustButtonClick(ActionEvent event) throws IOException {

       Stage stage = (Stage) custButton.getScene().getWindow();
       Parent newRoot = FXMLLoader.load(getClass().getResource("log-in.fxml"));
       stage.setTitle("Customer");
       stage.getScene().setRoot(newRoot);
   }

    @FXML
    public Button quitButton;

    @FXML
    public void onQuitButtonClick(ActionEvent event) {
          Stage stage = (Stage) quitButton.getScene().getWindow();
          stage.close();
    }
}

