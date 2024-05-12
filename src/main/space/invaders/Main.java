package main.space.invaders;

public class Main {
    public static void main(String[] args) {
        Mob middle = new Mob("middle");
        GamePanel gamePanel = new GamePanel(middle);
        new GameFrame(gamePanel);
        new Thread(gamePanel).start();
    }
}