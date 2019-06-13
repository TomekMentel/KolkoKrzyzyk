package data;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Field {

    private FieldValue value;
    private Rectangle rectangle;

    public Field(Rectangle rectangle) {
        value = FieldValue.EMPTY;
        this.rectangle = rectangle;
    }

    public Field(FieldValue value, Rectangle rectangle) {
        this.value = value;
        this.rectangle = rectangle;
    }

    public FieldValue getValue() {
        return value;
    }

    public void setValue(FieldValue value) {
        this.value = value;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return value == field.value &&
                Objects.equals(rectangle, field.rectangle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, rectangle);
    }

    public static List<Rectangle> fields(Rectangle field1, Rectangle field2, Rectangle field3, Rectangle field4, Rectangle field5, Rectangle field6, Rectangle field7, Rectangle field8, Rectangle field9) {
        List <Rectangle> fields = new ArrayList<>();
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
}
