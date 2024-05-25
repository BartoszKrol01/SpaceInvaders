package main.space.invaders.animator;

import main.space.invaders.drawable.shootable.mob.model.Mob;
import main.space.invaders.gui.popup.GameEndPopup;
import main.space.invaders.settings.service.MobSleepTimeService;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.distribution.SwingDistributor;

import java.util.Objects;
import java.util.Random;

import static main.space.invaders.settings.Mob.FIRST_MOB_POSSIBLE_STEPS_DOWN;
import static main.space.invaders.settings.Mob.MOB_POSSIBLE_STEPS_SIDE;
import static main.space.invaders.settings.Mob.MOB_STEP_SIZE;
import static main.space.invaders.settings.Mob.TOTAL_MOB_SIZE;
import static main.space.invaders.settings.Mob.TOTAL_NUMBER_OF_MOBS;
import static main.space.invaders.settings.service.MobSleepTimeService.MOB_SLEEP_TIME_DEFAULT;

public class MobAnimator extends Animator {

    private static final int FIRE_MISSILE_PROBABILITY_PER_MILLE = 50;
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
                    }
                    changeImage(mob);
                    tryToFireMissile(mob); //todo: firing missile shouldn't be dependent on sleep time
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

    private static void tryToFireMissile(Mob mob) {
        Random random = new Random();
        if (random.nextInt(1000) <= FIRE_MISSILE_PROBABILITY_PER_MILLE) {
            mob.fireMissile();
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
