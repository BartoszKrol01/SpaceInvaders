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

    /*
        //implementation for repainting table's width and height causes NPE after super.paintComponent(g)
        //for now setRowHeight and setPreferredWidth stay hard coded
        // g is Graphics object

        double maxWidth = 0;
        double maxHeight = 0;
        TableModel model = this.getModel();
        FontMetrics metrics = g.getFontMetrics(SwingUtils.getDefaultFont(16));

        for (int i = 0; i < model.getRowCount(); i++) {
            String playerName = model.getValueAt(i, 0).toString();
            double currentWidth = metrics.stringWidth(playerName);
            double currentHeight = metrics.getHeight();
            if (maxWidth < currentWidth) {
                maxWidth = currentWidth;
            }
            if (maxHeight < currentHeight) {
                maxHeight = currentHeight;
            }
        }

        this.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(((int) maxWidth + PADDING));
        this.setRowHeight((int) maxHeight + PADDING);
    */
}
