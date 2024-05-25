package main.space.invaders.gui.panel.east.settings;

import main.space.invaders.settings.service.MobSleepTimeService;
import main.space.invaders.utils.SwingUtils;

import javax.swing.JCheckBox;

public class FixedTimeCheckBox extends JCheckBox {

    private final static String TOOL_TIP_TEXT = "If unchecked enemies will move faster as their number decreases";

    public FixedTimeCheckBox() {
        this.setBackground(SwingUtils.GUI_COLOR);
        this.setToolTipText(TOOL_TIP_TEXT);
        this.addActionListener(e -> MobSleepTimeService.changeFixedMobSleepTimeFlag());
    }
}
