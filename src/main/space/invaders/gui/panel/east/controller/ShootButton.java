package main.space.invaders.gui.panel.east.controller;

import main.space.invaders.utils.FileLoader;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ShootButton extends JButton {

    public ShootButton() {
        ImageIcon icon = new ImageIcon(FileLoader.loadImage("gui/space_key"));
        this.setIcon(icon);
        this.setBackground(SwingDistributor.GUI_COLOR);
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.addActionListener(e -> DataDistributor.getSpaceship().fireMissile());
    }
}
