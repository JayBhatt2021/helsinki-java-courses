import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {
    @Override
    public void start(Stage windows) {
        Label firstLabel = new Label("Enter your name and start");
        TextField textField = new TextField();
        Button firstButton = new Button("Start");
        GridPane gPane = new GridPane();

        gPane.add(firstLabel, 0, 0);
        gPane.add(textField, 0, 1);
        gPane.add(firstButton, 0, 2);

        Scene firstScene = new Scene(gPane, 300, 180);

        gPane.setPrefSize(300, 180);
        gPane.setAlignment(Pos.CENTER);
        gPane.setVgap(10);
        gPane.setHgap(10);
        gPane.setPadding(new Insets(20, 20, 20, 20));

        Label secondLabel = new Label();
        StackPane secondPane = new StackPane();
        secondPane.getChildren().add(secondLabel);

        Scene secondScene = new Scene(secondPane, 300, 180);

        firstButton.setOnAction(event -> {
            secondLabel.setText("Welcome " + textField.getText() + "!");
            windows.setScene(secondScene);
        });

        windows.setScene(firstScene);
        windows.show();
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
