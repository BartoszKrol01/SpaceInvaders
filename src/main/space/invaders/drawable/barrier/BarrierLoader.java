package main.space.invaders.drawable.barrier;

import java.util.concurrent.CopyOnWriteArrayList;

import static main.space.invaders.gui.panel.game.GameDisplayConstants.BARRIERS_TRIANGLES_NUMBER;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.BARRIERS_TRIANGLE_BASE;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.BARRIERS_TRIANGLE_BASE_START_Y;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.BARRIERS_TRIANGLE_BASE_WIDTH;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.BARRIERS_TRIANGLE_HEIGHT;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.BARRIER_SIZE;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.GAP_BETWEEN_BARRIERS;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.SIDE_PANEL_GAP;

public class BarrierLoader {

    public static CopyOnWriteArrayList<Barrier> loadBarriers() {
        CopyOnWriteArrayList<Barrier> barriers = new CopyOnWriteArrayList<>();
        for (int triangleIndex = 0; triangleIndex < BARRIERS_TRIANGLES_NUMBER; triangleIndex++) {
            for (int width = 0; width < BARRIERS_TRIANGLE_BASE; width++) {
                for (int height = getCurrentHeight(width); height > 0; height--) {
                    int x = getXLocation(triangleIndex) + width * BARRIER_SIZE;
                    int y = BARRIERS_TRIANGLE_BASE_START_Y - height * BARRIER_SIZE;
                    barriers.add(new Barrier(x, y));
                }
            }
        }
        return barriers;
    }

    private static int getCurrentHeight(int width) {
        return BARRIERS_TRIANGLE_HEIGHT - Math.abs(width - (BARRIERS_TRIANGLE_BASE - 1) / 2);
    }

    private static int getXLocation(int triangleIndex) {
        return triangleIndex * (BARRIERS_TRIANGLE_BASE_WIDTH + GAP_BETWEEN_BARRIERS) + SIDE_PANEL_GAP;
    }
}
