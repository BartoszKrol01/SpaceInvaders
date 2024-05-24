package main.space.invaders.gui.panel;

import main.space.invaders.gui.panel.east.EastPanel;
import main.space.invaders.gui.panel.game.CenterPanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class FramePanel extends JPanel {

    private static final int PREFERRED_WIDTH = 1024;
    private static final int PREFERRED_HEIGHT = 780;

    public FramePanel() {
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.add(new ScoreBoardPanel(), BorderLayout.WEST);
        this.add(new EastPanel(), BorderLayout.EAST);
        this.add(new CenterPanel(), BorderLayout.CENTER);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
    }
}
