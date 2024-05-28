package main.space.invaders.player;

public class HighScore implements Comparable<HighScore> {

    private final String playerName;
    private final int score;

    public HighScore(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(HighScore highScore) {
        return highScore.score - this.score;
    }
}
