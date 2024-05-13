package main.space.invaders;

import javax.swing.*;
import java.awt.*;

public class FramePanel extends JPanel {

    private static final int PREFERRED_WIDTH = 1024;
    private static final int PREFERRED_HEIGHT = 780;

    public FramePanel(GamePanel gamePanel) {
        this.setBackground(Color.DARK_GRAY);
        this.add(gamePanel);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
    }
}
