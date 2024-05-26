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

    private final JPanel gameWrapper;

    public GamePanel(JPanel gameWrapper) {
        this.setBackground(Color.BLACK);
        this.gameWrapper = gameWrapper;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        SwingUtilities.updateComponentTreeUI(SwingDistributor.getCenterPanel());
        for (Drawable drawable : DataDistributor.getDrawables()) {
            drawable.draw(g);
        }
    }

    public void updateFrameIfNecessary() {
        Dimension preferredSize = getPreferredSize();
        Dimension maxSize = gameWrapper.getSize();
        if (preferredSize.width > maxSize.width || preferredSize.height > maxSize.height) {
            SwingUtilities.updateComponentTreeUI(SwingDistributor.getGameFrame());
            SwingDistributor.getGameFrame().pack();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return GameDisplay.getGameDimension();
    }
}
