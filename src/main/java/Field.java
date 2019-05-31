import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

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


}
