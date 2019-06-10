import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Map;

public class PlayerMove extends KolkoAndKrzyzyk {

    public static void addMouseReleased(Rectangle fieldWho, Map<Integer, Field> rectangleFields) {

        addMouseReleased(1, fieldWho, rectangleFields);
        addMouseReleased(2, fieldWho, rectangleFields);
        addMouseReleased(3, fieldWho, rectangleFields);
        addMouseReleased(4, fieldWho, rectangleFields);
        addMouseReleased(5, fieldWho, rectangleFields);
        addMouseReleased(6, fieldWho, rectangleFields);
        addMouseReleased(7, fieldWho, rectangleFields);
        addMouseReleased(8, fieldWho, rectangleFields);
        addMouseReleased(9, fieldWho, rectangleFields);
    }

    private static void addMouseReleased(Integer fieldId, Rectangle fieldWho, Map<Integer, Field> rectangleFields) {

        Field field = rectangleFields.get(fieldId);
        field.getRectangle().setOnMouseReleased(event -> {
            if (field.getValue() == FieldValue.EMPTY && !gameOver) {

                if (turnO) {
                    field.getRectangle().setFill(new ImagePattern(imgO));
                    field.setValue(FieldValue.CIRCLE);

                    movCounter++;
                    turnO = false;
                    fieldWho.setFill(new ImagePattern(imgxsmall));

                } else {
                    field.getRectangle().setFill(new ImagePattern(imgX));
                    field.setValue(FieldValue.CROSS);

                    movCounter++;
                    turnO = true;
                    fieldWho.setFill(new ImagePattern(imgOsmall));

                }

                if (CheckWinner.check(rectangleFields)) {
                    return;
                }
                if (Alerts.noWinner()) {
                    return;
                }
                if (playerClicked == false) {
                    ComputerMove.computerTurn(rectangleFields, fieldWho);

                }
            }
        });
    }
}
