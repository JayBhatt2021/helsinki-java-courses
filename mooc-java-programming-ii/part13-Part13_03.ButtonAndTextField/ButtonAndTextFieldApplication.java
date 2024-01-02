import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {
    @Override
    public void start(Stage window) {
        Button button = new Button("Button");
        TextField textField = new TextField();
        Pane pane = new Pane();

        pane.getChildren().add(button);
        pane.getChildren().add(textField);

        button.setLayoutX(100);
        button.setLayoutY(100);
        textField.setLayoutX(250);
        textField.setLayoutY(250);

        Scene view = new Scene(pane, 500, 500);
        window.setScene(view);

        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }
}
