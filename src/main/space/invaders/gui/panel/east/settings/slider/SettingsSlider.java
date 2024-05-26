package main.space.invaders.gui.panel.east.settings.slider;

import main.space.invaders.settings.service.MobSleepTimeService;
import main.space.invaders.settings.service.NumberOfMobRowsService;
import main.space.invaders.settings.service.SettingsService;
import main.space.invaders.utils.SwingUtils;

import javax.swing.JSlider;
import java.awt.Font;

public class SettingsSlider extends JSlider {

    public SettingsSlider(int orientation, int min, int max, int value, int majorTickSpacing, SliderFunction sliderFunction) {
        super(orientation, min, max, value);
        SwingUtils.setFontAndForegroundColor(this);
        this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        this.setMajorTickSpacing(majorTickSpacing);
        this.setPaintLabels(true);
        this.setPaintTicks(true);
        this.setBackground(SwingUtils.GUI_COLOR);
        addChangeListener(sliderFunction);
    }

    private void addChangeListener(SliderFunction sliderFunction) {
        this.addChangeListener(e -> {
            int changeValue = this.getValue();
            switch (sliderFunction) {
                case MOB_SLEEP_TIME -> MobSleepTimeService.modifyMobSleepTime(changeValue);
                case MOBS_IN_ONE_ROW -> SettingsService.modifyMobsInOneRowCount(changeValue);
                case NUMBER_OF_MOB_ROWS -> NumberOfMobRowsService.modifyNumberOfMobRows(changeValue);
            }
        });
    }
}
