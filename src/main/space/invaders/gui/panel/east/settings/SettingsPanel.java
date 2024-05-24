package main.space.invaders.gui.panel.east.settings;

import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class SettingsPanel extends JPanel {

    public SettingsPanel() {
        this.setBackground(SwingDistributor.GUI_COLOR);
        this.setLayout(new GridLayout(2, 1));

        SettingsButton settingsButton = new SettingsButton();
        RetryButton retryButton = new RetryButton();

        this.add(settingsButton);
        this.add(retryButton);
    }
}
