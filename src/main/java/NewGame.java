import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Map;

public class NewGame extends KolkoAndKrzyzyk {
    static void restartGame(Rectangle field1, Rectangle field2, Rectangle field3, Rectangle field4, Rectangle field5,
                            Rectangle field6, Rectangle field7, Rectangle field8, Rectangle field9, Map<Integer, Field> rectangleFields) {
        emptyField(field1, field2, field3, field4, field5, field6, field7, field8, field9);
        rectangleFields.forEach((key, value) -> value.setValue(FieldValue.EMPTY));
        movCounter = 0;
        playerClicked = false;
        gameOver = false;
    }

    static void emptyField(Rectangle field1, Rectangle field2, Rectangle field3, Rectangle field4,
                           Rectangle field5, Rectangle field6, Rectangle field7, Rectangle field8,
                           Rectangle field9) {

        field1.setFill(new ImagePattern(imgEmpty));
        field2.setFill(new ImagePattern(imgEmpty));
        field3.setFill(new ImagePattern(imgEmpty));
        field4.setFill(new ImagePattern(imgEmpty));
        field5.setFill(new ImagePattern(imgEmpty));
        field6.setFill(new ImagePattern(imgEmpty));
        field7.setFill(new ImagePattern(imgEmpty));
        field8.setFill(new ImagePattern(imgEmpty));
        field9.setFill(new ImagePattern(imgEmpty));
    }
}
