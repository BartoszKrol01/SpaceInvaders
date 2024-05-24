package main.space.invaders.gui.panel.east.controller;

import main.space.invaders.animator.PauseService;
import main.space.invaders.utils.FileLoader;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PauseButton extends JButton implements Runnable {

    private final ImageIcon pause;
    private final ImageIcon play;

    public PauseButton() {
        this.pause = new ImageIcon(FileLoader.loadImage("gui/pause"));
        this.play = new ImageIcon(FileLoader.loadImage("gui/play"));
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setBackground(SwingDistributor.GUI_COLOR);
        this.addActionListener(e -> PauseService.pauseOrUnpauseTheGame());
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (PauseService.isRunning()) {
            if (PauseService.gamePaused()) {
                this.setIcon(play);
            } else {
                this.setIcon(pause);
            }
        }
    }
}
