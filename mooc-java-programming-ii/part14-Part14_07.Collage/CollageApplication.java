import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {
    @Override
    public void start(Stage stage) {
        Image sourceImage = new Image("file:monalisa.png");
        PixelReader imageReader = sourceImage.getPixelReader();

        int originalWidth = (int) sourceImage.getWidth();
        int halfWidth = originalWidth / 2;

        int originalHeight = (int) sourceImage.getHeight();
        int halfHeight = originalHeight / 2;

        WritableImage targetImage = new WritableImage(originalWidth, originalHeight);
        PixelWriter imageWriter = targetImage.getPixelWriter();

        for (int y = 0; y < halfHeight; y++) {
            for (int x = 0; x < halfWidth; x++) {
                Color color = imageReader.getColor(x * 2, y * 2);
                Color negativeColor = applyNegativeEffect(color);

                imageWriter.setColor(x, y, negativeColor);
                imageWriter.setColor((x + halfWidth), y, negativeColor);
                imageWriter.setColor(x, (y + halfHeight), negativeColor);
                imageWriter.setColor((x + halfWidth), (y + halfHeight), negativeColor);
            }
        }

        Pane pane = new Pane();
        pane.getChildren().add(new ImageView(targetImage));

        stage.setScene(new Scene(pane));
        stage.show();
    }

    private Color applyNegativeEffect(Color color) {
        double red = 1.0 - color.getRed();
        double green = 1.0 - color.getGreen();
        double blue = 1.0 - color.getBlue();
        double opacity = color.getOpacity();

        return new Color(red, green, blue, opacity);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
