package com.example;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setScene(new Scene(View.getScene()));
        //stage.setFullScreen(true);
        stage.setTitle("Table Stuff");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}