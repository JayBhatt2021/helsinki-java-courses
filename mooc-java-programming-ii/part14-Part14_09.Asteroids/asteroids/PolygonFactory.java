package asteroids;

import java.util.Random;

import javafx.scene.shape.Polygon;

public class PolygonFactory {
    public Polygon createPolygon() {
        Random random = new Random();
        double size = random.nextInt(10) + 10;

        double cos1 = Math.cos(Math.PI * 2 / 5);
        double cos2 = Math.cos(Math.PI / 5);
        double sin1 = Math.sin(Math.PI * 2 / 5);
        double sin2 = Math.sin(Math.PI * 4 / 5);
        Polygon polygon = new Polygon();

        polygon.getPoints().addAll(
                size,
                0.0,
                size * cos1,
                -1 * size * sin1,
                -1 * size * cos2,
                -1 * size * sin2,
                -1 * size * cos2,
                size * sin2,
                size * cos1,
                size * sin1
        );

        for (int i = 0; i < polygon.getPoints().size(); i++) {
            int change = random.nextInt(5) - 2;
            polygon.getPoints().set(i, polygon.getPoints().get(i) + change);
        }

        return polygon;
    }
}
