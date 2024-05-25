package main.space.invaders.utils.distribution;

import main.space.invaders.Player;
import main.space.invaders.animator.Animator;
import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.barrier.BarrierLoader;
import main.space.invaders.drawable.missile.Missile;
import main.space.invaders.drawable.shootable.mob.MobsLoader;
import main.space.invaders.drawable.shootable.mob.model.Mob;
import main.space.invaders.drawable.shootable.spaceship.Spaceship;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DataDistributor {

    private static final List<Animator> animators;
    private static CopyOnWriteArrayList<Drawable> drawables;
    private static CopyOnWriteArrayList<Mob> mobs;
    private static CopyOnWriteArrayList<Missile> missiles;
    private static Spaceship spaceship;
    private static Player player;

    static {
        animators = new ArrayList<>();
        drawables = new CopyOnWriteArrayList<>();
        mobs = new CopyOnWriteArrayList<>();
        missiles = new CopyOnWriteArrayList<>();
    }

    public static void populateData() {
        mobs = MobsLoader.loadMobs();
        spaceship = new Spaceship();
        missiles = new CopyOnWriteArrayList<>();

        drawables = new CopyOnWriteArrayList<>();
        drawables.addAll(mobs);
        drawables.addAll(BarrierLoader.loadBarriers());
        drawables.add(spaceship);
    }

    public static void setPlayer(Player player) {
        DataDistributor.player = player;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void addAnimator(Animator animator) {
        animators.add(animator);
    }

    public static List<Animator> getAnimators() {
        return animators;
    }

    public static List<Drawable> getDrawables() {
        return drawables;
    }

    public static void addDrawables(Drawable drawable) {
        drawables.add(drawable);
    }

    public static void removeDrawables(List<Drawable> drawables) {
        DataDistributor.drawables.removeAll(drawables);
    }

    public static List<Mob> getMobs() {
        return mobs;
    }

    public static void removeMobs(List<Mob> mobs) {
        DataDistributor.mobs.removeAll(mobs);
    }

    public static Spaceship getSpaceship() {
        return spaceship;
    }

    public static void addMissile(Missile missile) {
        missiles.add(missile);
    }

    public static void removeMissiles(List<Missile> missiles) {
        DataDistributor.missiles.removeAll(missiles);
    }

    public static List<Missile> getMissiles() {
        return missiles;
    }

}
