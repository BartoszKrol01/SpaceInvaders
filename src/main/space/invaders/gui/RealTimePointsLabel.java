package main.space.invaders.gui;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

import static main.space.invaders.gui.GameDisplayConstants.GAME_PANEL_WIDTH;

public class RealTimePointsLabel extends JLabel {

    private static final String SCORE = "Score";
    private static final String DEFAULT_MESSAGE = SCORE + ": 0";
    private int counter;

    public RealTimePointsLabel() {
        counter = 0;
        this.setText(DEFAULT_MESSAGE);
        this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        this.setForeground(Color.GREEN);
        this.setHorizontalAlignment(SwingConstants.RIGHT);
        int x = GAME_PANEL_WIDTH - 50;
        int y = 0;
        int width = 50;
        int height = 30;
        this.setBounds(x, y, width, height);
    }

    public void updateText(int mobsEliminated) {
        counter += mobsEliminated;
        if (mobsEliminated > 0) {
            System.out.println(counter);
        }
        this.setText(SCORE + ": " + counter);
    }
}
