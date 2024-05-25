package main.space.invaders.drawable.shootable.spaceship;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.DrawableType;
import main.space.invaders.drawable.missile.HitBox;
import main.space.invaders.drawable.missile.Missile;
import main.space.invaders.drawable.shootable.Shootable;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.distribution.SwingDistributor;

import java.awt.Graphics;

import static main.space.invaders.drawable.missile.MissileVerificationService.shouldFireMoreMissiles;
import static main.space.invaders.settings.Missile.MISSILE_HEIGHT;
import static main.space.invaders.settings.Spaceship.FIRST_SPACESHIP_HITBOX_DIFFERENCE_X;
import static main.space.invaders.settings.Spaceship.FIRST_SPACESHIP_HITBOX_DIFFERENCE_Y;
import static main.space.invaders.settings.Spaceship.SECOND_SPACESHIP_HITBOX_DIFFERENCE_X;
import static main.space.invaders.settings.Spaceship.SECOND_SPACESHIP_HITBOX_DIFFERENCE_Y;
import static main.space.invaders.settings.Spaceship.SPACESHIP_SIZE;
import static main.space.invaders.settings.Spaceship.SPACESHIP_START_X;
import static main.space.invaders.settings.Spaceship.SPACESHIP_START_Y;

public class Spaceship implements Drawable, Shootable {

    private int xLocation;
    private final int yLocation;

    public Spaceship() {
        this.xLocation = SPACESHIP_START_X;
        this.yLocation = SPACESHIP_START_Y;
    }

    public void changeSpaceshipLocation(int xChangeValue) {
        this.xLocation += xChangeValue;
        SwingDistributor.getGamePanel().repaint();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(SpaceshipImagesService.getCurrentSpaceshipImage(), xLocation, yLocation, null);
    }

    @Override
    public boolean isHostile() {
        return false;
    }

    @Override
    public HitBox getHitBox() {
        int currentSpaceshipId = SpaceshipImagesService.getCurrentSpaceshipImageId();
        int x = 0, y = 0, width = 0, height = 0;
        if (currentSpaceshipId == 1) {
            x = this.xLocation + FIRST_SPACESHIP_HITBOX_DIFFERENCE_X;
            y = this.yLocation + FIRST_SPACESHIP_HITBOX_DIFFERENCE_Y;
            width = SPACESHIP_SIZE - 2 * FIRST_SPACESHIP_HITBOX_DIFFERENCE_X;
            height = SPACESHIP_SIZE - 2 * FIRST_SPACESHIP_HITBOX_DIFFERENCE_Y;
        } else if (currentSpaceshipId == 2) {
            x = this.xLocation + SECOND_SPACESHIP_HITBOX_DIFFERENCE_X;
            y = this.yLocation + SECOND_SPACESHIP_HITBOX_DIFFERENCE_Y;
            width = SPACESHIP_SIZE - 2 * SECOND_SPACESHIP_HITBOX_DIFFERENCE_X;
            height = SPACESHIP_SIZE - FIRST_SPACESHIP_HITBOX_DIFFERENCE_Y;
        }
        return new HitBox(x, y, width, height);
    }

    @Override
    public DrawableType getType() {
        return DrawableType.SPACESHIP;
    }

    @Override
    public void fireMissile() {
        if (shouldFireMoreMissiles()) {
            int x = xLocation + SPACESHIP_SIZE / 2;
            int y = yLocation - MISSILE_HEIGHT;
            Missile missile = new Missile(x, y, this);
            DataDistributor.addDrawables(missile);
            DataDistributor.addMissile(missile);
        }
    }

    public int getXLocation() {
        return xLocation;
    }
}
