package main.space.invaders;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static main.space.invaders.utils.ThreadUtils.sleep;

public class MobAnimator implements Runnable {

    private static final List<Mob> mobs;

    static {
        mobs = new ArrayList<>();
    }

    private final JPanel parentMobPanel;

    public MobAnimator(JPanel parentMobPanel) {
        this.parentMobPanel = Objects.requireNonNull(parentMobPanel);
    }

    public static void addMob(Mob mob) {
        mobs.add(Objects.requireNonNull(mob));
    }

    @Override
    public void run() {
        while (!PauseService.gamePaused()) {
            for (Mob mob : mobs) {
                mob.changeImage();
                sleep(30);
                parentMobPanel.repaint();
            }
        }
    }
}
