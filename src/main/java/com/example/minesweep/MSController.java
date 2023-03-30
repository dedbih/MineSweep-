package com.example.minesweep;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//Intermediario entre Model y View
public class MSController {
    private MSModel model;
    private MSView view;

    public MSController() {
        this.model = new MSModel();
        this.view = new MSView();
    }

    public void startGame(Stage primaryStage) {
        view.start(primaryStage);
    }

    public void setBomb(GridPane grid) {
        model.setBomb(grid);
    }

    public int getNumBombs(GridPane grid, int x, int y) {
        return model.getNumBombs(grid, x, y);
    }

    public void revealZeros(GridPane grid, int x, int y) {
        model.reveal(grid, x, y);
    }
}

