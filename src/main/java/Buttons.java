import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Buttons {

    public static Button createSaveButton(TextField tfPlayer1, TextField tfPlayer2) {
        Button btSave = new Button("SAVE");
        btSave.relocate(682, 170);
        btSave.setStyle("-fx-background-color: #207bdc");
        btSave.setOnAction(event -> {

            try {
                KolkoAndKrzyzyk.writeScore(tfPlayer1, tfPlayer2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return btSave;
    }
}
