package main.space.invaders.utils;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.Spaceship;
import main.space.invaders.drawable.missile.Missile;
import main.space.invaders.drawable.mob.MobsLoader;
import main.space.invaders.drawable.mob.model.Mob;
import main.space.invaders.gui.GamePanel;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Distributor {

    private static final CopyOnWriteArrayList<Drawable> drawables;
    private static final List<Mob> mobs;
    private static final Spaceship spaceship;
    private static final GamePanel gamePanel;
    private static final CopyOnWriteArrayList<Missile> missiles;

    static {
        gamePanel = new GamePanel();
        mobs = MobsLoader.loadMobs();
        spaceship = new Spaceship();
        missiles = new CopyOnWriteArrayList<>();

        drawables = new CopyOnWriteArrayList<>();
        drawables.addAll(mobs);
        drawables.add(spaceship);
    }

    public static List<Drawable> getDrawables() {
        return drawables;
    }

    public static void addDrawables(List<Drawable> drawables) {
        Distributor.drawables.addAll(drawables);
    }

    public static void removeDrawables(List<Drawable> drawables) {
        Distributor.drawables.removeAll(drawables);
    }

    public static List<Mob> getMobs() {
        return mobs;
    }

    public static void addMobs(List<Mob> mobs) {
        Distributor.mobs.addAll(mobs);
    }

    public static void removeMobs(List<Mob> mobs) {
        drawables.removeAll(mobs);
    }

    public static Spaceship getSpaceship() {
        return spaceship;
    }

    public static GamePanel getGamePanel() {
        return gamePanel;
    }

    public static void addMissile(Missile missile) {
        missiles.add(missile);
    }

    public static void removeMissiles(List<Missile> missiles) {
        Distributor.missiles.removeAll(missiles);
    }

    public static List<Missile> getMissiles() {
        return missiles;
    }
}
