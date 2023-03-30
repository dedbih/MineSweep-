package com.example.minesweep;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MSController controller = new MSController();
        controller.startGame(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

