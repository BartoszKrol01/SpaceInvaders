package main.space.invaders.gui.panel.game;

import main.space.invaders.player.ScoreCounter;

import javax.swing.JLabel;

import static main.space.invaders.utils.SwingUtils.setFontAndForegroundColor;

public class RealTimePointsLabel extends JLabel {

    private static final String SCORE = "Score";
    private static final String DEFAULT_MESSAGE = SCORE + ": 0";

    public RealTimePointsLabel() {
        restartText();
        setFontAndForegroundColor(this);
    }

    public void updateScore() {
        this.setText(SCORE + ": " + ScoreCounter.getScore());
    }

    public void restartText() {
        this.setText(DEFAULT_MESSAGE);
    }
}
