package main.space.invaders.gui.panel.east.settings;

import main.space.invaders.animator.PauseService;
import main.space.invaders.gui.panel.east.settings.slider.SettingsSlider;
import main.space.invaders.settings.service.MobSleepTimeService;
import main.space.invaders.utils.SwingUtils;

import javax.swing.JCheckBox;

public class FixedTimeCheckBox extends JCheckBox {

    private final static String TOOL_TIP_TEXT = "If unchecked enemies will move faster as their number decreases";

    public FixedTimeCheckBox(SettingsSlider slider, SettingsLabel enemiesStepIntervalLabel) {
        this.setBackground(SwingUtils.GUI_COLOR);
        this.setSelected(true);
        this.setToolTipText(TOOL_TIP_TEXT);
        this.addActionListener(e -> {
            MobSleepTimeService.changeMobSleepTimeFixedFlag();
            slider.setVisible(this.isSelected());
            SwingUtils.setForegroundDisabled(enemiesStepIntervalLabel, this.isSelected());
            PauseService.restartTheGame();
        });
    }
}
