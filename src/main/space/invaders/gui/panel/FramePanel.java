package main.space.invaders.gui.panel;

import main.space.invaders.gui.panel.east.EastPanel;
import main.space.invaders.gui.panel.game.CenterPanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class FramePanel extends JPanel {

    public FramePanel() {
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout());
        this.add(new ScoreBoardPanel(), BorderLayout.WEST);
        this.add(new EastPanel(), BorderLayout.EAST);
        this.add(new CenterPanel(), BorderLayout.CENTER);
    }
}
