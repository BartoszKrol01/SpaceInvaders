package main.space.invaders.gui.panel.game;

import main.space.invaders.gui.panel.active.player.ActivePlayerPanel;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class CenterPanel extends JPanel {

    public CenterPanel() {
        this.setLayout(new BorderLayout());
        this.add(SwingDistributor.getGamePanel(), BorderLayout.CENTER);
        this.add(new ActivePlayerPanel(), BorderLayout.SOUTH);
    }
}
