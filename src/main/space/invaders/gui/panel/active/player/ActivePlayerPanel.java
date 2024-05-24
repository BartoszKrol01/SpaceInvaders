package main.space.invaders.gui.panel.active.player;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class ActivePlayerPanel extends JPanel {

    private static final int NUMBER_OF_LIVES = 3;

    public ActivePlayerPanel() {
        Color color = new Color(16, 18, 16);
        this.setBackground(color);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < NUMBER_OF_LIVES; i++) {
            c.gridy = 0;
            c.gridx = i;
            c.anchor = GridBagConstraints.PAGE_START;
            c.ipady = 20;
            c.ipadx = 40;
            this.add(new LifeLabel(), c);
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
        this.add(new ChangeSpaceshipButton(color), c);

        c.gridx = c.gridx + 1;
        this.add(new PlayerNickButton(color), c);

    }
}
