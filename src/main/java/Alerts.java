import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Alerts {

    public static void createAlert(Image img) {
        ImageView imageView = new ImageView(img);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("The Winner is:");
        alert.setGraphic(imageView);
        alert.show();
    }
}