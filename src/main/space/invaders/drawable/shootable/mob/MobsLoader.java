package main.space.invaders.drawable.shootable.mob;

import main.space.invaders.drawable.shootable.mob.model.LowerMob;
import main.space.invaders.drawable.shootable.mob.model.MiddleMob;
import main.space.invaders.drawable.shootable.mob.model.Mob;
import main.space.invaders.drawable.shootable.mob.model.UpperMob;
import main.space.invaders.settings.service.MobsInOneRowCountService;
import main.space.invaders.settings.service.NumberOfMobRowsService;
import main.space.invaders.utils.FileLoader;

import java.awt.Image;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static main.space.invaders.settings.GameDisplay.SIDE_PANEL_GAP;
import static main.space.invaders.settings.GameDisplay.TOP_GAP_BETWEEN_PANEL_AND_FRAME;
import static main.space.invaders.settings.MobDisplay.TOTAL_MOB_SIZE;

public class MobsLoader {
    //todo: images should be static and final

    private static int currentRow;

    public static CopyOnWriteArrayList<Mob> loadMobs() {
        currentRow = 1;
        CopyOnWriteArrayList<Mob> mobs = new CopyOnWriteArrayList<>();
        loadSpecificMob(mobs, MobType.LOWER);
        loadSpecificMob(mobs, MobType.MIDDLE);
        loadSpecificMob(mobs, MobType.UPPER);
        return mobs;
    }

    public static void loadSpecificMob(List<Mob> mobs, MobType mobType) {
        Image stay = FileLoader.loadImage(mobType.getFileName() + "_1");
        Image go = FileLoader.loadImage(mobType.getFileName() + "_2");

        int x = SIDE_PANEL_GAP;
        int y = getCurrentMobYLocation();

        for (int row = 1; row <= mobType.getRowsOccupied(); row++) {
            for (int column = 1; column <= MobsInOneRowCountService.getMobsInOneRowCount(); column++) {
                mobs.add(createMob(mobType, x, y, stay, go));
                x += TOTAL_MOB_SIZE;
            }
            y -= TOTAL_MOB_SIZE;
            x = SIDE_PANEL_GAP;
            currentRow++;
        }
    }

    private static Mob createMob(MobType mobType, int x, int y, Image stay, Image go) {
        return switch (mobType) {
            case LOWER -> new LowerMob(stay, go, x, y);
            case MIDDLE -> new MiddleMob(stay, go, x, y);
            case UPPER -> new UpperMob(stay, go, x, y);
        };
    }

    private static int getCurrentMobYLocation() {
        return (TOP_GAP_BETWEEN_PANEL_AND_FRAME + (NumberOfMobRowsService.getNumberOfMobRows() * TOTAL_MOB_SIZE)) - (currentRow * TOTAL_MOB_SIZE);
    }
}
