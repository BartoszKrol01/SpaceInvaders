package main.space.invaders;

import main.space.invaders.animator.MissileAnimator;
import main.space.invaders.animator.MobAnimator;
import main.space.invaders.animator.MobShooter;
import main.space.invaders.utils.distribution.DataDistributor;

public class InitializationService {

    public static void startApplication() {
        new MobAnimator();
        new MissileAnimator();
        new MobShooter();
        DataDistributor.populateData();
        DataDistributor.getAnimators().forEach(a -> new Thread(a).start());
    }

    private InitializationService() {}
}
