package main.space.invaders;

import main.space.invaders.utils.distribution.DataDistributor;

public class InitializationService {

    public static void startApplication() {
        DataDistributor.populateData();
        DataDistributor.getAnimators().forEach(a -> new Thread(a).start());
    }

    private InitializationService() {}
}
