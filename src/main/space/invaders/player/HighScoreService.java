package main.space.invaders.player;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class HighScoreService {

    private static final List<HighScore> highScores;

    static {
        highScores = new ArrayList<>();
        highScores.add(new HighScore("Tomaszew", 999));
        highScores.add(new HighScore("Tomaszew", 998));
        highScores.add(new HighScore("Tomaszew", 997));
        highScores.add(new HighScore("Tomaszew", 996));
        highScores.add(new HighScore("Tomaszew", 995));
        highScores.add(new HighScore("Tomaszew", 994));
        highScores.add(new HighScore("guest", 800));
        highScores.add(new HighScore("Bstrodz", 700));
        highScores.add(new HighScore("guest", 2));
        highScores.add(new HighScore("guest", 1));
    }

    public static List<HighScore> updateAndGetHighScores(String playerName, int score) {
        if (highScores.size() < 10) {
            highScores.add(new HighScore(playerName, score));
        } else {
            Optional<HighScore> minHighScore = highScores.stream()
                    .filter(h -> h.getScore() < score)
                    .min(HighScore::compareTo);
            minHighScore.ifPresent(e -> {
                JOptionPane.showMessageDialog(null, "Congratulations you're score has reached high score board!");
                highScores.remove(e);
                highScores.add(new HighScore(playerName, score));
            });
        }
        Collections.sort(highScores);
        return highScores;
    }

    public static List<HighScore> getHighScores() {
        Collections.sort(highScores);
        return highScores;
    }
}
