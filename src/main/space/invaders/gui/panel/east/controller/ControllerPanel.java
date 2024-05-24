package main.space.invaders.gui.panel.east.controller;

import main.space.invaders.gui.frame.KeyEventMapped;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class ControllerPanel extends JPanel {

    public ControllerPanel() {
        this.setBackground(SwingDistributor.GUI_COLOR);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        MoveButton moveLeftButton = new MoveButton(KeyEventMapped.LEFT);
        MoveButton moveRightButton = new MoveButton(KeyEventMapped.RIGHT);
        PauseButton pauseButton = new PauseButton();
        ShootButton shootButton = new ShootButton();

        c.gridx = 0;
        c.gridy = 0;
        this.add(moveLeftButton, c);

        c.gridwidth = 2;
        c.gridx = 1;
        c.fill = GridBagConstraints.VERTICAL;
        this.add(shootButton, c);

        c.gridx = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.NONE;
        this.add(moveRightButton, c);

        c.gridy = 1;
        c.gridx = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.VERTICAL;
        this.add(pauseButton, c);
    }

}
