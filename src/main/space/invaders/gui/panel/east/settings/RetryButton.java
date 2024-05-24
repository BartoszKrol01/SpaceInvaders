package main.space.invaders.gui.panel.east.settings;

import main.space.invaders.animator.PauseService;
import main.space.invaders.utils.FileLoader;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RetryButton extends JButton {

    public RetryButton() {
        ImageIcon icon = new ImageIcon(FileLoader.loadImage("gui/retry"));
        this.setIcon(icon);
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setBackground(SwingDistributor.GUI_COLOR);
        this.addActionListener(e -> {
            PauseService.pauseTheGame();
            PauseService.restartTheGame();
        });
    }
}
