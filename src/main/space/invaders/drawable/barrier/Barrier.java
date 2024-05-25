package main.space.invaders.drawable.barrier;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.DrawableType;
import main.space.invaders.drawable.missile.HitBox;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import static main.space.invaders.settings.Barrier.BARRIER_SIZE;

public class Barrier implements Drawable {

    private final int xLocation;
    private final int yLocation;

    public Barrier(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    @Override
    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(Color.GREEN);
        g.fillRect(xLocation, yLocation, BARRIER_SIZE, BARRIER_SIZE);
        g.setColor(oldColor);
    }

    @Override
    public boolean isHostile() {
        return false;
    }

    @Override
    public HitBox getHitBox() {
        return new HitBox(xLocation + getRandomFactorToHitBox(), yLocation, BARRIER_SIZE, BARRIER_SIZE);
    }

    @Override
    public DrawableType getType() {
        return DrawableType.BARRIER;
    }

    private int getRandomFactorToHitBox() {
        return new Random().nextInt(-2, 2);
    }
}
