package main.space.invaders.player;

public final class Player {

    private final String name;
    private static Player activePlayer;

    public Player(String name) {
        activePlayer = this;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Player getActivePlayer() {
        return activePlayer;
    }

}
