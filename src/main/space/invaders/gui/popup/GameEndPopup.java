package main.space.invaders.gui.popup;

import main.space.invaders.animator.PauseService;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.JOptionPane;

public class GameEndPopup {

    public GameEndPopup(boolean win) {
        PauseService.pauseTheGame();
        String message = createMessage(win);
        JOptionPane.showMessageDialog(SwingDistributor.getGamePanel(), message);
        PauseService.restartTheGame();
    }

    private String createMessage(boolean win) {
        return win ? "Congratulations, you have won !" : "Looser !";
    }
}
