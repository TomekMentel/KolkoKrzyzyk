package logic.menu;

import components.Buttons;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logic.WriteLoadScore;

public class ScoreWindow extends Application {

    public static void score() {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 470);
        Stage stageScore = new Stage();

        Button exit = Buttons.createButtonExit();
        exit.relocate(372, 455);

        ListView<String> lvScore = new ListView<>();
        lvScore.relocate(80, 50);
        lvScore.getItems().addAll(WriteLoadScore.loadScore());
        Image background = new Image("background.jpg");
        ImageView imgView = new ImageView(background);

        root.getChildren().add(imgView);
        root.getChildren().addAll(exit, lvScore);
        stageScore.setTitle("Score");
        stageScore.setScene(scene);
        stageScore.show();
        stageScore.setResizable(false);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
