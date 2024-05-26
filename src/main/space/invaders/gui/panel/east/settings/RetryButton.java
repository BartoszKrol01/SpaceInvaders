package main.space.invaders.gui.panel.east.settings;

import main.space.invaders.animator.PauseService;
import main.space.invaders.utils.FileLoader;
import main.space.invaders.utils.SwingUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import static main.space.invaders.utils.SwingUtils.customizeJButton;

public class RetryButton extends JButton {

    public RetryButton() {
        ImageIcon icon = new ImageIcon(FileLoader.loadImage("gui/retry"));
        this.setIcon(icon);
        customizeJButton(this);
        this.setBackground(SwingUtils.GUI_COLOR);
        this.addActionListener(e -> {
            PauseService.restartTheGame();
            PauseService.pauseTheGame();
        });
    }
}
