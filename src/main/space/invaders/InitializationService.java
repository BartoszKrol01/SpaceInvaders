package main.space.invaders;

import main.space.invaders.animator.MissileAnimator;
import main.space.invaders.animator.MobAnimator;
import main.space.invaders.animator.MobShooter;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.distribution.SwingDistributor;

public class InitializationService {

    public static void startApplication() {
        SwingDistributor.initialize();
        new MobAnimator();
        new MissileAnimator();
        new MobShooter();
        DataDistributor.populateData();
        DataDistributor.getAnimators().forEach(a -> new Thread(a).start());
    }

    private InitializationService() {}
}
