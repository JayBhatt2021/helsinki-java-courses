import asteroids.Asteroid;
import asteroids.Projectile;
import asteroids.Ship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {
    Random random = new Random();
    Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
    List<Projectile> projectiles = new ArrayList<>();

    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);

        // Points
        AtomicInteger points = new AtomicInteger();
        Text pointsText = new Text(10, 20, "Points: 0");
        pane.getChildren().add(pointsText);

        // Creates the Polygon ship
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        pane.getChildren().add(ship.getCharacter());
        Scene scene = new Scene(pane);

        // Creates the asteroids
        List<Asteroid> asteroids = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            asteroids.add(new Asteroid(random.nextInt(WIDTH / 3), random.nextInt(HEIGHT)));
        }

        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));

        // Event Listeners
        scene.setOnKeyPressed(keyPress -> {
            pressedKeys.put(keyPress.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(keyRelease -> {
            pressedKeys.put(keyRelease.getCode(), Boolean.FALSE);
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Adds a chance for a random asteroid to spawn
                if (Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);

                    if (!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }

                // Ship Movement Controls
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }

                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }

                // Ship Shooting Controls
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile(
                            (int) ship.getCharacter().getTranslateX(),
                            (int) ship.getCharacter().getTranslateY()
                    );
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());

                    projectiles.add(projectile);

                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    pane.getChildren().add(projectile.getCharacter());
                }

                // Character Movement
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());

                // Handles projectile collision and subsequent point incrementation
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                        }
                    });

                    if (!projectile.isAlive()) {
                        pointsText.setText("Points: " + points.addAndGet(1000));
                    }
                });

                // Removes dead projectiles
                projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));

                projectiles.removeAll(
                        projectiles.stream()
                                .filter(projectile -> !projectile.isAlive())
                                .collect(Collectors.toList())
                );

                // Removes dead asteroids
                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));

                asteroids.removeAll(
                        asteroids.stream()
                                .filter(asteroid -> !asteroid.isAlive())
                                .collect(Collectors.toList())
                );
            }
        }.start();

        stage.setTitle("Asteroids");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value
        return 4;
    }
}
