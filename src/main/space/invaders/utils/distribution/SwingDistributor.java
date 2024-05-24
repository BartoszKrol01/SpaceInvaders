package main.space.invaders.utils.distribution;

import main.space.invaders.gui.panel.game.GamePanel;
import main.space.invaders.gui.panel.game.RealTimePointsLabel;

public class SwingDistributor {

    private static final GamePanel gamePanel;
    private static final RealTimePointsLabel realTimePointsLabel;

    static {
        gamePanel = new GamePanel();
        realTimePointsLabel = new RealTimePointsLabel();
    }

    public static GamePanel getGamePanel() {
        return gamePanel;
    }

    public static RealTimePointsLabel getRealTimePointsLabel() {
        return realTimePointsLabel;
    }
}
