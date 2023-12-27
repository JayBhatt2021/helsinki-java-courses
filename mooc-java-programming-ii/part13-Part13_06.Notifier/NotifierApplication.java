package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication  extends Application {
    @Override
    public void start(Stage window) {
        VBox labelBar = new VBox();
        TextField topTxtField = new TextField("");
        
        Button btn = new Button("Update");
        Label thirdLabel = new Label();

        labelBar.getChildren().addAll(topTxtField, btn, thirdLabel);

        Scene view = new Scene(labelBar, 200, 100);
        btn.setOnAction(event -> {
            thirdLabel.setText(topTxtField.getText());
        });

        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
       launch(NotifierApplication.class);
    }
}