package main.space.invaders.gui.panel.east.settings;

import main.space.invaders.animator.PauseService;
import main.space.invaders.utils.SwingUtils;
import main.space.invaders.utils.file.FileLoader;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import static main.space.invaders.utils.SwingUtils.customizeJButton;

public class SettingsButton extends JButton {

    private final SettingsDialog settingsDialog;

    public SettingsButton() {
        ImageIcon icon = new ImageIcon(FileLoader.loadImage("gui/settings"));
        this.setIcon(icon);
        customizeJButton(this);
        this.setBackground(SwingUtils.GUI_COLOR);
        settingsDialog = new SettingsDialog();
        this.addActionListener(e -> {
            PauseService.pauseTheGame();
            settingsDialog.setVisible(true);
        });
    }
}
