package main.space.invaders.player;

public class ScoreCounter {

    private static int score = 0;

    public static void incrementScore(int changeValue) {
        score += changeValue;
    }

    public static int getScore() {
        return score;
    }

    public static void resetScore() {
        score = 0;
    }
}
