package data;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoardInitialization {

    public static void createStage(Stage primaryStage, Scene scene) {
        primaryStage.setTitle("Kolko I Krzyzyk");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
