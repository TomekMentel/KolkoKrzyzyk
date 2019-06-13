package data;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.List;
import java.util.Map;

public class NewGame extends KolkoAndKrzyzyk {

    static void restartGame(List<Rectangle> fields, Map<Integer, Field> rectangleFields) {
        emptyField(fields);
        rectangleFields.forEach((key, value) -> value.setValue(FieldValue.EMPTY));

        movCounter = 0;
        playerClicked = false;
        gameOver = false;
    }

    static void emptyField(List<Rectangle> fields) {
        for (int i = 0; i < 9; i++) {
            fields.get(i).setFill(new ImagePattern(imgEmpty));
        }
    }
}