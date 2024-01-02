import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HurraaSovellus extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setCenter(new Button("Hurraa!"));

        stage.setScene(new Scene(pane, 600, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
