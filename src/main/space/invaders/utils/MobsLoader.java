package main.space.invaders.utils;

import main.space.invaders.Mob;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static main.space.invaders.utils.GameDisplayUtils.MOBS_IN_ONE_ROW_COUNT;
import static main.space.invaders.utils.GameDisplayUtils.NUMBER_OF_ROWS_COUNT;
import static main.space.invaders.utils.GameDisplayUtils.SIDE_PANEL_GAP;
import static main.space.invaders.utils.GameDisplayUtils.TOP_GAP_BETWEEN_PANEL_AND_FRAME;
import static main.space.invaders.utils.GameDisplayUtils.TOTAL_MOB_SIZE;

public class MobsLoader {

    private static int currentRow = 1;

    public static List<Mob> loadMobs() {
        List<Mob> mobs = new ArrayList<>();
        loadSpecificMob(mobs, "lower", 2);
        loadSpecificMob(mobs, "middle", 2);
        loadSpecificMob(mobs, "upper", 1);
        return mobs;
    }

    public static void loadSpecificMob(List<Mob> mobs, String fileName, int howManyRows) {
        Image stay = FileLoader.loadImage(fileName + "_1.png");
        Image go = FileLoader.loadImage(fileName + "_2.png");

        int x = SIDE_PANEL_GAP;
        int y = getCurrentMobYLocation();

        for (int row = 1; row <= howManyRows; row++) {
            for (int column = 1; column <= MOBS_IN_ONE_ROW_COUNT; column++) {
                mobs.add(new Mob(stay, go, x, y, currentRow));
                x += TOTAL_MOB_SIZE;
            }
            y -= TOTAL_MOB_SIZE;
            x = SIDE_PANEL_GAP;
            currentRow++;
        }
    }

    private static int getCurrentMobYLocation() {
        return (TOP_GAP_BETWEEN_PANEL_AND_FRAME + (NUMBER_OF_ROWS_COUNT * TOTAL_MOB_SIZE)) - (currentRow * TOTAL_MOB_SIZE);
    }
}
