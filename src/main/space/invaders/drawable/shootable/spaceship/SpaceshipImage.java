package main.space.invaders.drawable.shootable.spaceship;

import java.awt.Image;

public class SpaceshipImage {

    private final Image image;
    private boolean isCurrent;

    public SpaceshipImage(Image image) {
        this.image = image;
        this.isCurrent = false;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    public Image getImage() {
        return image;
    }

    public boolean isCurrent() {
        return isCurrent;
    }
}
