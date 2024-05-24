package main.space.invaders.gui.panel.game;

import main.space.invaders.constants.GameDisplay;
import main.space.invaders.drawable.Drawable;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GamePanel extends JPanel {

    public GamePanel() {
        this.setBackground(Color.BLACK);
        this.add(SwingDistributor.getRealTimePointsLabel());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable drawable : DataDistributor.getDrawables()) {
            drawable.draw(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return GameDisplay.getGameDimension();
    }
}
