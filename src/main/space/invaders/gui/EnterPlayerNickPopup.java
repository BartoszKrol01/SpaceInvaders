package main.space.invaders.gui;

import main.space.invaders.Player;
import main.space.invaders.animator.PauseService;
import main.space.invaders.utils.distribution.DataDistributor;

import javax.swing.JOptionPane;

public class EnterPlayerNickPopup {

    public EnterPlayerNickPopup() {
        PauseService.pauseTheGame();
        String name = JOptionPane.showInputDialog("Hey! What's your name?\n(don't worry you can change it later)");
        if (name == null || name.isBlank()) {
            name = "guest";
        }
        DataDistributor.setPlayer(new Player(name));
        PauseService.unpauseTheGame();
    }
}
