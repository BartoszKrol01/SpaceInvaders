package main.space.invaders.gui.panel.game.player;

import main.space.invaders.gui.popup.EnterPlayerNickPopup;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class PlayerNickButton extends JButton {

    private static final String TEXT_PREFIX = "Player: ";

    public PlayerNickButton() {
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        this.setForeground(Color.GREEN);
        this.setBackground(SwingDistributor.GUI_COLOR);
        updatePlayerNick();
        this.addActionListener(e -> {
            new EnterPlayerNickPopup();
            updatePlayerNick();
        });
    }

    public void updatePlayerNick() {
        String name = DataDistributor.getPlayer().name();
        this.setText(TEXT_PREFIX + name);
    }
}
