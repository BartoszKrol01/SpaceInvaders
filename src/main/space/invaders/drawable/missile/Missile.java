package main.space.invaders.drawable.missile;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.DrawableType;
import main.space.invaders.exception.UnknownMissileSourceException;

import java.awt.Color;
import java.awt.Graphics;

import static main.space.invaders.settings.MissileDisplay.MISSILE_HEIGHT;
import static main.space.invaders.settings.MissileDisplay.MISSILE_WIDTH;

public class Missile implements Drawable {

    private final int xLocation;
    private int yLocation;
    private int height;
    private final Drawable source;
    private final int direction;
    private final Color color;

    public Missile(int xLocation, int yLocation, Drawable source) {
        this.source = source;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.height = MISSILE_HEIGHT;

        if (source.getType() == DrawableType.MOB) {
            this.color = Color.RED;
            this.direction = 2;
        } else if (source.getType() == DrawableType.SPACESHIP) {
            this.color = Color.GREEN;
            this.direction = -2;
        } else {
            throw new UnknownMissileSourceException("Missile cant be fired from unknown source!");
        }
    }

    @Override
    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(color);
        g.fillRect(xLocation, yLocation, MISSILE_WIDTH, height);
        g.setColor(oldColor);
    }

    @Override
    public boolean isHostile() {
        return source.isHostile();
    }

    @Override
    public HitBox getHitBox() {
        return new HitBox(xLocation, yLocation, MISSILE_WIDTH, height);
    }

    @Override
    public DrawableType getType() {
        return DrawableType.MISSILE;
    }

    public int getYLocation() {
        return yLocation;
    }

    public void setYLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    public int getDirection() {
        return direction;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
