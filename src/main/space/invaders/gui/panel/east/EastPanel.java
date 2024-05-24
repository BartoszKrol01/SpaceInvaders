package main.space.invaders.gui.panel.east;

import main.space.invaders.gui.panel.east.controller.ControllerPanel;
import main.space.invaders.gui.panel.east.settings.SettingsPanel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Color;

public class EastPanel extends JPanel {

    public EastPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel difficultyPanel = new JPanel();
        difficultyPanel.setBackground(Color.BLUE);
        SettingsPanel settingsPanel = new SettingsPanel();
        ControllerPanel controllerPanel = new ControllerPanel();
        this.add(difficultyPanel);
        this.add(settingsPanel);
        this.add(controllerPanel);
    }
}
