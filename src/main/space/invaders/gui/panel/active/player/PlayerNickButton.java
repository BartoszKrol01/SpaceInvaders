package main.space.invaders.gui.panel.active.player;

import main.space.invaders.gui.EnterPlayerNickPopup;
import main.space.invaders.utils.Distributor;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class PlayerNickButton extends JButton {

    private static final String TEXT_PREFIX = "Player: ";

    public PlayerNickButton(Color parentColor) {
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        this.setForeground(Color.GREEN);
        this.setBackground(parentColor);
        updatePlayerNick();
        this.addActionListener(e -> {
            new EnterPlayerNickPopup();
            updatePlayerNick();
        });
    }

    public void updatePlayerNick() {
        String name = Distributor.getPlayer().name();
        this.setText(TEXT_PREFIX + name);
    }
}
