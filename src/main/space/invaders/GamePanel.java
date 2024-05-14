package main.space.invaders;

import main.space.invaders.utils.MobDisplayUtils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static main.space.invaders.utils.ThreadUtils.sleep;

public class GamePanel extends JPanel implements Runnable {

    private final List<Mob> mobs;

    public GamePanel(List<Mob> mobs) {
        this.setBackground(Color.BLACK);
        this.mobs = mobs;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Mob mob : mobs) {
            mob.drawImage(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return MobDisplayUtils.getGameDimension();
    }

    @Override
    public void run() {
        while (true) {
            for (Mob mob : mobs) {
                mob.changeImage();
                sleep(30);
                repaint();
            }
        }
    }
}
