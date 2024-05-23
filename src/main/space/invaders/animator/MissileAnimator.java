package main.space.invaders.animator;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.missile.Missile;
import main.space.invaders.drawable.shootable.mob.model.Mob;
import main.space.invaders.utils.Distributor;

import java.util.ArrayList;
import java.util.List;

import static main.space.invaders.drawable.missile.MissileVerificationService.isMissileOffScreen;
import static main.space.invaders.drawable.missile.MissileVerificationService.shouldRemoveMissile;
import static main.space.invaders.drawable.missile.MissileVerificationService.shouldShortenMissile;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.MISSILE_SHORTEN_RATE;

public class MissileAnimator extends Animator {

    public MissileAnimator() {
        new Thread(this).start();
        Distributor.addAnimator(this);
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
            for (Missile missile : Distributor.getMissiles()) {
                for (Drawable drawable : Distributor.getDrawables()) {
                    if (isMissileOffScreen(missile)) {
                        toRemoveMissiles.add(missile);
                        toRemoveDrawables.add(missile);
                    } else if (shouldRemoveMissile(missile, drawable)) {
                        if (shouldShortenMissile(missile, drawable)) {
                            shortenMissile(missile);
                            toRemoveDrawables.add(drawable);
                        } else {
                            toRemoveMissiles.add(missile);
                            toRemoveDrawables.addAll(List.of(missile, drawable));
                            if (drawable instanceof Mob mob) {
                                toRemoveMobs.add(mob);
                            }
                        }

                    }
                }
                missile.setYLocation(missile.getYLocation() + missile.getDirection());
            }

            Distributor.removeMissiles(toRemoveMissiles);
            Distributor.removeDrawables(toRemoveDrawables);
            Distributor.removeMobs(toRemoveMobs);
            if (!toRemoveMobs.isEmpty()) {
                Distributor.getRealTimePointsLabel().updateText(toRemoveMobs.size());
            }
            sleepTryCatch(16);
        }
    }

    private void shortenMissile(Missile missile) {
        missile.setHeight(missile.getHeight() - MISSILE_SHORTEN_RATE);
    }
}

