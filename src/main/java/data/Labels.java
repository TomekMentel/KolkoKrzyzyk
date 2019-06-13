package data;

import javafx.scene.control.Labeled;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Labels {
    public static void createScoreLabel(Labeled scoreO, Labeled scoreX) {
        scoreO.relocate(420, 130);
        scoreO.setFont(new Font("Arial", 30));
        scoreO.setTextFill(Color.DARKBLUE);
        scoreO.setText(": " + KolkoAndKrzyzyk.counterX);

        scoreX.relocate(630, 130);
        scoreX.setFont(new Font("Arial", 30));
        scoreX.setTextFill(Color.DARKBLUE);
        scoreX.setText(":" + KolkoAndKrzyzyk.counterO);
    }
}
