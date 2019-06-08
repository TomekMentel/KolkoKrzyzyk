import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteScore {


    static void writeScore(TextField tfUsername1, TextField tfUsername2) throws IOException {

        try (FileWriter bw = new FileWriter("users.txt", true)) {
            BufferedWriter out = new BufferedWriter(bw);
            bw.write(tfUsername1.getText() + " VS " + tfUsername2.getText() + KolkoAndKrzyzyk.scoreO.getText() + KolkoAndKrzyzyk.scoreX.getText());
            bw.write("\r\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void score() {
        KolkoAndKrzyzyk.scoreO.setText(":" + KolkoAndKrzyzyk.counterO);
        KolkoAndKrzyzyk.scoreX.setText(":" + KolkoAndKrzyzyk.counterX);
    }
}
