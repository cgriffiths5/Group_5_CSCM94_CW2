package com.cafe.group5a2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        //setUserAgentStylesheet(STYLESHEET_MODENA);



        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home-view.fxml")));
        stage.setTitle("Cafe 94");

        stage.setScene(new Scene(root, 484, 523));
        //stage.setScene(scene);
        stage.show();

    }
}