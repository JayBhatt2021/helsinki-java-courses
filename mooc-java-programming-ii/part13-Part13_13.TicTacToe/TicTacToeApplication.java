import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {
    private boolean xTurn;
    private boolean finished;
    private final Label turnLabel;
    private final Button[] buttons;

    public TicTacToeApplication() {
        this.xTurn = true;
        this.finished = false;
        this.turnLabel = new Label("Turn: X");

        this.buttons = new Button[9];
        for (int i = 0; i < 9; i++) {
            this.buttons[i] = this.createButton();
        }
    }

    private Button createButton() {
        Button button = new Button(" ");
        button.setFont(new Font("Monospaced", 40));
        button.setPrefSize(90, 90);

        button.setOnAction(event -> {
            if (this.finished) {
                return;
            }
            if (this.isUnavailable(button)) {
                return;
            }

            if (this.xTurn) {
                button.setText("X");
                this.turnLabel.setText("Turn: O");

                this.xTurn = false;
            } else {
                button.setText("O");
                this.turnLabel.setText("Turn: X");

                this.xTurn = true;
            }

            if (this.gameScratched() || this.gameWon()) {
                this.turnLabel.setText("The end!");
                this.finished = true;
            }
        });

        return button;
    }

    private boolean gameScratched() {
        return this.isUnavailable(this.buttons[0]) && this.isUnavailable(this.buttons[1]) &&
                this.isUnavailable(this.buttons[2]) && this.isUnavailable(this.buttons[3]) &&
                this.isUnavailable(this.buttons[4]) && this.isUnavailable(this.buttons[5]) &&
                this.isUnavailable(this.buttons[6]) && this.isUnavailable(this.buttons[7]) &&
                this.isUnavailable(this.buttons[8]);
    }

    private boolean gameWon() {
        if (this.isUnavailable(this.buttons[0])) {
            // Top Row
            if (this.isEqual(this.buttons[0], this.buttons[1]) && this.isEqual(this.buttons[0], this.buttons[2])) {
                return true;
            }

            // First Column
            if (this.isEqual(this.buttons[0], this.buttons[3]) && this.isEqual(this.buttons[0], this.buttons[6])) {
                return true;
            }

            // Northwest-Southeast Diagonal
            if (this.isEqual(this.buttons[0], this.buttons[4]) && this.isEqual(this.buttons[0], this.buttons[8])) {
                return true;
            }
        }

        if (this.isUnavailable(this.buttons[1])) {
            // Second Column
            if (this.isEqual(this.buttons[1], this.buttons[4]) && this.isEqual(this.buttons[1], this.buttons[7])) {
                return true;
            }
        }

        if (this.isUnavailable(this.buttons[2])) {
            // Third Column
            if (this.isEqual(this.buttons[2], this.buttons[5]) && this.isEqual(this.buttons[2], this.buttons[8])) {
                return true;
            }

            // Northeast-Southwest Diagonal
            if (this.isEqual(this.buttons[2], this.buttons[4]) && this.isEqual(this.buttons[2], this.buttons[6])) {
                return true;
            }
        }

        if (this.isUnavailable(this.buttons[3])) {
            // Middle Row
            if (this.isEqual(this.buttons[3], this.buttons[4]) && this.isEqual(this.buttons[3], this.buttons[5])) {
                return true;
            }
        }

        if (this.isUnavailable(this.buttons[6])) {
            // Bottom Row
            if (this.isEqual(this.buttons[6], this.buttons[7]) && this.isEqual(this.buttons[6], this.buttons[8])) {
                return true;
            }
        }

        return false;
    }

    private boolean isUnavailable(Button button) {
        return !button.getText().equals(" ");
    }

    private boolean isEqual(Button buttonOne, Button buttonTwo) {
        return buttonOne.getText().equals(buttonTwo.getText());
    }

    @Override
    public void start(Stage window) {
        this.turnLabel.setFont(new Font(30.0));

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(this.buttons[0], 1, 0);
        grid.add(this.buttons[1], 2, 0);
        grid.add(this.buttons[2], 3, 0);
        grid.add(this.buttons[3], 1, 1);
        grid.add(this.buttons[4], 2, 1);
        grid.add(this.buttons[5], 3, 1);
        grid.add(this.buttons[6], 1, 2);
        grid.add(this.buttons[7], 2, 2);
        grid.add(this.buttons[8], 3, 2);

        BorderPane layout = new BorderPane();
        layout.setPrefSize(310, 350);
        layout.setTop(this.turnLabel);
        layout.setCenter(grid);

        Scene view = new Scene(layout);
        window.setScene(view);

        window.show();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}
