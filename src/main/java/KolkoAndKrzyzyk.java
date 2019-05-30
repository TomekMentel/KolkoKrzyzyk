import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KolkoAndKrzyzyk extends Application {

    Image background = new Image("background1.jpg");
    Image imgEmpty = new Image("empty.bmp");
    Image imgO = new Image("o.bmp");
    Image imgX = new Image("x.bmp");
    Image imgOsmall = new Image("osmall.bmp");
    Image imgxsmall = new Image("xSmall.bmp");
    Image imgNoWinners = new Image("NoWinner.jpg");

    TextField scoreX;
    TextField scoreO;

    boolean turnO = true;

    Rectangle field1, field2, field3, field4, field5, field6, field7, field8, field9;

    static int counterX;
    static int counterO;
    private Field field;
    private int movCounter;

    public void check(Map<Integer, Field> rectangleFields) {

        if ((compareFieldValues(1, 2, rectangleFields)) && (compareFieldValues(2, 3, rectangleFields)) && (rectangleFields.get(1).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(4, 5, rectangleFields)) && (compareFieldValues(5, 6, rectangleFields)) && (rectangleFields.get(4).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(7, 8, rectangleFields)) && (compareFieldValues(8, 9, rectangleFields)) && (rectangleFields.get(7).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(1, 4, rectangleFields)) && (compareFieldValues(4, 7, rectangleFields)) && (rectangleFields.get(1).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(2, 5, rectangleFields)) && (compareFieldValues(5, 8, rectangleFields)) && (rectangleFields.get(2).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(3, 6, rectangleFields)) && (compareFieldValues(6, 9, rectangleFields)) && (rectangleFields.get(3).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(1, 5, rectangleFields)) && (compareFieldValues(5, 9, rectangleFields)) && (rectangleFields.get(1).getValue() != FieldValue.EMPTY) ||
                (compareFieldValues(3, 5, rectangleFields)) && (compareFieldValues(5, 7, rectangleFields)) && (rectangleFields.get(3).getValue() != FieldValue.EMPTY)) {

            if (turnO == true) {
                counterX++;
                createAlert(imgX);
                // restartGame(field1, field2, field3, field4, field5, field6, field7, field8, field9, rectangleFields);
            } else {
                counterO++;
                createAlert(imgO);
                //restartGame(field1, field2, field3, field4, field5, field6, field7, field8, field9, rectangleFields);
            }
        }
    }

    public boolean compareFieldValues(Integer index1, Integer index2, Map<Integer, Field> rectangleFields) {
        return rectangleFields.get(index1).getValue() == rectangleFields.get(index2).getValue();
    }

    public void computerTurn(Map<Integer, Field> rectangleFields) {
        /*Map<Integer, Field> result = rectangleFields.entrySet()
                .stream()
                .filter(map -> FieldValue.EMPTY.equals(map.getValue()))
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
                rectangleFields.forEach((key, value) -> value.setValue(FieldValue.CROSS));
        //System.out.println("Result: " + result);
*/
    }

    private void createAlert(Image img) {
        ImageView imageView = new ImageView(img);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("The Winner is:");
        alert.setGraphic(imageView);
        alert.show();
    }

    public void radioButons(List<RadioButton> rbList) {
        ToggleGroup tg = new ToggleGroup();
        for (RadioButton rb : rbList) {
            rb.setToggleGroup(tg);
        }
    }

    public void noWinner() {

        if (movCounter == 9) {
            createAlert(imgNoWinners);
        }
    }

    private void score() {
        scoreX.setText("" + counterX);
        scoreO.setText("" + counterO);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 720, 300);

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

        MenuButton difficulty = new MenuButton();
        difficulty.relocate(600, 220);

        Button btNewGame = new Button("NEW GAME");
        btNewGame.relocate(600, 200);
        btNewGame.setStyle("-fx-background-color: #2c64dc");

        Button exitButton = new Button("EXIT");
        exitButton.relocate(682, 275);
        exitButton.setStyle("-fx-background-color: #dc3b44");
        exitButton.setOnAction(actionEvent -> Platform.exit());

        Label scoreO = new Label();
        scoreO.relocate(420, 130);
        scoreO.setFont(new Font("Arial", 30));
        scoreO.setTextFill(Color.DARKBLUE);
        scoreO.setText(": " + counterX);

        Label scoreX = new Label();
        scoreX.relocate(630, 130);
        scoreX.setFont(new Font("Arial", 30));
        scoreX.setTextFill(Color.DARKBLUE);
        scoreX.setText(":" + counterO);

        TextField tfPlayer1 = new TextField();
        tfPlayer1.setText("Enter your name");
        tfPlayer1.relocate(350, 50);
        tfPlayer1.setPrefColumnCount(8);

        TextField tfPlayer2 = new TextField();
        tfPlayer2.setText("Enter your name");
        tfPlayer2.relocate(590, 50);
        tfPlayer2.setPrefColumnCount(8);

        RadioButton selectP = new RadioButton();
        selectP.relocate(550, 17);

        RadioButton selectC = new RadioButton();
        selectC.relocate(550, 95);

        List<RadioButton> rbList = new ArrayList<RadioButton>();
        rbList.add(selectC);
        rbList.add(selectP);
        radioButons(rbList);

        fieldWho.setFill(new ImagePattern(imgOsmall));
        fieldScoreO.setFill(new ImagePattern(imgOsmall));
        fieldScoreX.setFill(new ImagePattern(imgxsmall));

        btNewGame.setOnAction(event -> {
            restartGame(field1, field2, field3, field4, field5, field6, field7, field8, field9, rectangleFields);
        });

        emptyField(field1, field2, field3, field4, field5, field6, field7, field8, field9);

        root.getChildren().add(imgView);
        root.getChildren().addAll(scoreO, scoreX, btNewGame, exitButton, tfPlayer1, tfPlayer2, selectP, selectC);
        root.getChildren().addAll(fieldWho, fieldScoreO, fieldScoreX);
        root.getChildren().addAll(field1, field2, field3, field4, field5, field6, field7, field8, field9);

        primaryStage.setTitle("Kolko I Krzyzyk");
        primaryStage.setScene(scene);
        primaryStage.show();
        addMouseReleased(fieldWho, rectangleFields);
    }

    public void restartGame(Rectangle field1, Rectangle field2, Rectangle field3, Rectangle field4, Rectangle field5,
                            Rectangle field6, Rectangle field7, Rectangle field8, Rectangle field9, Map<Integer, Field> rectangleFields) {
        emptyField(field1, field2, field3, field4, field5, field6, field7, field8, field9);
        rectangleFields.forEach((key, value) -> value.setValue(FieldValue.EMPTY));

        movCounter = 0;
    }

    public void addMouseReleased(Rectangle fieldWho, Map<Integer, Field> rectangleFields) {

        addMouseReleased(1, fieldWho, rectangleFields);
        addMouseReleased(2, fieldWho, rectangleFields);
        addMouseReleased(3, fieldWho, rectangleFields);
        addMouseReleased(4, fieldWho, rectangleFields);
        addMouseReleased(5, fieldWho, rectangleFields);
        addMouseReleased(6, fieldWho, rectangleFields);
        addMouseReleased(7, fieldWho, rectangleFields);
        addMouseReleased(8, fieldWho, rectangleFields);
        addMouseReleased(9, fieldWho, rectangleFields);
    }

    public void emptyField(Rectangle field1, Rectangle field2, Rectangle field3, Rectangle field4,
                           Rectangle field5, Rectangle field6, Rectangle field7, Rectangle field8,
                           Rectangle field9) {

        field1.setFill(new ImagePattern(imgEmpty));
        field2.setFill(new ImagePattern(imgEmpty));
        field3.setFill(new ImagePattern(imgEmpty));
        field4.setFill(new ImagePattern(imgEmpty));
        field5.setFill(new ImagePattern(imgEmpty));
        field6.setFill(new ImagePattern(imgEmpty));
        field7.setFill(new ImagePattern(imgEmpty));
        field8.setFill(new ImagePattern(imgEmpty));
        field9.setFill(new ImagePattern(imgEmpty));

    }

    private void addMouseReleased(Integer fieldId, Rectangle fieldWho, Map<Integer, Field> rectangleFields) {

        Field field = rectangleFields.get(fieldId);
        field.getRectangle().setOnMouseReleased(event -> {
            if (field.getValue() == FieldValue.EMPTY) {
                if (turnO == true) {
                    field.getRectangle().setFill(new ImagePattern(imgO));
                    field.setValue(FieldValue.CIRCLE);

                    movCounter++;
                    turnO = false;
                    fieldWho.setFill(new ImagePattern(imgxsmall));
                    counterO++;

                } else {
                    field.getRectangle().setFill(new ImagePattern(imgX));
                    field.setValue(FieldValue.CROSS);

                    movCounter++;
                    counterX++;
                    turnO = true;

                    fieldWho.setFill(new ImagePattern(imgOsmall));
                }
                computerTurn(rectangleFields);
                check(rectangleFields);
                noWinner();
                score();
            }
        });
    }
}