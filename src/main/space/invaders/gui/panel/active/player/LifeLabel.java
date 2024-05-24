package main.space.invaders.gui.panel.active.player;

import javax.swing.JButton;
import java.awt.Color;

public class LifeLabel extends JButton {

    public LifeLabel() {
        this.setFocusable(false);
        this.setEnabled(false);
        this.setBorderPainted(true);
        this.setBackground(Color.GREEN);
    }
}
