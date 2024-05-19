package main.space.invaders.drawable;

import main.space.invaders.utils.Distributor;
import main.space.invaders.utils.FileLoader;

import java.awt.Graphics;
import java.awt.Image;

import static main.space.invaders.gui.GameDisplayConstants.SPACESHIP_START_X;
import static main.space.invaders.gui.GameDisplayConstants.SPACESHIP_START_Y;

public class Spaceship implements Drawable {

    private int xLocation;
    private final int yLocation;
    private final Image image;

    public Spaceship() {
        this.xLocation = SPACESHIP_START_X;
        this.yLocation = SPACESHIP_START_Y;
        this.image = FileLoader.loadImage("spaceship/spaceship.png");
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, xLocation, yLocation, null);
    }

    @Override
    public boolean isHostile() {
        return false;
    }

    @Override
    public HitBox getHitBox() {
        return null;
    }

    public void changeSpaceshipLocation(int xChangeValue) {
        this.xLocation += xChangeValue;
        Distributor.getGamePanel().repaint();
    }

    public int getXLocation() {
        return xLocation;
    }
}
