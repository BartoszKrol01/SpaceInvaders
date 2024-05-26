package main.space.invaders.gui.panel.east;

import main.space.invaders.gui.panel.east.controller.ControllerPanel;
import main.space.invaders.gui.panel.east.settings.SettingsPanel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class EastPanel extends JPanel {

    public EastPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        SettingsPanel settingsPanel = new SettingsPanel();
        ControllerPanel controllerPanel = new ControllerPanel();
        this.add(settingsPanel);
        this.add(controllerPanel);
    }
}
