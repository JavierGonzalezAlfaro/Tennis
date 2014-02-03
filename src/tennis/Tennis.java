package tennis;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tennis extends JPanel {

    Ball ball = new Ball(this);
    Raquet raquet = new Raquet(this);
    Racquet racquet = new Racquet(this);

    public Tennis() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                raquet.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                raquet.keyPressed(e);
            }
        });
        setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        raquet.paint(g2d);
        racquet.paint(g2d);
    }

    public void gameOver(String player) {
        JOptionPane.showMessageDialog(this, "Game Over" + player, "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException {
        Tennis tennis = new Tennis();
        JFrame frame = new JFrame("Tennis");
        frame.add(tennis);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        while (true) {
            tennis.move();
            tennis.repaint();
            Thread.sleep(10);
        }
    }

    private void move() {
        ball.move();
        raquet.move();
        racquet.move();
    }
}
