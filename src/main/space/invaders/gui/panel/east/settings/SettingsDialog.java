package main.space.invaders.gui.panel.east.settings;

import main.space.invaders.gui.panel.east.settings.slider.SettingsSlider;
import main.space.invaders.gui.panel.east.settings.slider.SliderFunction;
import main.space.invaders.utils.SwingUtils;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import static main.space.invaders.settings.service.MobSleepTimeService.MOB_SLEEP_TIME_DEFAULT;
import static main.space.invaders.settings.service.MobsInOneRowCountService.MOBS_IN_ONE_ROW_COUNT_DEFAULT;
import static main.space.invaders.settings.service.NumberOfMobRowsService.NUMBER_OF_MOB_ROWS_DEFAULT;

public class SettingsDialog extends JDialog {
    //todo: increase number of mob columns then decrease, mobs ignore side steps

    public SettingsDialog() {
        this.setVisible(false);
        this.setLocationRelativeTo(null);

        JPanel panel = initializePanel();
        GridBagConstraints c = new GridBagConstraints();

        SettingsLabel rowsOfEnemiesLabel = new SettingsLabel("Rows of enemies");
        SettingsSlider rowsOfEnemiesSlider = new SettingsSlider(JSlider.HORIZONTAL,
                3,
                13,
                NUMBER_OF_MOB_ROWS_DEFAULT,
                1,
                SliderFunction.NUMBER_OF_MOB_ROWS);

        SettingsLabel enemiesInRowLabel = new SettingsLabel("Enemies in row");
        SettingsSlider enemiesInRowSlider = new SettingsSlider(JSlider.HORIZONTAL,
                7,
                31,
                MOBS_IN_ONE_ROW_COUNT_DEFAULT,
                4,
                SliderFunction.MOBS_IN_ONE_ROW);

        SettingsLabel enemiesStepIntervalLabel = new SettingsLabel("Enemies step interval");
        SettingsSlider enemiesStepIntervalSlider = new SettingsSlider(JSlider.HORIZONTAL,
                0,
                200,
                MOB_SLEEP_TIME_DEFAULT,
                50,
                SliderFunction.MOB_SLEEP_TIME);

        SettingsLabel fixedTimeLabel = new SettingsLabel("Fixed time");
        FixedTimeCheckBox fixedTimeCheckBox = new FixedTimeCheckBox(enemiesStepIntervalSlider, enemiesStepIntervalLabel);

        SettingsLabel specialModeLabel = new SettingsLabel("Special mode");
        JCheckBox specialModeCheckBox = new JCheckBox();
        specialModeCheckBox.setBackground(SwingUtils.GUI_COLOR);

        c.insets = new Insets(30, 30, 0, 30);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(rowsOfEnemiesLabel, c);

        c.gridx = 1;
        panel.add(rowsOfEnemiesSlider, c);

        c.insets = new Insets(10, 30, 0, 30);
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

        c.gridx = 0;
        c.gridy = 3;
        panel.add(fixedTimeLabel, c);

        c.gridx = 1;
        panel.add(fixedTimeCheckBox, c);

        c.insets = new Insets(10, 30, 30, 30);
        c.gridx = 0;
        c.gridy = 4;
        panel.add(specialModeLabel, c);

        c.gridx = 1;
        panel.add(specialModeCheckBox, c);

        this.pack();
    }

    private JPanel initializePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(SwingUtils.GUI_COLOR);
        this.add(panel);
        panel.setLayout(new GridBagLayout());
        return panel;
    }
}
