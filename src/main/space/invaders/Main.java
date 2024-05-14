package main.space.invaders;

import main.space.invaders.utils.MobsLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Drawable> drawable = MobsLoader.loadDrawable();
        drawable.add(Spaceship.getSpaceship());
        GamePanel gamePanel = new GamePanel(drawable);
        FramePanel framePanel = new FramePanel(gamePanel);
        new GameFrame(framePanel);
        MobAnimator mobAnimator = new MobAnimator(gamePanel);
        Spaceship.getSpaceship().setParentPanel(gamePanel);

        new Thread(mobAnimator).start();
    }
}