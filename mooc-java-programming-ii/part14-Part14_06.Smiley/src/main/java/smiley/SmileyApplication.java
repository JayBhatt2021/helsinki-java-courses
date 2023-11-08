package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {
    
    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Canvas paintingCanvas = new Canvas(400, 400);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        
        painter.setFill(Color.BLACK); 
        painter.fillRect(80, 40, 50, 50);
        painter.fillRect(250, 40, 50, 50);
        painter.fillRect(30, 200, 50, 50);
        painter.fillRect(300, 200, 50, 50);
        painter.fillRect(80, 250, 220, 50); 
        
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(paintingCanvas);
               
        window.setScene(new Scene(mainLayout));
        window.setTitle("Smiley");
        window.show();
    }
}