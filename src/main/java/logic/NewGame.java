package logic;

import board.Field;
import board.FieldValue;
import components.Counter;
import components.Images;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.List;
import java.util.Map;

public class NewGame extends KolkoAndKrzyzyk {

    public static void restartGame(List<Rectangle> fields, Map<Integer, Field> rectangleFields) {
        emptyField(fields);
        rectangleFields.forEach((key, value) -> value.setValue(FieldValue.EMPTY));

        Counter.movCounter = 0;
        Counter.playerClicked = false;
        Counter.gameOver = false;
    }

    public static void emptyField(List<Rectangle> fields) {
        for (int i = 0; i < 9; i++) {
            fields.get(i).setFill(new ImagePattern(Images.imgEmpty));
        }
    }
}