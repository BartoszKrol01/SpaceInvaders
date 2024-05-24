package main.space.invaders.utils.distribution;

import main.space.invaders.gui.panel.active.player.ActivePlayerPanel;
import main.space.invaders.gui.panel.game.GamePanel;
import main.space.invaders.gui.panel.game.RealTimePointsLabel;

public class SwingDistributor {

    private static final GamePanel gamePanel;
    private static final RealTimePointsLabel realTimePointsLabel;
    private static final ActivePlayerPanel activePlayerPanel;

    static {
        activePlayerPanel = new ActivePlayerPanel();
        realTimePointsLabel = new RealTimePointsLabel();
        gamePanel = new GamePanel();
    }

    public static GamePanel getGamePanel() {
        return gamePanel;
    }

    public static RealTimePointsLabel getRealTimePointsLabel() {
        return realTimePointsLabel;
    }

    public static ActivePlayerPanel getActivePlayerPanel() {
        return activePlayerPanel;
    }
}
