package main.space.invaders.gui.panel.east.settings;

import main.space.invaders.animator.PauseService;
import main.space.invaders.utils.SwingUtils;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class SettingsDialog extends JDialog {

    public SettingsDialog() {
        PauseService.pauseTheGame();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(SwingUtils.GUI_COLOR);
        this.add(panel);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        SettingsLabel rowsOfEnemiesLabel = new SettingsLabel("Rows of enemies");
        JSlider rowsOfEnemiesSlider = new JSlider(JSlider.HORIZONTAL, 3, 7, 5);
        rowsOfEnemiesSlider.setBackground(SwingUtils.GUI_COLOR);

        SettingsLabel enemiesInRowLabel = new SettingsLabel("Enemies in row");
        JSlider enemiesInRowSlider = new JSlider(JSlider.HORIZONTAL, 1, 15, 11);
        enemiesInRowSlider.setBackground(SwingUtils.GUI_COLOR);

        SettingsLabel enemiesStepIntervalLabel = new SettingsLabel("Enemies step interval");
        JSlider enemiesStepIntervalSlider = new JSlider(JSlider.HORIZONTAL, 1, 200, 50);
        enemiesStepIntervalSlider.setBackground(SwingUtils.GUI_COLOR);

        SettingsLabel specialModeLabel = new SettingsLabel("Special mode");
        JCheckBox specialModeCheckBox = new JCheckBox();
        specialModeCheckBox.setBackground(SwingUtils.GUI_COLOR);

        c.insets = new Insets(30, 30, 0, 0);

        c.gridx = 0;
        c.gridy = 0;
        panel.add(rowsOfEnemiesLabel, c);

        c.gridx = 1;
        panel.add(rowsOfEnemiesSlider, c);

        c.insets = new Insets(0, 30, 0, 0);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(enemiesInRowLabel, c);

        c.gridx = 1;
        panel.add(enemiesInRowSlider, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(enemiesStepIntervalLabel, c);

        c.gridx = 1;
        panel.add(enemiesStepIntervalSlider, c);

        c.insets = new Insets(0, 30, 30, 0);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(specialModeLabel, c);

        c.gridx = 1;
        panel.add(specialModeCheckBox, c);

        this.pack();
    }
}
