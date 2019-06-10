package data;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import logic.PlayerMove;

import java.util.*;

public class KolkoAndKrzyzyk extends Application {

    private Image background = new Image("background1.jpg");
    protected static Image imgEmpty = new Image("empty.bmp");
    protected static Image imgO = new Image("o.bmp");
    protected static Image imgX = new Image("x.bmp");
    protected static Image imgOsmall = new Image("osmall.bmp");
    protected static Image imgxsmall = new Image("xSmall.bmp");
    static Image imgNoWinners = new Image("NoWinner.jpg");

    public static boolean turnO = true;

    protected static int counterX;
    protected static int counterO;
    protected static Field field;
    protected static int movCounter;

    protected static Label scoreX = new Label();
    protected static Label scoreO = new Label();
    protected static boolean playerClicked = false;
    protected static Random random = new Random();
    protected static boolean gameOver = false;

    private void radioButtons(List<RadioButton> rbList) {
        ToggleGroup tg = new ToggleGroup();
        for (RadioButton rb : rbList) {
            rb.setToggleGroup(tg);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        Group root = new Group();
        Scene scene = new Scene(root, 709, 288);

        ImageView imgView = new ImageView(background);
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

        Map<Integer, Field> rectangleFields = new HashMap<>();
        rectangleFields.put(1, new Field(field1));
        rectangleFields.put(2, new Field(field2));
        rectangleFields.put(3, new Field(field3));
        rectangleFields.put(4, new Field(field4));
        rectangleFields.put(5, new Field(field5));
        rectangleFields.put(6, new Field(field6));
        rectangleFields.put(7, new Field(field7));
        rectangleFields.put(8, new Field(field8));
        rectangleFields.put(9, new Field(field9));

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

        TextField tfPlayer1 = new TextField();
        tfPlayer1.setText("Enter your name");
        tfPlayer1.relocate(350, 50);
        tfPlayer1.setPrefColumnCount(8);

        TextField tfPlayer2 = new TextField();
        tfPlayer2.setText("Computer");
        tfPlayer2.relocate(590, 50);
        tfPlayer2.setPrefColumnCount(8);

        Button btSave = Buttons.createSaveButton(tfPlayer1, tfPlayer2);

        Button btExit = Buttons.createButtonExit();

        Button btScore = Buttons.createScoreButton();

        Button btNewGame = Buttons.createNewGameButton(fields,rectangleFields);

        Buttons.createScoreLabel(scoreO, scoreX);

        NewGame.emptyField(fields);

        BoardInitialization.createStage(primaryStage, scene);

        PlayerMove.addMouseReleased(fieldWho, rectangleFields);

        RadioButton selectP = new RadioButton();
        selectP.relocate(550, 17);
        selectP.setOnAction(event -> {
            playerClicked = true;
        });

        RadioButton selectC = new RadioButton();
        selectC.relocate(550, 95);
        selectC.setOnAction(event -> {
            playerClicked = false;
        });

        List<RadioButton> rbList = new ArrayList<>();
        rbList.add(selectC);
        rbList.add(selectP);
        radioButtons(rbList);

        fieldWho.setFill(new ImagePattern(imgOsmall));
        fieldScoreO.setFill(new ImagePattern(imgOsmall));
        fieldScoreX.setFill(new ImagePattern(imgxsmall));

        root.getChildren().add(imgView);
        root.getChildren().addAll(scoreO, scoreX, btNewGame, btExit, btSave, btScore, tfPlayer1, tfPlayer2, selectP, selectC);
        root.getChildren().addAll(fieldWho, fieldScoreO, fieldScoreX);
        root.getChildren().addAll(field1, field2, field3, field4, field5, field6, field7, field8, field9);
    }
}