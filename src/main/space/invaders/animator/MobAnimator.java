package main.space.invaders.animator;

import main.space.invaders.drawable.shootable.mob.model.Mob;
import main.space.invaders.gui.popup.GameEndPopup;
import main.space.invaders.settings.service.MobSleepTimeService;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.distribution.SwingDistributor;

import java.util.Objects;

import static main.space.invaders.settings.MobDisplay.MOB_SIZE;
import static main.space.invaders.settings.MobDisplay.MOB_STEP_SIZE;
import static main.space.invaders.settings.MobDisplay.TOTAL_MOB_SIZE;
import static main.space.invaders.settings.service.MobSleepTimeService.MOB_SLEEP_TIME_DEFAULT;

public class MobAnimator extends Animator {

    private long sleepTime;

    public MobAnimator() {
        super();
        this.sleepTime = MOB_SLEEP_TIME_DEFAULT;
    }

    @Override
    public void run() {
        while (PauseService.isRunning()) {
            if (!DataDistributor.getMobs().isEmpty()) {
                for (Mob mob : DataDistributor.getMobs()) {
                    sleepTime = getSleepTime();
                    if (PauseService.gamePaused()) {
                        pauseAnimation();
                        break;
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
            return (long) (Math.log(Math.pow(DataDistributor.getMobs().size(), 5)) + 3);
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

    private static void updateLocation(Mob mob) {
        if (shouldMoveDownMobs(mob)) {
            DataDistributor.getMobs()
                    .forEach(Mob::performStepDown);
        } else {
            mob.setJustMovedDown(false);
            mob.setXLocation(mob.getXLocation() + (mob.getDirection() * MOB_STEP_SIZE));
        }
    }

    private static boolean shouldMoveDownMobs(Mob mob) {
        return (mob.getXLocation() - MOB_STEP_SIZE < 0 ||
                mob.getXLocation() + MOB_SIZE + MOB_STEP_SIZE > SwingDistributor.getGamePanel().getSize().width) &&
                !mob.justMovedDown();
    }

    public static void moveMobDown(Mob mob) {
        mob.setYLocation(mob.getYLocation() + TOTAL_MOB_SIZE);
        mob.setDirection(mob.getDirection() * -1);
        mob.setJustMovedDown(true);
        checkIfGameIsOver(mob);
    }

    private static void checkIfGameIsOver(Mob mob) {
        if (mob.getYLocation() >= DataDistributor.getSpaceship().getYLocation() && !PauseService.gamePaused()) {
            new GameEndPopup(false);
        }
    }

}
