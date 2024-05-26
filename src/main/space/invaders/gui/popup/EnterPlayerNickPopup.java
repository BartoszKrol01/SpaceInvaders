package main.space.invaders.gui.popup;

import main.space.invaders.Player;
import main.space.invaders.animator.PauseService;
import main.space.invaders.utils.distribution.DataDistributor;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
        JTextField textField = new JTextField();
        Object[] message = {"Hey! What's your name?\n(don't worry you can change it later)", textField};

        int option = JOptionPane.showConfirmDialog(null,
                message,
                "Introducing...",
                JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION && textField.getText() != null && !textField.getText().isBlank()) {
            System.out.println("OK OPTION : " + textField.getText());
            DataDistributor.setPlayer(new Player(textField.getText()));
        } else if (DataDistributor.getPlayer() == null) {
            DataDistributor.setPlayer(new Player("guest"));
        }
    }
}
