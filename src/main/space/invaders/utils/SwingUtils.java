package main.space.invaders.utils;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;

public class SwingUtils {

    public static final Color GUI_COLOR;

    static {
        GUI_COLOR = new Color(16, 18, 16);
    }

    public static void setFontAndForegroundColor(JComponent component) {
        setFontAndForegroundColor(component, 20);
    }

    public static void setFontAndForegroundColor(JComponent component, int size) {
        component.setFont(new Font(Font.MONOSPACED, Font.BOLD, size));
        component.setForeground(Color.GREEN);
    }

    public static void customizeJButton(JButton button) {
        button.setFocusable(false);
        button.setBorderPainted(false);
    }
}
