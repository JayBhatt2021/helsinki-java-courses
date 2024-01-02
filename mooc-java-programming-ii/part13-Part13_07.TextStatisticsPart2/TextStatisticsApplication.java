import java.util.Arrays;

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
        TextArea textArea = new TextArea();
        borderPane.setCenter(textArea);

        Label lettersLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestWordLabel = new Label("The longest word is: ");
        HBox labelBar = new HBox();

        labelBar.setSpacing(10);
        labelBar.getChildren().addAll(lettersLabel, wordsLabel, longestWordLabel);
        borderPane.setBottom(labelBar);

        Scene view = new Scene(borderPane, 500, 500);
        window.setScene(view);

        window.show();

        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characterCount = newValue.length();
            String[] words = newValue.split(" ");
            int wordCount = words.length;

            String longestWord = Arrays.stream(words)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();

            lettersLabel.setText("Letters: " + String.valueOf(characterCount));
            wordsLabel.setText("Words: " + String.valueOf(wordCount));
            longestWordLabel.setText("The longest word is: " + longestWord);
        });
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
}
