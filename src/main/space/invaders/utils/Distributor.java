package main.space.invaders.utils;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.Spaceship;
import main.space.invaders.drawable.mob.MobsLoader;
import main.space.invaders.drawable.mob.model.Mob;
import main.space.invaders.gui.GamePanel;

import java.util.ArrayList;
import java.util.List;

public class Distributor {

    private static final List<Drawable> drawables;
    private static final List<Mob> mobs;
    private static final Spaceship spaceship;
    private static final GamePanel gamePanel;

    static {
        gamePanel = new GamePanel();
        mobs = MobsLoader.loadMobs();
        spaceship = new Spaceship();
        drawables = new ArrayList<>();
        drawables.addAll(mobs);
        drawables.add(spaceship);
    }

    public static List<Drawable> getDrawables() {
        return drawables;
    }

    public static void addDrawables(List<Drawable> drawables) {
        Distributor.drawables.addAll(drawables);
    }

    public static void removeDrawable(Drawable drawable) {
        drawables.remove(drawable);
    }

    public static List<Mob> getMobs() {
        return mobs;
    }

    public static void addMobs(List<Mob> mobs) {
        Distributor.mobs.addAll(mobs);
    }

    public static void removeMob(Mob mob) {
        drawables.remove(mob);
    }

    public static Spaceship getSpaceship() {
        return spaceship;
    }

    public static GamePanel getGamePanel() {
        return gamePanel;
    }
}
