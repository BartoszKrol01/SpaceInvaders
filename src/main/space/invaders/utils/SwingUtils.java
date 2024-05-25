package main.space.invaders.utils;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;

public class SwingUtils {

    public static final Color GUI_COLOR;
    public static final Font GUI_FONT;

    static {
        GUI_COLOR = new Color(16, 18, 16);
        GUI_FONT = new Font(Font.MONOSPACED, Font.BOLD, 20);
    }

    public static void setFontAndForegroundColor(JComponent component) {
        component.setFont(GUI_FONT);
        component.setForeground(Color.GREEN);
    }

    public static void customizeJButton(JButton button) {
        button.setFocusable(false);
        button.setBorderPainted(false);
    }
}
