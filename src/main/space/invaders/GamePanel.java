package main.space.invaders;

import main.space.invaders.utils.GameDisplayUtils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static main.space.invaders.utils.ThreadUtils.sleep;

public class GamePanel extends JPanel {

    private final List<Drawable> drawables;

    public GamePanel(List<Drawable> drawables) {
        this.setBackground(Color.BLACK);
        this.drawables = drawables;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable drawable : drawables) {
            drawable.draw(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return GameDisplayUtils.getGameDimension();
    }
}
