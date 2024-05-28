package main.space.invaders.gui.panel.east.controller;

import main.space.invaders.animator.PauseService;
import main.space.invaders.utils.SwingUtils;
import main.space.invaders.utils.file.FileLoader;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import static main.space.invaders.utils.SwingUtils.customizeJButton;

public class PauseButton extends JButton implements Runnable {

    private final ImageIcon pause;
    private final ImageIcon play;

    public PauseButton() {
        this.pause = new ImageIcon(FileLoader.loadImage("gui/pause"));
        this.play = new ImageIcon(FileLoader.loadImage("gui/play"));
        customizeJButton(this);
        this.setBackground(SwingUtils.GUI_COLOR);
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
