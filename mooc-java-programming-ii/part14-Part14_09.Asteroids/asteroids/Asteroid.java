package asteroids;

import java.util.Random;

public class Asteroid extends Character {
    private boolean alive;
    private double rotationalMovement;

    public Asteroid(int x, int y) {
        super(new PolygonFactory().createPolygon(), x, y);

        Random random = new Random();
        super.getCharacter().setRotate(random.nextInt(360));

        int accelerationAmount = random.nextInt(10) + 1;
        for (int i = 0; i < accelerationAmount; i++) {
            super.accelerate();
        }

        this.alive = true;
        this.rotationalMovement = 0.5 - random.nextDouble();
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public void move() {
        super.move();
        super.getCharacter().setRotate(super.getCharacter().getRotate() + this.rotationalMovement);
    }
}
