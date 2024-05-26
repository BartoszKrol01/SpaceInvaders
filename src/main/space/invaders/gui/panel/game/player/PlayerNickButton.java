package main.space.invaders.gui.panel.game.player;

import main.space.invaders.gui.popup.EnterPlayerNickPopup;
import main.space.invaders.utils.SwingUtils;
import main.space.invaders.utils.distribution.DataDistributor;

import javax.swing.JButton;

import static main.space.invaders.utils.SwingUtils.customizeJButton;
import static main.space.invaders.utils.SwingUtils.setFontAndForegroundColor;

public class PlayerNickButton extends JButton {

    private static final String TEXT_PREFIX = "Player: ";

    public PlayerNickButton() {
        customizeJButton(this);
        setFontAndForegroundColor(this);
        this.setBackground(SwingUtils.GUI_COLOR);
        updatePlayerNick();
        this.addActionListener(e -> {
            new EnterPlayerNickPopup(true);
            updatePlayerNick();
        });
    }

    public void updatePlayerNick() {
        String name = DataDistributor.getPlayer().name();
        this.setText(TEXT_PREFIX + name);
    }
}
