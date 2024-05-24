package main.space.invaders.gui.panel.game.player;

import javax.swing.JButton;
import java.awt.Color;

public class Life extends JButton {

    public Life() {
        this.setFocusable(false);
        this.setEnabled(false);
        this.setBorderPainted(true);
        this.setBackground(Color.GREEN);
    }
}
