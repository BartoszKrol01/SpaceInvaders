package main.space.invaders.utils;

import main.space.invaders.Mob;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MobsLoader {

    public static List<Mob> loadMobs() {
        List<Mob> mobs = new ArrayList<>();
        loadSpecificMob(mobs, "middle");
//        loadSpecificMob(mobs, "upper");
//        loadSpecificMob(mobs, "lower");
        return mobs;
    }

    public static void loadSpecificMob(List<Mob> mobs, String fileName) {
        Image stay = FileLoader.loadImage(fileName + "_1.png");
        Image go = FileLoader.loadImage(fileName + "_2.png");

        int x = MobDisplayUtils.SIDE_PANEL_GAP;
        int y = MobDisplayUtils.TOP_GAP_BETWEEN_PANEL_AND_FRAME;

        for (int i = 0; i < MobDisplayUtils.MOBS_IN_ONE_ROW_COUNT * 2; i++) {
            if (i == MobDisplayUtils.MOBS_IN_ONE_ROW_COUNT) {
                y+=MobDisplayUtils.TOTAL_MOB_SIZE;
                x = MobDisplayUtils.SIDE_PANEL_GAP;
            }
            mobs.add(new Mob(stay, go, x, y));
            x+=MobDisplayUtils.TOTAL_MOB_SIZE;
        }
    }
}
