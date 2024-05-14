package main.space.invaders.drawable;

import main.space.invaders.utils.FileLoader;

import javax.swing.*;
import java.awt.*;

import static main.space.invaders.gui.GameDisplayConstants.SPACESHIP_START_X;
import static main.space.invaders.gui.GameDisplayConstants.SPACESHIP_START_Y;

public class Spaceship implements Drawable {

    private static Spaceship spaceship;
    private int xLocation;
    private final int yLocation;
    private JPanel parentPanel;
    private final Image image;

    public static Spaceship getSpaceship() {
        if (spaceship == null) {
            spaceship = new Spaceship();
        }
        return spaceship;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, xLocation, yLocation, null);
    }

    public void changeSpaceshipLocation(int xChangeValue) {
        this.xLocation += xChangeValue;
        parentPanel.repaint();
    }

    private Spaceship() {
        this.xLocation = SPACESHIP_START_X;
        this.yLocation = SPACESHIP_START_Y;
        this.image = FileLoader.loadImage("spaceship/spaceship.png");
    }

    public void setParentPanel(JPanel parentPanel) {
        this.parentPanel = parentPanel;
    }
}
