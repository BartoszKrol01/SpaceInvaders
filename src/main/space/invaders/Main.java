package main.space.invaders;

import main.space.invaders.utils.MobsLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Mob> mobs = MobsLoader.loadMobs();
        GamePanel gamePanel = new GamePanel(mobs);
        FramePanel framePanel = new FramePanel(gamePanel);
        new GameFrame(framePanel);
        new Thread(gamePanel).start();
    }
}