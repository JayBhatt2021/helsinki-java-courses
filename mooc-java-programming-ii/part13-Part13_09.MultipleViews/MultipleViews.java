import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {
    @Override
    public void start(Stage windows) {
        BorderPane firstBorderPane = new BorderPane();
        Button firstButton = new Button("To second view");

        firstBorderPane.setTop(new Label("First View"));
        firstBorderPane.setCenter(firstButton);

        Button secondButton = new Button("To the third view");
        Label secondLabel = new Label("Second view");
        VBox vBox = new VBox();

        vBox.getChildren().addAll(secondButton, secondLabel);

        Button thirdButton = new Button("To the first view");
        Label thirdLabel = new Label("Third view");
        GridPane gPane = new GridPane();

        gPane.add(thirdButton, 1, 1);
        gPane.add(thirdLabel, 0, 0);

        Scene firstScene = new Scene(firstBorderPane, 300, 300);
        Scene secondScene = new Scene(vBox, 300, 300);
        Scene thirdScene = new Scene(gPane, 300, 300);

        firstButton.setOnAction(event -> {
            windows.setScene(secondScene);
        });

        secondButton.setOnAction(event -> {
            windows.setScene(thirdScene);
        });

        thirdButton.setOnAction(event -> {
            windows.setScene(firstScene);
        });

        windows.setScene(firstScene);
        windows.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }
}
