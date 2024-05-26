package main.space.invaders;

import main.space.invaders.animator.PauseService;
import main.space.invaders.gui.popup.EnterPlayerNickPopup;
import main.space.invaders.utils.distribution.SwingDistributor;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //ask for player name
        new EnterPlayerNickPopup(false);

        //create user interface, start threads and populate data
        InitializationService.startApplication();

        //make sure that panel painted all of drawables
        SwingDistributor.getGamePanel().repaint();

        //pause the game
        PauseService.pauseTheGame();
    }
}