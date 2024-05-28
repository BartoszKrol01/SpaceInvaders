package main.space.invaders.gui.panel.score;

import main.space.invaders.utils.SwingUtils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setFont(SwingUtils.getDefaultFont(20));
        component.setForeground(Color.GREEN);
        component.setBackground(SwingUtils.GUI_COLOR);
        return component;
    }
}
