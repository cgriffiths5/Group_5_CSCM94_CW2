package com.cafe.group5a2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * This class starts the application, loading the home page
 */
 

public class Main extends Application {

    /**
     * This method launches the program
     * @param args
     */

    public static void main(String[] args) {
        launch();
    }
    
    /**
     * This method starts the application by loading the home-view FXML page
     * @param stage sets the stage up to be loaded
     * @throws IOException
     */

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
