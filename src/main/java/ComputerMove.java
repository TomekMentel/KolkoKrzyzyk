import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class ComputerMove extends KolkoAndKrzyzyk{

    public static void computerTurn(Map<Integer, Field> rectangleFields, Rectangle fieldWho) {
        List<Map.Entry<Integer, Field>> possibleFields = rectangleFields.entrySet()
                .stream()
                .filter(map -> FieldValue.EMPTY.equals(map.getValue().getValue()))
                .collect(Collectors.toList());
        int index = random.nextInt(possibleFields.size());
        Map.Entry<Integer, Field> result = possibleFields.get(index);

        if (KolkoAndKrzyzyk.turnO) {
            field = rectangleFields.put(result.getKey(), result.getValue());
            field.getRectangle().setFill(new ImagePattern(KolkoAndKrzyzyk.imgO));
            result.getValue().setValue(FieldValue.CIRCLE);

            movCounter++;
            turnO = false;
            fieldWho.setFill(new ImagePattern(imgxsmall));

        } else {
            field = rectangleFields.put(result.getKey(), result.getValue());
            field.getRectangle().setFill(new ImagePattern(KolkoAndKrzyzyk.imgX));
            result.getValue().setValue(FieldValue.CROSS);

            movCounter++;
            turnO = true;

            fieldWho.setFill(new ImagePattern(imgOsmall));
        }
        if (KolkoAndKrzyzyk.check(rectangleFields)) {
            return;
        }
        if (KolkoAndKrzyzyk.noWinner()) {
            return;

        }
    }
    static void newGameTurn(Map<Integer, Field> rectangleFields) {
        List<Map.Entry<Integer, Field>> possibleFields = rectangleFields.entrySet()
                .stream()
                .filter(map -> FieldValue.EMPTY.equals(map.getValue().getValue()))
                .collect(Collectors.toList());
        int index = random.nextInt(possibleFields.size());
        Map.Entry<Integer, Field> result = possibleFields.get(index);

        if (turnO == false) {
            field = rectangleFields.put(result.getKey(), result.getValue());
            result.getValue().setValue(FieldValue.CROSS);
            field.getRectangle().setFill(new ImagePattern(imgX));

            movCounter++;
            turnO = true;
        }
    }
}
