package main.space.invaders.utils.distribution;

import main.space.invaders.gui.frame.GameFrame;
import main.space.invaders.gui.panel.FramePanel;
import main.space.invaders.gui.panel.game.CenterPanel;
import main.space.invaders.gui.panel.game.GamePanel;
import main.space.invaders.gui.panel.game.RealTimePointsLabel;
import main.space.invaders.gui.panel.game.player.ActivePlayerPanel;

import javax.swing.JPanel;

public class SwingDistributor {

    private static GamePanel gamePanel;
    private static RealTimePointsLabel realTimePointsLabel;
    private static ActivePlayerPanel activePlayerPanel;
    private static CenterPanel centerPanel;
    private static GameFrame gameFrame;

    public static void initialize() {
        realTimePointsLabel = new RealTimePointsLabel();
        activePlayerPanel = new ActivePlayerPanel();
        JPanel gameWrapper = new JPanel();
        gamePanel = new GamePanel(gameWrapper);
        centerPanel = new CenterPanel(gameWrapper);
        gameFrame = new GameFrame(new FramePanel());
    }

    public static CenterPanel getCenterPanel() {
        return centerPanel;
    }

    public static GameFrame getGameFrame() {
        return gameFrame;
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
