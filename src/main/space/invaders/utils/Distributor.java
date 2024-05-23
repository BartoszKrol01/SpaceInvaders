package main.space.invaders.utils;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.drawable.barrier.Barrier;
import main.space.invaders.drawable.barrier.BarrierLoader;
import main.space.invaders.drawable.missile.Missile;
import main.space.invaders.drawable.shootable.Spaceship;
import main.space.invaders.drawable.shootable.mob.MobsLoader;
import main.space.invaders.drawable.shootable.mob.model.Mob;
import main.space.invaders.gui.panel.game.GamePanel;
import main.space.invaders.gui.panel.game.RealTimePointsLabel;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Distributor {

    private static final CopyOnWriteArrayList<Drawable> drawables;
    private static final CopyOnWriteArrayList<Mob> mobs;
    private static final CopyOnWriteArrayList<Missile> missiles;
    private static final CopyOnWriteArrayList<Barrier> barriers;
    private static final Spaceship spaceship;
    private static final GamePanel gamePanel;
    private static final RealTimePointsLabel realTimePointsLabel;

    static {
        barriers = BarrierLoader.loadBarriers();
        realTimePointsLabel = new RealTimePointsLabel();
        gamePanel = new GamePanel();
        mobs = MobsLoader.loadMobs();
        spaceship = new Spaceship();
        missiles = new CopyOnWriteArrayList<>();

        drawables = new CopyOnWriteArrayList<>();
        drawables.addAll(mobs);
        drawables.addAll(barriers);
        drawables.add(spaceship);
    }

    public static List<Drawable> getDrawables() {
        return drawables;
    }

    public static void addDrawables(Drawable drawable) {
        drawables.add(drawable);
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
        Distributor.mobs.removeAll(mobs);
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

    public static RealTimePointsLabel getRealTimePointsLabel() {
        return realTimePointsLabel;
    }
}
