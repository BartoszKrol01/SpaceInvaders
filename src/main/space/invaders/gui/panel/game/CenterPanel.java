package main.space.invaders.gui.panel.game;

import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class CenterPanel extends JPanel {

    public CenterPanel() {
        this.setLayout(new BorderLayout());

        JPanel wrapper = new JPanel();
        wrapper.setBackground(Color.BLACK);
        wrapper.add(SwingDistributor.getGamePanel());
        this.add(wrapper, BorderLayout.CENTER);

        this.add(SwingDistributor.getActivePlayerPanel(), BorderLayout.SOUTH);
    }
}
