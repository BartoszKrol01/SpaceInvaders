package main.space.invaders.drawable.mob;

import main.space.invaders.PauseService;
import main.space.invaders.drawable.mob.model.Mob;
import main.space.invaders.utils.Distributor;

import java.util.Objects;

import static main.space.invaders.gui.GameDisplayConstants.FIRST_MOB_POSSIBLE_STEPS_DOWN;
import static main.space.invaders.gui.GameDisplayConstants.MOB_POSSIBLE_STEPS_SIDE;
import static main.space.invaders.gui.GameDisplayConstants.MOB_STEP_SIZE;
import static main.space.invaders.gui.GameDisplayConstants.TOTAL_MOB_SIZE;
import static main.space.invaders.utils.ThreadUtils.sleep;

public class MobAnimator implements Runnable {

    public MobAnimator() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!PauseService.gamePaused()) {
            for (Mob mob : Distributor.getMobs()) {
                changeImage(mob);
                sleep(30);
                Distributor.getGamePanel().repaint();
            }
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
            System.out.println("I've won - x -> " + mob.getXLocation() + " y -> " + mob.getYLocation());
            System.out.println("GAME OVER!!!!!");
            PauseService.setIsGamePaused(true);
            throw new RuntimeException();
            //todo: handle win
        }
    }

}
