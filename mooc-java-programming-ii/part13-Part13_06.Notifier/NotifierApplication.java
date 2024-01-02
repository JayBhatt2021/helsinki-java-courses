import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {
    @Override
    public void start(Stage window) {
        TextField topTextField = new TextField("");
        Button button = new Button("Update");
        Label label = new Label();

        VBox labelBar = new VBox();
        labelBar.getChildren().addAll(topTextField, button, label);

        button.setOnAction(event -> {
            label.setText(topTextField.getText());
        });

        Scene view = new Scene(labelBar, 200, 100);
        window.setScene(view);

        window.show();
    }


    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }
}
