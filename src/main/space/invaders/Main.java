package main.space.invaders;

import main.space.invaders.animator.MissileAnimator;
import main.space.invaders.animator.MobAnimator;
import main.space.invaders.gui.frame.GameFrame;
import main.space.invaders.gui.panel.FramePanel;
import main.space.invaders.gui.popup.EnterPlayerNickPopup;

public class Main {
    public static void main(String[] args) {
        //ask for player name
        new EnterPlayerNickPopup();

        //create GUI interface
        new GameFrame(new FramePanel());

        //create animation thread
        new MobAnimator();
        new MissileAnimator();
    }
}