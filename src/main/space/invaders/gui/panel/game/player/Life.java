package main.space.invaders.gui.panel.game.player;

import javax.swing.JButton;
import java.awt.Color;

import static main.space.invaders.utils.SwingUtils.customizeJButton;

public class Life extends JButton {

    public Life() {
        customizeJButton(this);
        this.setBorderPainted(true);
        this.setBackground(Color.GREEN);
    }
}
