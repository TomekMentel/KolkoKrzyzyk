package logic.menu;

import components.Counter;
import components.Images;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Alerts {

    public static void createAlert(Image img) {
        ImageView imageView = new ImageView(img);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setGraphic(imageView);
        alert.setHeaderText("          THE WINNER IS :");
        alert.show();
    }

    public static boolean noWinner() {
        if (Counter.movCounter == 9 && !Counter.gameOver) {
            Alerts.createAlert(Images.imgNoWinners);
        }
        return false;
    }
}
