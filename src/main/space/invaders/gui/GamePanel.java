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
        this.add(Distributor.getRealTimePointsLabel());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable drawable : Distributor.getDrawables()) {
            drawable.draw(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return GameDisplayConstants.getGameDimension();
    }
}
