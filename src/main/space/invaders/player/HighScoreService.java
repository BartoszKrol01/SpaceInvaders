package main.space.invaders.player;

import main.space.invaders.utils.file.ScoreFileService;

import javax.swing.JOptionPane;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class HighScoreService {

    private static final List<HighScore> highScores;

    static {
        highScores = ScoreFileService.getTopTenScoresFromFile();
    }

    public static List<HighScore> updateAndGetHighScores(HighScore newHighScore) {
        ScoreFileService.writeToScoreFile(newHighScore);
        if (highScores.size() < 10) {
            highScores.add(newHighScore);
        } else {
            Optional<HighScore> minHighScore = highScores.stream()
                    .filter(h -> h.getScore() < newHighScore.getScore())
                    .min(Comparator.comparingInt(HighScore::getScore));
            minHighScore.ifPresent(e -> {
                JOptionPane.showMessageDialog(null, "Congratulations you're score has reached high score board!");
                highScores.remove(e);
                highScores.add(newHighScore);
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
