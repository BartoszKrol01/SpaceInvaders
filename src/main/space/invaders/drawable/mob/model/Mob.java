package main.space.invaders.drawable.mob.model;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.HitBox;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Mob implements Drawable {

    protected final Image stay;
    protected final Image go;
    private Image currentImage;
    private int xLocation;
    private int yLocation;
    private int horizontalStepsCounter;
    private int direction;
    private int verticalStepsCounter;
    private final int startRow;

    public Mob(Image stay, Image go, int xLocation, int yLocation, int startRow) {
        this.stay = stay;
        this.go = go;
        this.currentImage = stay;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.horizontalStepsCounter = 0;
        this.verticalStepsCounter = 0;
        this.direction = 1;
        this.startRow = startRow;
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

    public int getHorizontalStepsCounter() {
        return horizontalStepsCounter;
    }

    public void setHorizontalStepsCounter(int horizontalStepsCounter) {
        this.horizontalStepsCounter = horizontalStepsCounter;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getVerticalStepsCounter() {
        return verticalStepsCounter;
    }

    public void setVerticalStepsCounter(int verticalStepsCounter) {
        this.verticalStepsCounter = verticalStepsCounter;
    }

    public int getStartRow() {
        return startRow;
    }
}
