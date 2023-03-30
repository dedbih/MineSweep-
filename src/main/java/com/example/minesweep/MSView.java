package com.example.minesweep;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import static com.example.minesweep.MSModel.fire;

public class MSView {

    public GridPane grid1;
    public GridPane grid2;

    public void start(Stage primaryStage) {
        grid1 = createGrid();
        grid2 = createGrid();
        MSModel.setBomb(grid1);
        MSModel.setBomb(grid2);

        VBox container = new VBox(grid1, grid2);
        container.setSpacing(10);
        container.setStyle("-fx-background-color: #FFFF6D");

        Label label1 = new Label("Label 1");
        Label label2 = new Label("Label 2");

        HBox labels = new HBox(label1, label2);
        labels.setAlignment(Pos.CENTER_RIGHT);

        BorderPane root = new BorderPane();
        root.setTop(labels);
        BorderPane.setAlignment(labels, Pos.TOP_RIGHT);

        root.setCenter(container);

        Scene scene = new Scene(root, 600, 600);
        scene.setFill(Color.LIGHTBLUE);
        primaryStage.setTitle("Minesweep!! щ(`Д´щ;)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Button button = new Button();
                button.setPrefSize(50, 50);
                button.setStyle("-fx-background-color: #B7F54B ; -fx-text-fill: white; -fx-font-family: Arial; -fx-font-size: 10;");
                grid.add(button, i, j);

                int numBombs = MSModel.getNumBombs(grid, i, j);
                if (numBombs > 0) {
                    button.setText(String.valueOf(numBombs));
                }

                final int x = i;
                final int y = j;
                button.setOnAction(event -> {
                    if (button.getProperties().containsKey("bomb")) {
                        button.setText("💣");
                        button.setStyle("-fx-background-color: #F84156; -fx-text-fill: white; -fx-font-family: Arial; -fx-font-size: 10;");
                        MSModel.reveal(grid, x, y);
                        fire(grid1,grid2);

                    } else {
                        int numBombsAround = MSModel.getNumBombs(grid, x, y);
                        if (numBombsAround == 0) {
                            MSModel.reveal(grid, x, y);
                            fire(grid1,grid2);
                        } else {
                            button.setText(String.valueOf(numBombsAround));
                            fire(grid1,grid2);
                        }
                        button.setStyle("-fx-background-color: #88CCEE; -fx-text-fill: white; -fx-font-family: Arial; -fx-font-size: 10;");
                    }
                });
            }
        }
        return grid;
    }
    public GridPane getGrid1() {
        return this.grid1;
    }
    public GridPane getGrid2() {
        return this.grid2;
    }
}
