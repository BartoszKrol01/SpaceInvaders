package main.space.invaders.gui.panel.east.controller;

import main.space.invaders.animator.PauseService;
import main.space.invaders.utils.FileLoader;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PauseButton extends JButton {

    private final ImageIcon pause;
    private final ImageIcon play;
    private ImageIcon currentImage;

    public PauseButton() {
        this.pause = new ImageIcon(FileLoader.loadImage("gui/pause"));
        this.play = new ImageIcon(FileLoader.loadImage("gui/play"));
        currentImage = pause;
        this.setIcon(currentImage);
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setBackground(SwingDistributor.GUI_COLOR);
        this.addActionListener(e -> {
            PauseService.pauseOrUnpauseTheGame();
            changeIcon();
        });
    }

    private void changeIcon() {
        currentImage = currentImage.equals(play) ? pause : play;
        this.setIcon(currentImage);
    }
}
