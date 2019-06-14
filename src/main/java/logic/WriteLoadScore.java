package logic;

import components.Counter;
import javafx.scene.control.TextField;

import java.io.*;

public class WriteLoadScore {

    public static void writeScore(TextField tfUsername1, TextField tfUsername2) {
        try (FileWriter bw = new FileWriter("users.txt", true)) {
            BufferedWriter out = new BufferedWriter(bw);
            bw.write(tfUsername1.getText() + "  - vs -  " + tfUsername2.getText() + " " + KolkoAndKrzyzyk.scoreO.getText()
                    + " " + KolkoAndKrzyzyk.scoreX.getText());
            bw.write("\r\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void score() {
        KolkoAndKrzyzyk.scoreO.setText(":" + Counter.counterO);
        KolkoAndKrzyzyk.scoreX.setText(":" + Counter.counterX);
    }

    public static String loadScore() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("users.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        {
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                try {
                    line = br.readLine();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            return sb.toString();
        }
    }
}