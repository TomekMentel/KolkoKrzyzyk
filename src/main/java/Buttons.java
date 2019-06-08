import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Map;

public class Buttons {

    public static Button createSaveButton(TextField tfPlayer1, TextField tfPlayer2) {
        Button btSave = new Button("SAVE");
        btSave.relocate(682, 170);
        btSave.setStyle("-fx-background-color: #207bdc");
        btSave.setOnAction(event -> {

            try {
                KolkoAndKrzyzyk.writeScore(tfPlayer1, tfPlayer2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return btSave;
    }

    public static Button createButtonExit() {
        Button btExit = new Button("EXIT");
        btExit.relocate(682, 275);
        btExit.setStyle("-fx-background-color: #dc3b44");
        btExit.setOnAction(actionEvent -> Platform.exit());
        return btExit;
    }

    public static Button createNewGameButton(Rectangle field1, Rectangle field2, Rectangle field3, Rectangle field4, Rectangle field5, Rectangle field6, Rectangle field7, Rectangle field8, Rectangle field9, Map<Integer, Field> rectangleFields) {
        Button btNewGame = new Button("NEW GAME");
        btNewGame.relocate(602, 275);
        btNewGame.setStyle("-fx-background-color: #2c64dc");

        btNewGame.setOnAction(event -> {
            KolkoAndKrzyzyk.restartGame(field1, field2, field3, field4,
                    field5, field6, field7, field8, field9, rectangleFields);

            ComputerMove.newGameTurn(rectangleFields);

        });
        return btNewGame;
    }
    public static Button createScoreButton() {
        Button btScore = new Button("SCORE");
        btScore.relocate(675, 200);
        btScore.setStyle("-fx-background-color: #207bdc");

        btScore.setOnAction(event -> {
        });
        return btScore;
    }
}
