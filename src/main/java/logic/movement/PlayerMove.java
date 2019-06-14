package logic.movement;

import board.Field;
import board.FieldValue;
import components.Counter;
import components.Images;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import logic.CheckWinner;
import logic.menu.Alerts;

import java.util.Map;

public class PlayerMove {

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
            if (field.getValue() == FieldValue.EMPTY && !Counter.gameOver) {

                if (Counter.turnO) {
                    field.getRectangle().setFill(new ImagePattern(Images.imgO));
                    field.setValue(FieldValue.CIRCLE);

                    Counter.movCounter++;
                    Counter.turnO = false;
                    fieldWho.setFill(new ImagePattern(Images.imgxsmall));

                } else {
                    field.getRectangle().setFill(new ImagePattern(Images.imgX));
                    field.setValue(FieldValue.CROSS);

                    Counter.movCounter++;
                    Counter.turnO = true;
                    fieldWho.setFill(new ImagePattern(Images.imgOsmall));
                }
                if (CheckWinner.check(rectangleFields)) {
                    return;
                }
                if (Alerts.noWinner()) {
                    return;
                }
                if (Counter.playerClicked == false) {
                    ComputerMove.computerTurn(rectangleFields, fieldWho);
                }
            }
        });
    }
}
