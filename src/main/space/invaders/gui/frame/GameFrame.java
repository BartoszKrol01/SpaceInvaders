package main.space.invaders.gui.frame;

import main.space.invaders.gui.FramePanel;

import javax.swing.*;

public class GameFrame extends JFrame {

    private static final String TITLE = "Space Invaders";

    public GameFrame(FramePanel framePanel) {
        this.add(framePanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setTitle(TITLE);
        this.setVisible(true);
        this.addKeyListener(new GameFrameKeyListener());
    }
}
