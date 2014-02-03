package tennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {

    int x = 175;
    int y = 225;
    int dirX = 1;
    int dirY = 1;
    private Tennis game;
    private static final int DIAMETER = 15;

    public Ball(Tennis game) {
        this.game = game;
    }

    void move() {
        if (x + dirX < 0) {
            dirX = 1;
        }
        if (x + dirX > game.getWidth() - DIAMETER) {
            dirX = -1;
        }
        if (y + dirY < 0) {
            dirY = 1;
        }
        if (y > game.getHeight() - DIAMETER) {
            game.gameOver("Jugador 1");
        }
        if (y == 0) {
            game.gameOver("Jugador 2");
        }
        if (midRaquetCollision()) {
            dirY = -1;
            y = game.raquet.getTopY() - DIAMETER;
            dirX = 0;
        }
        if (midRacquetCollision()) {
            dirY = 1;
            y = game.racquet.getTopY();
            dirX = 0;
        }
        if (rightRaquetCollision()) {
            dirY = -1;
            y = game.raquet.getTopY() - DIAMETER;
            dirX = 1;
        }
        if (leftRaquetCollision()) {
            dirY = -1;
            y = game.raquet.getTopY() - DIAMETER;
            dirX = -1;
        }
        if (rightRacquetCollision()) {
            dirY = 1;
            y = game.racquet.getTopY();
            dirX = 1;
        }
        if (leftRacquetCollision()) {
            dirY = 1;
            y = game.racquet.getTopY();
            dirX = -1;
        }
        x = x + dirX;
        y = y + dirY;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    private boolean rightRaquetCollision() {
        return game.raquet.getRightBounds().intersects(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

    private boolean rightRacquetCollision() {
        return game.racquet.getRightBounds().intersects(getBounds());
    }

    private boolean leftRaquetCollision() {
        return game.raquet.getLeftBounds().intersects(getBounds());
    }

    private boolean leftRacquetCollision() {
        return game.racquet.getLeftBounds().intersects(getBounds());
    }

    private boolean midRaquetCollision() {
        return game.raquet.getMidBounds().intersects(getBounds());
    }

    private boolean midRacquetCollision() {
        return game.racquet.getMidBounds().intersects(getBounds());
    }
}