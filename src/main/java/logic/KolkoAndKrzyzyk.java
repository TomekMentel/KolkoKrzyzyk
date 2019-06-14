package logic;

import board.BoardFields;
import board.BoardInitialization;
import board.Field;
import components.Buttons;
import components.Images;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import logic.menu.Labels;
import logic.menu.RadioButtons;
import logic.menu.TextFields;
import logic.movement.PlayerMove;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class KolkoAndKrzyzyk extends Application {

    public static Field field;
    protected static Label scoreX = new Label();
    protected static Label scoreO = new Label();
    public static Random random = new Random();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 709, 288);

        ImageView imgView = new ImageView(Images.background);
        Rectangle field1 = new Rectangle(1, 1, 100, 100);
        Rectangle field2 = new Rectangle(100, 1, 100, 100);
        Rectangle field3 = new Rectangle(200, 1, 100, 100);
        Rectangle field4 = new Rectangle(1, 100, 100, 100);
        Rectangle field5 = new Rectangle(100, 100, 100, 100);
        Rectangle field6 = new Rectangle(200, 100, 100, 100);
        Rectangle field7 = new Rectangle(1, 200, 100, 100);
        Rectangle field8 = new Rectangle(100, 200, 100, 100);
        Rectangle field9 = new Rectangle(200, 200, 100, 100);
        Rectangle fieldWho = new Rectangle(500, 200, 30, 30);

        Rectangle fieldScoreO = new Rectangle(380, 135, 28, 28);
        Rectangle fieldScoreX = new Rectangle(590, 135, 28, 28);

        Map<Integer, Field> rectangleFields = BoardFields.rectangleFields
                (field1, field2, field3, field4, field5, field6, field7, field8, field9);

        List<Rectangle> fields = BoardFields.fields
                (field1, field2, field3, field4, field5, field6, field7, field8, field9);

        TextField tfPlayer1 = TextFields.tfPlayer1();
        TextField tfPlayer2 = TextFields.tfPlayer2();

        Button btSave = Buttons.createSaveButton(tfPlayer1, tfPlayer2);
        Button btExit = Buttons.createButtonExit();
        Button btScore = Buttons.createScoreButton();
        Button btNewGame = Buttons.createNewGameButton(fields, rectangleFields);
        Labels.createScoreLabel(scoreO, scoreX);

        NewGame.emptyField(fields);

        BoardInitialization.createStage(primaryStage, scene);

        PlayerMove.addMouseReleased(fieldWho, rectangleFields);

        RadioButton selectP = RadioButtons.rbSelectPlayer();
        RadioButton selectC = RadioButtons.rbSelectComputer();
        RadioButtons.rbList(selectP, selectC);

        fieldWho.setFill(new ImagePattern(Images.imgOsmall));
        fieldScoreO.setFill(new ImagePattern(Images.imgOsmall));
        fieldScoreX.setFill(new ImagePattern(Images.imgxsmall));

        root.getChildren().add(imgView);
        root.getChildren().addAll(scoreO, scoreX, btNewGame, btExit, btSave, btScore, tfPlayer1, tfPlayer2, selectP, selectC);
        root.getChildren().addAll(fieldWho, fieldScoreO, fieldScoreX);
        root.getChildren().addAll(field1, field2, field3, field4, field5, field6, field7, field8, field9);
    }
}