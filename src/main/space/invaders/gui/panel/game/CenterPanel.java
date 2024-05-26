package main.space.invaders.gui.panel.game;

import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class CenterPanel extends JPanel {

    public CenterPanel(JPanel gameWrapper) {
        this.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 40, 0));
        northPanel.setBackground(Color.BLACK);
        northPanel.add(SwingDistributor.getRealTimePointsLabel());
        northPanel.add(new JLabel());
        this.add(northPanel, BorderLayout.NORTH);

        gameWrapper.setBackground(Color.BLACK);
        gameWrapper.add(SwingDistributor.getGamePanel());
        this.add(gameWrapper, BorderLayout.CENTER);

        this.add(SwingDistributor.getActivePlayerPanel(), BorderLayout.SOUTH);
    }
}
