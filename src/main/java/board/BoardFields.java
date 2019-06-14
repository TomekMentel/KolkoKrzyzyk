package board;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardFields {
    public static List<Rectangle> fields(Rectangle field1, Rectangle field2, Rectangle field3, Rectangle field4, Rectangle field5, Rectangle field6, Rectangle field7, Rectangle field8, Rectangle field9) {
        List<Rectangle> fields = new ArrayList<>();
        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
        fields.add(field4);
        fields.add(field5);
        fields.add(field6);
        fields.add(field7);
        fields.add(field8);
        fields.add(field9);
        return fields;
    }

    public static Map<Integer, Field> rectangleFields(Rectangle field1, Rectangle field2, Rectangle field3, Rectangle field4, Rectangle field5, Rectangle field6, Rectangle field7, Rectangle field8, Rectangle field9) {
        Map<Integer, Field> rectangleFields = new HashMap<>();
        rectangleFields.put(1, new Field(field1));
        rectangleFields.put(2, new Field(field2));
        rectangleFields.put(3, new Field(field3));
        rectangleFields.put(4, new Field(field4));
        rectangleFields.put(5, new Field(field5));
        rectangleFields.put(6, new Field(field6));
        rectangleFields.put(7, new Field(field7));
        rectangleFields.put(8, new Field(field8));
        rectangleFields.put(9, new Field(field9));
        return rectangleFields;
    }
}
