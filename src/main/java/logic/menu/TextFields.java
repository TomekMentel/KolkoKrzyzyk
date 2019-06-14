package logic.menu;

import javafx.scene.control.TextField;

public class TextFields {
    public static TextField tfPlayer2() {
        TextField tfPlayer2 = new TextField();
        tfPlayer2.setText("Computer");
        tfPlayer2.relocate(590, 50);
        tfPlayer2.setPrefColumnCount(8);
        return tfPlayer2;
    }

    public static TextField tfPlayer1() {
        TextField tfPlayer1 = new TextField();
        tfPlayer1.setText("Enter your name");
        tfPlayer1.relocate(350, 50);
        tfPlayer1.setPrefColumnCount(8);
        return tfPlayer1;
    }
}
