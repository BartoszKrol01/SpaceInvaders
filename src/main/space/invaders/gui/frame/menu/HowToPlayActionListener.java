package main.space.invaders.gui.frame.menu;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlayActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog();
        JLabel label = new JLabel("""
                <html>
                       
                       <body style="color: green; background-color: black; font-size: 14px;">
                           <h1>Welcome!</h1>
                           <p>
                               <br>
                               <strong>How to play:</strong>
                               <ul>
                                   <li>Your aim, as a player, is to destroy all space invaders!</li>
                                   <li>Enemies will move towards your spaceship increasingly faster.</li>
                                   <li>You can maneuver your spaceship using arrows and shoot with the space key, as well as using the controller on the right.</li>
                                   <li>Configure settings to your liking!</li>
                                   <li>High scores will appear on the scoreboard if you emerge victorious.</li>
                               </ul>
                           </p>
                           <p>Thanks for playing and have fun!</p>
                           <em style="font-size: 10px;">Author: Bartosz Król</em><br>
                           <p style="font-size: 8px;">Image sources: "https://www.pngegg.com/"; "https://www.pngwing.com/" ; "https://icons8.com/icons"</p>
                       </body>
                       
                </html>""",
                SwingConstants.CENTER);
        dialog.add(label);

        dialog.pack();
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}
