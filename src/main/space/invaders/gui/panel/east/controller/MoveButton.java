package main.space.invaders.gui.panel.east.controller;

import main.space.invaders.KeyEventMapped;
import main.space.invaders.MoveService;
import main.space.invaders.utils.FileLoader;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MoveButton extends JButton {

    private static final String PATH_FILE_PREFIX = "gui/";

    public MoveButton(KeyEventMapped keyEvent) {
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setBackground(SwingDistributor.GUI_COLOR);
        String filePath = PATH_FILE_PREFIX + (keyEvent == KeyEventMapped.LEFT ? "left" : "right");
        ImageIcon icon = new ImageIcon(FileLoader.loadImage(filePath));
        this.setIcon(icon);
        this.addActionListener(e -> {
            int changeValue = MoveService.handleButtonClicked(keyEvent);
            DataDistributor.getSpaceship().changeSpaceshipLocation(changeValue);
        });
    }
}
