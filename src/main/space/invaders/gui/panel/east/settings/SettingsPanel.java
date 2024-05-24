package main.space.invaders.gui.panel.east.settings;

import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.JPanel;

public class SettingsPanel extends JPanel {

    public SettingsPanel() {
        this.setBackground(SwingDistributor.GUI_COLOR);
        this.add(new RetryButton());
    }
}
