package main.space.invaders;

import main.space.invaders.utils.MobsLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Drawable> mobs = MobsLoader.loadDrawable();
        GamePanel gamePanel = new GamePanel(mobs);
        FramePanel framePanel = new FramePanel(gamePanel);
        new GameFrame(framePanel);
        MobAnimator mobAnimator = new MobAnimator(gamePanel);
        new Thread(mobAnimator).start();
    }
}