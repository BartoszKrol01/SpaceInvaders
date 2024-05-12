package main.space.invaders;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private static final int PREFERRED_WIDTH = 1024;
    private static final int PREFERRED_HEIGHT = 780;
    private Mob middle;


    public GamePanel(Mob middle) {
        this.setBackground(Color.BLACK);
        System.out.println("Panel black");
        this.middle = middle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        middle.drawImage(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            middle.changeImage();
            repaint();
        }
    }
}
