package data;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.List;

public class RadioButtons {

    static void radioButtons(List<RadioButton> rbList) {
        ToggleGroup tg = new ToggleGroup();
        for (RadioButton rb : rbList) {
            rb.setToggleGroup(tg);
        }
    }

    public static RadioButton rbSelectPlayer() {
        RadioButton selectP = new RadioButton();
        selectP.relocate(550, 17);
        selectP.setOnAction(event -> {
            KolkoAndKrzyzyk.playerClicked = true;
        });
        return selectP;
    }

    public static void rbList(RadioButton selectP, RadioButton selectC) {
        List<RadioButton> rbList = new ArrayList<>();
        rbList.add(selectC);
        rbList.add(selectP);
        radioButtons(rbList);
    }

    public static RadioButton rbSelectComputer() {
        RadioButton selectC = new RadioButton();
        selectC.relocate(550, 95);
        selectC.setOnAction(event -> {
            KolkoAndKrzyzyk.playerClicked = false;
        });
        return selectC;
    }
}
