package data;

import board.Field;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import logic.ComputerMove;

import java.util.List;
import java.util.Map;


public class Buttons {

    public static Button createSaveButton(TextField tfPlayer1, TextField tfPlayer2) {
        Button btSave = new Button("SAVE");
        btSave.relocate(682, 170);
        btSave.setStyle("-fx-background-color: #207bdc");
        btSave.setOnAction(event -> WriteLoadScore.writeScore(tfPlayer1, tfPlayer2));
        return btSave;
    }

    public static Button createButtonExit() {
        Button btExit = new Button("EXIT");
        btExit.relocate(682, 275);
        btExit.setStyle("-fx-background-color: #dc3b44");
        btExit.setOnAction(actionEvent -> {
            javafx.stage.Stage stage = (Stage) btExit.getScene().getWindow();
            stage.close();
        });
        return btExit;
    }

    public static Button createNewGameButton(List<Rectangle> fields, Map<Integer, Field> rectangleFields) {
        Button btNewGame = new Button("NEW GAME");
        btNewGame.relocate(602, 275);
        btNewGame.setStyle("-fx-background-color: #2c64dc");

        btNewGame.setOnAction(event -> {
            NewGame.restartGame(fields, rectangleFields);

            ComputerMove.newGameTurn(rectangleFields);
        });
        return btNewGame;
    }

    public static Button createScoreButton() {
        Button btScore = new Button("SCORE");
        btScore.relocate(675, 200);
        btScore.setStyle("-fx-background-color: #207bdc");

        btScore.setOnAction(event -> {
            ScoreWindow.score();
            WriteLoadScore.loadScore();
        });
        return btScore;
    }
}
