package main.space.invaders.drawable.shootable.spaceship;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.DrawableType;
import main.space.invaders.drawable.missile.HitBox;
import main.space.invaders.drawable.missile.Missile;
import main.space.invaders.drawable.shootable.Shootable;
import main.space.invaders.utils.Distributor;

import java.awt.Graphics;

import static main.space.invaders.gui.panel.game.GameDisplayConstants.MISSILE_HEIGHT;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.SPACESHIP_HITBOX_DIFFERENCE;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.SPACESHIP_SIZE;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.SPACESHIP_START_X;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.SPACESHIP_START_Y;

public class Spaceship implements Drawable, Shootable {

    private int xLocation;
    private final int yLocation;

    public Spaceship() {
        this.xLocation = SPACESHIP_START_X;
        this.yLocation = SPACESHIP_START_Y;
    }

    public void changeSpaceshipLocation(int xChangeValue) {
        this.xLocation += xChangeValue;
        Distributor.getGamePanel().repaint();
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
        int x = this.xLocation + SPACESHIP_HITBOX_DIFFERENCE;
        int y = this.yLocation + SPACESHIP_HITBOX_DIFFERENCE;
        int size = SPACESHIP_SIZE - 2 * SPACESHIP_HITBOX_DIFFERENCE;
        return new HitBox(x, y, size, size);
    }

    @Override
    public DrawableType getType() {
        return DrawableType.SPACESHIP;
    }

    @Override
    public void fireMissile() {
        int x = xLocation + SPACESHIP_SIZE / 2;
        int y = yLocation - MISSILE_HEIGHT;
        Missile missile = new Missile(x, y, this);
        Distributor.addDrawables(missile);
        Distributor.addMissile(missile);
    }

    public int getXLocation() {
        return xLocation;
    }
}
