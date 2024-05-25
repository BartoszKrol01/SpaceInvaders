package main.space.invaders.animator;

import main.space.invaders.drawable.shootable.mob.model.Mob;
import main.space.invaders.gui.popup.GameEndPopup;
import main.space.invaders.settings.service.MobSleepTimeService;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.distribution.SwingDistributor;

import java.util.Objects;

import static main.space.invaders.settings.Mob.FIRST_MOB_POSSIBLE_STEPS_DOWN;
import static main.space.invaders.settings.Mob.MOB_POSSIBLE_STEPS_SIDE;
import static main.space.invaders.settings.Mob.MOB_STEP_SIZE;
import static main.space.invaders.settings.Mob.TOTAL_MOB_SIZE;
import static main.space.invaders.settings.Mob.TOTAL_NUMBER_OF_MOBS;
import static main.space.invaders.settings.service.MobSleepTimeService.MOB_SLEEP_TIME_DEFAULT;

public class MobAnimator extends Animator {

    private long sleepTime;

    public MobAnimator() {
        super();
        this.sleepTime = MOB_SLEEP_TIME_DEFAULT;
    }

    @Override
    public void run() {//todo: after restart mobs stay in the same location for a minute
        while (PauseService.isRunning()) {
            if (!DataDistributor.getMobs().isEmpty()) {
                for (Mob mob : DataDistributor.getMobs()) {
                    sleepTime = getSleepTime();
                    if (PauseService.gamePaused()) {
                        pauseAnimation();
                    }
                    changeImage(mob);
                    sleepTryCatch(sleepTime);
                    SwingDistributor.getGamePanel().repaint();
                }
            } else {
                new GameEndPopup(true);
            }
        }
    }

    private long getSleepTime() {
        if (MobSleepTimeService.isMobSleepTimeFixed()) {
            return MobSleepTimeService.getMobsSleepTime();
        } else {
            return MOB_SLEEP_TIME_DEFAULT - (TOTAL_NUMBER_OF_MOBS - DataDistributor.getMobs().size());
        }
    }

    private static void changeImage(Mob mob) {
        if (Objects.equals(mob.getCurrentImage(), mob.getStay())) {
            mob.setCurrentImage(mob.getGo());
        } else {
            mob.setCurrentImage(mob.getStay());
        }
        updateLocation(mob);
    }

    private static void updateLocation(Mob mob) { //todo: mob step down should happen if mob is at the border of game panel
        if (mob.getHorizontalStepsCounter() >= MOB_POSSIBLE_STEPS_SIDE) {
            mob.setHorizontalStepsCounter(0);
            mob.setYLocation(mob.getYLocation() + TOTAL_MOB_SIZE);
            mob.setVerticalStepsCounter(mob.getVerticalStepsCounter() + 1);
            checkIfGameIsOver(mob);
            mob.setDirection(mob.getDirection() * -1);
        } else {
            mob.setXLocation(mob.getXLocation() + (mob.getDirection() * MOB_STEP_SIZE));
            mob.setHorizontalStepsCounter(mob.getHorizontalStepsCounter() + 1);
        }
    }

    private static void checkIfGameIsOver(Mob mob) {
        if (mob.getVerticalStepsCounter() >= FIRST_MOB_POSSIBLE_STEPS_DOWN + mob.getStartRow()) {
            DataDistributor.getMobs().forEach(m -> m.setVerticalStepsCounter(0));
            new GameEndPopup(false);
        }
    }

}
