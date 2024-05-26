package main.space.invaders.gui.panel.east.settings;

import main.space.invaders.utils.SwingUtils;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class SettingsPanel extends JPanel {

    public SettingsPanel() {
        this.setBackground(SwingUtils.GUI_COLOR);
        this.setLayout(new GridLayout(4, 1));

        SettingsButton settingsButton = new SettingsButton();
        RetryButton retryButton = new RetryButton();

        this.add(new JLabel());
        this.add(new JLabel());
        this.add(settingsButton);
        this.add(retryButton);
    }
}
