package main.space.invaders.gui.panel.east.settings;

import main.space.invaders.utils.FileLoader;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SettingsButton extends JButton {

    public SettingsButton() {
        ImageIcon icon = new ImageIcon(FileLoader.loadImage("gui/settings"));
        this.setIcon(icon);
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setBackground(SwingDistributor.GUI_COLOR);
    }
}
