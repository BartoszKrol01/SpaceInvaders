package main.space.invaders.gui.panel.active.player;

import javax.swing.JPanel;
import java.awt.Color;

public class ActivePlayerPanel extends JPanel {

    public ActivePlayerPanel() {
        this.setBackground(new Color(16, 18, 16));
        this.add(new ChangeSpaceshipButton());
        this.add(new PlayerNickButton());
    }
}
