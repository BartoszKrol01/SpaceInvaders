package main.space.invaders.gui.panel.game;

import javax.swing.JLabel;

import static main.space.invaders.utils.SwingUtils.setFontAndForegroundColor;

public class RealTimePointsLabel extends JLabel {
//todo: reset counter on game reset

    private static final String SCORE = "Score";
    private static final String DEFAULT_MESSAGE = SCORE + ": 0";
    private int counter;

    public RealTimePointsLabel() {
        counter = 0;
        this.setText(DEFAULT_MESSAGE);
        setFontAndForegroundColor(this);
    }

    public void updateText(int mobsEliminated) {
        counter += mobsEliminated;
        this.setText(SCORE + ": " + counter);
    }
}
