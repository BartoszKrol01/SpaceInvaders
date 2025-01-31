package main.space.invaders.drawable.shootable.mob.model;

import main.space.invaders.animator.MobAnimator;
import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.DrawableType;
import main.space.invaders.drawable.missile.HitBox;
import main.space.invaders.drawable.missile.Missile;
import main.space.invaders.drawable.shootable.Shootable;
import main.space.invaders.utils.distribution.DataDistributor;

import java.awt.Graphics;
import java.awt.Image;

import static main.space.invaders.settings.MobDisplay.MOB_SIZE;

public abstract class Mob implements Drawable, Shootable {

    private final Image stay;
    private final Image go;
    private Image currentImage;
    protected int xLocation;
    protected int yLocation;
    private int direction;
    private boolean justMovedDown;

    public Mob(Image stay, Image go, int xLocation, int yLocation) {
        this.stay = stay;
        this.go = go;
        this.currentImage = stay;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.direction = 1;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(currentImage, xLocation, yLocation, null);
    }

    @Override
    public boolean isHostile() {
        return true;
    }

    @Override
    public abstract HitBox getHitBox();

    @Override
    public DrawableType getType() {
        return DrawableType.MOB;
    }

    @Override
    public void fireMissile() {
        int x = xLocation + MOB_SIZE / 2;
        int y = yLocation + MOB_SIZE / 2;
        Missile missile = new Missile(x, y, this);
        DataDistributor.addDrawables(missile);
        DataDistributor.addMissile(missile);
    }

    public void performStepDown() {
        MobAnimator.moveMobDown(this);
    }

    //getters and setters

    public Image getStay() {
        return stay;
    }

    public Image getGo() {
        return go;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    public int getXLocation() {
        return xLocation;
    }

    public void setXLocation(int xLocation) {
        this.xLocation = xLocation;
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

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean justMovedDown() {
        return justMovedDown;
    }

    public void setJustMovedDown(boolean justMovedDown) {
        this.justMovedDown = justMovedDown;
    }
}
