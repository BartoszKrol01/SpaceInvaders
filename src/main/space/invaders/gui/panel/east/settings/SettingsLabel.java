package main.space.invaders.gui.panel.east.settings;

import javax.swing.JLabel;

import static main.space.invaders.utils.SwingUtils.setFontAndForegroundColor;

public class SettingsLabel extends JLabel {

    public SettingsLabel(String text) {
        this.setText(text);
        setFontAndForegroundColor(this);
    }
}
