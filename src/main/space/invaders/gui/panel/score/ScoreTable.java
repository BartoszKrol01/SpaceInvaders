package main.space.invaders.gui.panel.score;

import main.space.invaders.player.HighScore;
import main.space.invaders.player.HighScoreService;
import main.space.invaders.player.Player;
import main.space.invaders.player.ScoreCounter;
import main.space.invaders.utils.SwingUtils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ScoreTable extends JTable {

    public ScoreTable() {
        super();
        CustomTableCellRenderer cellRenderer = new CustomTableCellRenderer();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Player");
        model.addColumn("Score");
        List<HighScore> highScores = HighScoreService.getHighScores();
        addHighScores(highScores, model);
        this.setModel(model);

        this.getTableHeader().setOpaque(false);
        this.getTableHeader().setBackground(SwingUtils.GUI_COLOR);
        SwingUtils.setFontAndForegroundColor(this.getTableHeader());

        this.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        this.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);

        this.getColumnModel().getColumn(0).setPreferredWidth((200));
        this.getColumnModel().getColumn(1).setMaxWidth((100));
        this.setRowHeight(30);

        this.setEnabled(false);
    }

    public void addScoreToBoard() {
        String activePlayerName = Player.getActivePlayer().getName();
        DefaultTableModel model = (DefaultTableModel) this.getModel();

        List<HighScore> highScores = HighScoreService.updateAndGetHighScores(new HighScore(activePlayerName, ScoreCounter.getScore()));
        removeAllRows(model);
        addHighScores(highScores, model);
    }

    private static void addHighScores(List<HighScore> highScores, DefaultTableModel model) {
        highScores.forEach(h -> model.addRow(new Object[]{h.getPlayerName(), h.getScore()}));
    }

    private void removeAllRows(DefaultTableModel model) {
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

}
