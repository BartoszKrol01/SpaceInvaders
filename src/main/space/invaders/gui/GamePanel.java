package main.space.invaders.gui;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.utils.Distributor;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GamePanel extends JPanel {

    public GamePanel() {
        this.setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        try {
        for (Drawable drawable : Distributor.getDrawables()) {
            drawable.draw(g);
        }
//        } catch (ConcurrentModificationException e) {
//            System.err.println("Concurrent Modification of drawable in GamePanel");
//        }
    }

    @Override
    public Dimension getPreferredSize() {
        return GameDisplayConstants.getGameDimension();
    }
}
