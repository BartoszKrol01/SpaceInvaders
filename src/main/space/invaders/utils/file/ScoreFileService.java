package main.space.invaders.utils.file;

import main.space.invaders.exception.ScoreFileException;
import main.space.invaders.player.HighScore;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreFileService {

    public static final String SCORE_SEPARATOR = "~";

    public static void writeToScoreFile(HighScore score) {
        FileWriter file = FileLoader.getScoreFileWriter();
        try {
            file.write("\n" + score.toString() + "\n");
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new ScoreFileException("Error while writing score to file", e);
        }
    }

    public static List<HighScore> getTopTenScoresFromFile() {
        BufferedReader file = FileLoader.getScoreFileReader();
        List<HighScore> result = new ArrayList<>();
        try {
            String line;
            while ((line = file.readLine()) != null && !line.isEmpty()) {
                String[] lineSplit = line.split(SCORE_SEPARATOR);
                String playerName = lineSplit[0];
                try {
                    int score = Integer.parseInt(lineSplit[1]);
                    HighScore highScoreToAdd = new HighScore(playerName, score);
                    result.add(highScoreToAdd);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    throw new ScoreFileException("""
                            Error while reading score. You have several options here:
                            - ensure that the score values are integers
                            - ensure that the player name and score are separated by the '%s' character
                            - delete and create file "resources/score/score.txt"
                            """.formatted(SCORE_SEPARATOR),
                            e);
                }
            }
        } catch (IOException e) {
            throw new ScoreFileException("Error while reading score", e);
        }

        return result.stream()
                .sorted(HighScore::compareTo)
                .limit(11)
                .collect(Collectors.toList());
    }
}
