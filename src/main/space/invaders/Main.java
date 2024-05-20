package main.space.invaders;

import main.space.invaders.drawable.missile.MissileAnimator;
import main.space.invaders.drawable.shootable.mob.MobAnimator;
import main.space.invaders.gui.FramePanel;
import main.space.invaders.gui.frame.GameFrame;

public class Main {
    public static void main(String[] args) {
        //create GUI interface
        new GameFrame(new FramePanel());

        //create animation thread
        new MobAnimator();
        new MissileAnimator();
    }
}