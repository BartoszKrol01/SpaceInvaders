package main.space.invaders;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.Spaceship;
import main.space.invaders.drawable.mob.MobAnimator;
import main.space.invaders.drawable.mob.MobsLoader;
import main.space.invaders.gui.FramePanel;
import main.space.invaders.gui.GamePanel;
import main.space.invaders.gui.frame.GameFrame;

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