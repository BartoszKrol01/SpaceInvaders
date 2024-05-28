package main.space.invaders.gui.panel.score;

import main.space.invaders.utils.SwingUtils;
import main.space.invaders.utils.distribution.SwingDistributor;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class ScoreBoardPanel extends JPanel {

    public ScoreBoardPanel() {
        this.setBackground(SwingUtils.GUI_COLOR);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(SwingDistributor.getScoreTable());
        scrollPane.getViewport().setBackground(SwingUtils.GUI_COLOR);
        scrollPane.setBorder(new LineBorder(SwingUtils.GUI_COLOR, 0)); //to delete default border
//        scrollPane.setVisible(false);//todo: setvisible in settings
        this.add(scrollPane);
    }
}
