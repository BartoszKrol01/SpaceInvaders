package main.space.invaders.gui.panel.game.player;

import main.space.invaders.gui.popup.GameEndPopup;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

public class ActivePlayerPanel extends JPanel {

    private static final int NUMBER_OF_LIVES = 3;
    private static int livesCounter;
    private final List<Life> lives;

    static {
        livesCounter = NUMBER_OF_LIVES;
    }

    public ActivePlayerPanel() {
        this.lives = new ArrayList<>();
        this.setBackground(SwingDistributor.GUI_COLOR);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        addComponents(c);
    }

    private void addComponents(GridBagConstraints c) {
        for (int i = 0; i < NUMBER_OF_LIVES; i++) {
            c.gridy = 0;
            c.gridx = i;
            c.anchor = GridBagConstraints.PAGE_START;
            c.ipady = 20;
            c.ipadx = 40;
            Life life = new Life();
            this.add(life, c);
            lives.add(life);
        }

        c.ipadx = 100;
        c.ipady = 0;
        c.gridy = 0;
        c.gridx = NUMBER_OF_LIVES;
        this.add(new JLabel(), c);

        c.ipadx = 0;
        c.gridy = 1;
        c.gridx = c.gridx + 1;
        c.anchor = GridBagConstraints.PAGE_END;
        this.add(new ChangeSpaceshipButton(), c);

        c.gridx = c.gridx + 1;
        this.add(new PlayerNickButton(), c);
    }

    public void reduceNumberOfLives() {
        if (livesCounter != 0) {
            this.lives.get(--livesCounter).setBackground(SwingDistributor.GUI_COLOR);
            this.repaint();
        } else {
            new GameEndPopup(false);
        }
    }

    public void resetPanel() {
        livesCounter = NUMBER_OF_LIVES;
        lives.forEach(l -> l.setBackground(Color.GREEN));
        this.repaint();
    }
}
