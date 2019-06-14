package logic.movement;

import board.Field;
import board.FieldValue;
import components.Counter;
import components.Images;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import logic.CheckWinner;
import logic.KolkoAndKrzyzyk;
import logic.menu.Alerts;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ComputerMove {

    public static void computerTurn(Map<Integer, Field> rectangleFields, Rectangle fieldWho) {
        Map.Entry<Integer, Field> result = chooseRandomField(rectangleFields);

        if (Counter.turnO) {
            KolkoAndKrzyzyk.field = rectangleFields.put(result.getKey(), result.getValue());
            KolkoAndKrzyzyk.field.getRectangle().setFill(new ImagePattern(Images.imgO));
            result.getValue().setValue(FieldValue.CIRCLE);

            Counter.movCounter++;
            Counter.turnO = false;
            fieldWho.setFill(new ImagePattern(Images.imgxsmall));

        } else {
            KolkoAndKrzyzyk.field = rectangleFields.put(result.getKey(), result.getValue());
            KolkoAndKrzyzyk.field.getRectangle().setFill(new ImagePattern(Images.imgX));
            result.getValue().setValue(FieldValue.CROSS);

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
    }

    public static void newGameTurn(Map<Integer, Field> rectangleFields) {
        Map.Entry<Integer, Field> result = chooseRandomField(rectangleFields);

        if (Counter.turnO == false) {
            KolkoAndKrzyzyk.field = rectangleFields.put(result.getKey(), result.getValue());
            result.getValue().setValue(FieldValue.CROSS);
            KolkoAndKrzyzyk.field.getRectangle().setFill(new ImagePattern(Images.imgX));

            Counter.movCounter++;
            Counter.turnO = true;
        }
    }

    private static Map.Entry<Integer, Field> chooseRandomField(Map<Integer, Field> rectangleFields) {
        List<Map.Entry<Integer, Field>> possibleFields = rectangleFields.entrySet()
                .stream()
                .filter(map -> FieldValue.EMPTY.equals(map.getValue().getValue()))
                .collect(Collectors.toList());
        int index = KolkoAndKrzyzyk.random.nextInt(possibleFields.size());
        return possibleFields.get(index);
    }
}
