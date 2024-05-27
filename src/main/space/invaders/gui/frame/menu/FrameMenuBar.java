package main.space.invaders.gui.frame.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FrameMenuBar extends JMenuBar {

    public FrameMenuBar() {
        JMenu howToPlayMenu = new JMenu("How to play?");

        JMenu fileMenu = new JMenu("File");

        JMenuItem saveFileMenuItem = new JMenuItem("Download score file");
        saveFileMenuItem.addActionListener(new FileMenuActionListener());

        fileMenu.add(saveFileMenuItem);

        this.add(howToPlayMenu);
        this.add(fileMenu);
    }
}
