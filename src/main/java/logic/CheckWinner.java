package logic;

import board.Field;
import board.FieldValue;
import components.Counter;
import components.Images;
import logic.menu.Alerts;

import java.util.Map;

public class CheckWinner {

    public static boolean check(Map<Integer, Field> rectangleFields) {
        if ((compareFieldValues(1, 2, rectangleFields)) && (compareFieldValues(2, 3, rectangleFields)) && (rectangleFields.get(1).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(4, 5, rectangleFields)) && (compareFieldValues(5, 6, rectangleFields)) && (rectangleFields.get(4).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(7, 8, rectangleFields)) && (compareFieldValues(8, 9, rectangleFields)) && (rectangleFields.get(7).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(1, 4, rectangleFields)) && (compareFieldValues(4, 7, rectangleFields)) && (rectangleFields.get(1).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(2, 5, rectangleFields)) && (compareFieldValues(5, 8, rectangleFields)) && (rectangleFields.get(2).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(3, 6, rectangleFields)) && (compareFieldValues(6, 9, rectangleFields)) && (rectangleFields.get(3).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(1, 5, rectangleFields)) && (compareFieldValues(5, 9, rectangleFields)) && (rectangleFields.get(1).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(3, 5, rectangleFields)) && (compareFieldValues(5, 7, rectangleFields)) && (rectangleFields.get(3).getValue() != FieldValue.EMPTY)) {

            if (Counter.turnO) {
                Counter.counterX++;
                WriteLoadScore.score();
                Alerts.createAlert(Images.imgX);
                Counter.playerClicked = true;

            } else {
                Counter.counterO++;
                Alerts.createAlert(Images.imgO);
                WriteLoadScore.score();
                Counter.playerClicked = true;
            }
            Counter.gameOver = true;
        }
        return false;
    }

    static boolean compareFieldValues(Integer index1, Integer index2, Map<Integer, Field> rectangleFields) {
        return rectangleFields.get(index1).getValue() == rectangleFields.get(index2).getValue();
    }
}
