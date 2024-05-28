package main.space.invaders.utils;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;

public class SwingUtils {

    public static final Color GUI_COLOR;
    private static final int DEFAULT_FONT_SIZE = 20;

    static {
        GUI_COLOR = new Color(16, 18, 16);
    }

    public static void setFontAndForegroundColor(JComponent component) {
        setFontAndForegroundColor(component, DEFAULT_FONT_SIZE);
    }

    public static void setFontAndForegroundColor(JComponent component, int size) {
        Font font = new Font(Font.MONOSPACED, Font.BOLD, size);
        component.setFont(font);
        component.setForeground(Color.GREEN);
    }

    public static void customizeJButton(JButton button) {
        button.setFocusable(false);
        button.setBorderPainted(false);
    }

    public static void setForegroundDisabled(JComponent component, boolean isSelected) {
        if (isSelected) {
            component.setForeground(Color.GREEN);
        } else {
            component.setForeground(Color.LIGHT_GRAY);
        }
    }

    public static Font getDefaultFont(int size) {
        return new Font(Font.MONOSPACED, Font.BOLD, size);
    }
}
