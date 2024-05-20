package main.space.invaders;

import main.space.invaders.drawable.missile.MissileAnimator;
import main.space.invaders.drawable.mob.MobAnimator;
import main.space.invaders.gui.FramePanel;
import main.space.invaders.gui.frame.GameFrame;
import main.space.invaders.utils.Distributor;

public class Main {
    public static void main(String[] args) {
        //create GUI interface
        FramePanel framePanel = new FramePanel(Distributor.getGamePanel());
        new GameFrame(framePanel);

        //create animation thread
        new MobAnimator();
        new MissileAnimator();
    }
}