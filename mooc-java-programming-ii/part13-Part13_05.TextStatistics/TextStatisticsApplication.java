import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {
    @Override
    public void start(Stage window) {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(new TextArea("This is a tfield"));

        Label firstLabel = new Label("Letters: 0");
        Label secondLabel = new Label("Words: 0");
        Label thirdLabel = new Label("The longest word is: ");
        HBox labelBar = new HBox();

        labelBar.setSpacing(10);
        labelBar.getChildren().add(firstLabel);
        labelBar.getChildren().add(secondLabel);
        labelBar.getChildren().add(thirdLabel);
        borderPane.setBottom(labelBar);

        Scene view = new Scene(borderPane, 500, 500);
        window.setScene(view);

        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
}
