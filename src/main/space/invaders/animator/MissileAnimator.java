package main.space.invaders.animator;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.DrawableType;
import main.space.invaders.drawable.missile.Missile;
import main.space.invaders.drawable.shootable.mob.model.Mob;
import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.distribution.SwingDistributor;

import java.util.ArrayList;
import java.util.List;

import static main.space.invaders.drawable.missile.MissileVerificationService.isMissileOffScreen;
import static main.space.invaders.drawable.missile.MissileVerificationService.shouldRemoveMissile;
import static main.space.invaders.drawable.missile.MissileVerificationService.shouldShortenMissile;
import static main.space.invaders.settings.MissileDisplay.MISSILE_SHORTEN_RATE;

public class MissileAnimator extends Animator {

    public MissileAnimator() {
        super();
    }

    @Override
    public void run() {
        while (PauseService.isRunning()) {
            if (PauseService.gamePaused()) {
                pauseAnimation();
            }
            List<Missile> toRemoveMissiles = new ArrayList<>();
            List<Drawable> toRemoveDrawables = new ArrayList<>();
            List<Mob> toRemoveMobs = new ArrayList<>();

            //In case of ConcurrentModificationException loop should iterate over array using Iterator<> class
            for (Missile missile : DataDistributor.getMissiles()) {
                for (Drawable drawable : DataDistributor.getDrawables()) {
                    if (isMissileOffScreen(missile)) {
                        toRemoveMissiles.add(missile);
                        toRemoveDrawables.add(missile);
                    } else if (shouldRemoveMissile(missile, drawable)) {
                        if (shouldShortenMissile(missile, drawable)) {
                            shortenMissile(missile);
                            toRemoveDrawables.add(drawable);
                        } else {
                            toRemoveMissiles.add(missile);
                            toRemoveDrawables.add(missile);
                            if (drawable instanceof Mob mob) {
                                toRemoveMobs.add(mob);
                                toRemoveDrawables.add(mob);
                            } else if (drawable.getType() == DrawableType.SPACESHIP) {
                                SwingDistributor.getActivePlayerPanel().reduceNumberOfLives();
                            }
                        }
                    }
                }
                missile.setYLocation(missile.getYLocation() + missile.getDirection() * missile.getVelocity());
            }

            DataDistributor.removeMissiles(toRemoveMissiles);
            DataDistributor.removeDrawables(toRemoveDrawables);
            DataDistributor.removeMobs(toRemoveMobs);
            if (!toRemoveMobs.isEmpty()) {
                SwingDistributor.getRealTimePointsLabel().updateText(toRemoveMobs.size());
            }
            SwingDistributor.getGamePanel().repaint();
            sleepTryCatch(16);
        }
    }

    private void shortenMissile(Missile missile) {
        missile.setHeight(missile.getHeight() - MISSILE_SHORTEN_RATE);
    }
}

