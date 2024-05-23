package main.space.invaders.drawable.missile;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.DrawableType;
import main.space.invaders.utils.Distributor;

import java.time.Duration;
import java.time.LocalDateTime;

import static main.space.invaders.constants.GameDisplay.GAME_PANEL_HEIGHT;
import static main.space.invaders.constants.Missile.MISSILE_HEIGHT;
import static main.space.invaders.constants.Missile.MISSILE_SHORTEN_RATE;
import static main.space.invaders.drawable.missile.HitBox.isThereCollision;

public class MissileVerificationService {

    private static LocalDateTime lastMissileFired;
    private static final double MINIMAL_INTERVAL_BETWEEN_MISSILE_FIRE = 500;
    private static final int MAXIMUM_FRIENDLY_MISSILES_ON_SCREEN = 10;

    public static boolean shouldFireMoreMissiles() {
        if (lastMissileFired == null) {
            lastMissileFired = LocalDateTime.now();
            return true;
        }
        long durationBetweenLastMissileAndNow = Duration.between(lastMissileFired, LocalDateTime.now()).toMillis();
        long notHostileMissileCount = Distributor.getMissiles().stream()
                .filter(m -> !m.isHostile())
                .count();
        if (notHostileMissileCount <= MAXIMUM_FRIENDLY_MISSILES_ON_SCREEN && durationBetweenLastMissileAndNow > MINIMAL_INTERVAL_BETWEEN_MISSILE_FIRE) {
            lastMissileFired = LocalDateTime.now();
            return true;
        }
        return false;
    }

    public static boolean isMissileOffScreen(Missile missile) {
        return missile.getYLocation() > GAME_PANEL_HEIGHT || missile.getYLocation() + MISSILE_HEIGHT < 0;
    }

    public static boolean shouldShortenMissile(Missile missile, Drawable drawable) {
        return drawable.getType() == DrawableType.BARRIER &&
                missileCanBeShortened(missile);
    }

    public static boolean shouldRemoveMissile(Missile missile, Drawable drawable) {
        return (isHostileTowardsEachOtherCollision(missile, drawable) || isFriendlyMissileBarrierCollision(missile, drawable)) &&
                isThereCollision(missile.getHitBox(), drawable.getHitBox());
    }

    private static boolean isHostileTowardsEachOtherCollision(Missile missile, Drawable drawable) {
        return missile.isHostile() != drawable.isHostile();
    }

    private static boolean isFriendlyMissileBarrierCollision(Missile missile, Drawable drawable) {
        return !missile.isHostile() && drawable.getType() == DrawableType.BARRIER;
    }

    private static boolean missileCanBeShortened(Missile missile) {
        return missile.getHeight() - MISSILE_SHORTEN_RATE > 0;
    }
}
