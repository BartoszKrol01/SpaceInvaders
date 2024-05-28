package main.space.invaders.gui.panel.east.controller;

import main.space.invaders.animator.PauseService;
import main.space.invaders.utils.SwingUtils;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.file.FileLoader;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import static main.space.invaders.utils.SwingUtils.customizeJButton;

public class ShootButton extends JButton {

    public ShootButton() {
        ImageIcon icon = new ImageIcon(FileLoader.loadImage("gui/space_key"));
        this.setIcon(icon);
        this.setBackground(SwingUtils.GUI_COLOR);
        customizeJButton(this);
        this.addActionListener(e -> {
            if (!PauseService.gamePaused()) {
                DataDistributor.getSpaceship().fireMissile();
            }
        });
    }
}
