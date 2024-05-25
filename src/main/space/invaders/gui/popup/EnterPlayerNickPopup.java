package main.space.invaders.gui.popup;

import main.space.invaders.Player;
import main.space.invaders.animator.PauseService;
import main.space.invaders.utils.distribution.DataDistributor;

import javax.swing.JOptionPane;

public class EnterPlayerNickPopup {

    public EnterPlayerNickPopup(boolean shouldPauseTheGame) {
        if (shouldPauseTheGame) {
            showEnterNameDialogAndSavePlayerWithPauseUnPause();
        } else {
            showEnterNameDialogAndSavePlayer();
        }
    }

    private static void showEnterNameDialogAndSavePlayerWithPauseUnPause() {
        PauseService.pauseTheGame();
        showEnterNameDialogAndSavePlayer();
        PauseService.unpauseTheGame();
    }

    private static void showEnterNameDialogAndSavePlayer() {
        String name = JOptionPane.showInputDialog("Hey! What's your name?\n(don't worry you can change it later)");
        if (name == null || name.isBlank()) {
            name = "guest";
        }
        DataDistributor.setPlayer(new Player(name));
    }
}
