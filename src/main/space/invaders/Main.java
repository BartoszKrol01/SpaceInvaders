package main.space.invaders;

import main.space.invaders.animator.PauseService;
import main.space.invaders.gui.frame.GameFrame;
import main.space.invaders.gui.panel.FramePanel;
import main.space.invaders.gui.popup.EnterPlayerNickPopup;
import main.space.invaders.utils.distribution.SwingDistributor;

public class Main {
    //todo: missiles should be faster
    //todo: reduce number of lives
    public static void main(String[] args) throws InterruptedException {
        //ask for player name
        new EnterPlayerNickPopup(false);

        //create user interface
        new GameFrame(new FramePanel());

        //start threads and populate data
        InitializationService.startApplication();

        //make sure that panel painted all of drawables
        SwingDistributor.getGamePanel().repaint();

        //pause the game
        PauseService.pauseTheGame();
    }
}