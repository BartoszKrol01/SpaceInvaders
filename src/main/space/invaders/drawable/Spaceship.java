package main.space.invaders.drawable;

import main.space.invaders.drawable.missile.HitBox;
import main.space.invaders.drawable.missile.Missile;
import main.space.invaders.utils.Distributor;
import main.space.invaders.utils.FileLoader;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;

import static main.space.invaders.gui.GameDisplayConstants.MISSILE_HEIGHT;
import static main.space.invaders.gui.GameDisplayConstants.SPACESHIP_HITBOX_DIFFERENCE;
import static main.space.invaders.gui.GameDisplayConstants.SPACESHIP_SIZE;
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
        int x = this.xLocation + SPACESHIP_HITBOX_DIFFERENCE;
        int y = this.yLocation + SPACESHIP_HITBOX_DIFFERENCE;
        int size = SPACESHIP_SIZE - 2 * SPACESHIP_HITBOX_DIFFERENCE;
        return new HitBox(new Rectangle(x, y, size, size));
    }

    public void changeSpaceshipLocation(int xChangeValue) {
        this.xLocation += xChangeValue;
        Distributor.getGamePanel().repaint();
    }

    public void fireMissile() {
        int x = xLocation + SPACESHIP_SIZE / 2;
        Missile missile = new Missile(x, yLocation + MISSILE_HEIGHT, this);
        Distributor.addDrawables(List.of(missile));
        Distributor.addMissile(missile);
    }

    public int getXLocation() {
        return xLocation;
    }
}
