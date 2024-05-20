package main.space.invaders.gui;

import main.space.invaders.utils.Distributor;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class FramePanel extends JPanel {

    private static final int PREFERRED_WIDTH = 1024;
    private static final int PREFERRED_HEIGHT = 780;

    public FramePanel() {
        this.setBackground(Color.DARK_GRAY);
        this.add(Distributor.getGamePanel());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
    }
}
