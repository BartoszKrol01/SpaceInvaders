package main.space.invaders.gui.panel.east.controller;

import main.space.invaders.animator.PauseService;
import main.space.invaders.animator.key.listener.KeyEventMapped;
import main.space.invaders.animator.key.listener.MoveService;
import main.space.invaders.utils.SwingUtils;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.file.FileLoader;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import static main.space.invaders.utils.SwingUtils.customizeJButton;

public class MoveButton extends JButton {

    private static final String PATH_FILE_PREFIX = "gui/";

    public MoveButton(KeyEventMapped keyEvent) {
        customizeJButton(this);
        this.setBackground(SwingUtils.GUI_COLOR);
        String filePath = PATH_FILE_PREFIX + (keyEvent == KeyEventMapped.LEFT ? "left" : "right");
        ImageIcon icon = new ImageIcon(FileLoader.loadImage(filePath));
        this.setIcon(icon);
        this.addActionListener(e -> {
            if (!PauseService.gamePaused()) {
                int changeValue = MoveService.handleButtonClicked(keyEvent);
                DataDistributor.getSpaceship().changeSpaceshipLocation(changeValue);
            }
        });
    }
}
