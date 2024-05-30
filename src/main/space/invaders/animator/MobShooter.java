package main.space.invaders.animator;

import main.space.invaders.drawable.shootable.mob.model.Mob;
import main.space.invaders.utils.distribution.DataDistributor;

import java.util.Random;

public class MobShooter extends Animator {

    private static final int FIRE_MISSILE_PROBABILITY_PER_MILLE = 40;

    public MobShooter() {
        super();
    }

    @Override
    public void run() {
        while (PauseService.isRunning()) {
            for (Mob mob : DataDistributor.getMobs()) {
                if (PauseService.gamePaused()) {
                    pauseAnimation();
                    break;
                }
                tryToFireMissile(mob);
                sleepTryCatch(16);
            }
        }
    }

    private static void tryToFireMissile(Mob mob) {
        Random random = new Random();
        if (random.nextInt(1000) <= FIRE_MISSILE_PROBABILITY_PER_MILLE) {
            mob.fireMissile();
        }
    }
}
