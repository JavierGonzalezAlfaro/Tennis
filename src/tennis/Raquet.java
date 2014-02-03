package tennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Raquet {

    int x = 170;
    int dirX = 0;
    private Tennis game;
    private static final int Y = 330;
    private static final int WITH = 60;
    private static final int HEIGHT = 10;

    public Raquet(Tennis game) {
        this.game = game;
    }

    public void move() {
        if (x + dirX > 0 && x + dirX < game.getWidth() - 60) {
            x = x + dirX;
        }
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WITH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        dirX = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dirX = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dirX = 1;
        }
    }

    public Rectangle getRightBounds() {
        return new Rectangle(x+5+WITH/2, Y, (WITH/2)-5, HEIGHT);
    }
    public Rectangle getLeftBounds() {
        return new Rectangle(x, Y, (WITH/2)-5, HEIGHT);
    }
    public Rectangle getMidBounds() {
        return new Rectangle(x+(WITH/2)-5, Y, 10, HEIGHT);
    }

    public int getTopY() {
        return Y - HEIGHT;
    }
}