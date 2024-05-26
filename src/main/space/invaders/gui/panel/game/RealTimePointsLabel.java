package main.space.invaders.gui.panel.game;

import javax.swing.JLabel;

import static main.space.invaders.utils.SwingUtils.setFontAndForegroundColor;

public class RealTimePointsLabel extends JLabel {

    private static final String SCORE = "Score";
    private static final String DEFAULT_MESSAGE = SCORE + ": 0";
    private int counter;

    public RealTimePointsLabel() {
        counter = 0;
        restartText();
        setFontAndForegroundColor(this);
    }

    public void updateText(int mobsEliminated) {
        counter += mobsEliminated;
        this.setText(SCORE + ": " + counter);
    }

    public void restartText() {
        this.setText(DEFAULT_MESSAGE);
    }
}
