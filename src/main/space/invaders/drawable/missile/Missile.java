package main.space.invaders.drawable.missile;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.shootable.Spaceship;
import main.space.invaders.drawable.shootable.mob.model.Mob;
import main.space.invaders.exception.UnknownMissileSourceException;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import static main.space.invaders.gui.GameDisplayConstants.MISSILE_HEIGHT;
import static main.space.invaders.gui.GameDisplayConstants.MISSILE_WIDTH;

public class Missile implements Drawable {

    private final int xLocation;
    private int yLocation;
    private final Drawable source;
    private final int direction;
    private final Color color;

    public Missile(int xLocation, int yLocation, Drawable source) {
        this.source = source;
        this.xLocation = xLocation;
        this.yLocation = yLocation;

        if (source instanceof Mob) {
            this.color = Color.RED;
            this.direction = 2;
        } else if (source instanceof Spaceship) {
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
        g.fillRect(xLocation, yLocation, MISSILE_WIDTH, MISSILE_HEIGHT);
        g.setColor(oldColor);
    }

    @Override
    public boolean isHostile() {
        return source.isHostile();
    }

    @Override
    public HitBox getHitBox() {
        return new HitBox(new Rectangle(xLocation, yLocation, MISSILE_WIDTH, MISSILE_HEIGHT));
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
}
