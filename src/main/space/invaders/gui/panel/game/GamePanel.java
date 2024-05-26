package main.space.invaders.gui.panel.game;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.settings.GameDisplay;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
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
        updateFrameIfNecessary();
        for (Drawable drawable : DataDistributor.getDrawables()) {
            drawable.draw(g);
        }
    }

    private void updateFrameIfNecessary() {
        Dimension preferredSize = getPreferredSize();
        Dimension realSize = getSize();
        if (preferredSize.width > realSize.width || preferredSize.height > realSize.height) {
            SwingUtilities.updateComponentTreeUI(SwingDistributor.getGameFrame());
            SwingDistributor.getGameFrame().pack();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return GameDisplay.getGameDimension();
    }
}
