package main.space.invaders.gui.panel.game.player;

import main.space.invaders.animator.PauseService;
import main.space.invaders.drawable.shootable.spaceship.SpaceshipImage;
import main.space.invaders.drawable.shootable.spaceship.SpaceshipImagesService;
import main.space.invaders.utils.SwingUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Map;

import static main.space.invaders.utils.SwingUtils.customizeJButton;

public class ChangeSpaceshipButton extends JButton {

    private static final String TITLE = "Spaceship edit mode";

    public ChangeSpaceshipButton() {
        customizeJButton(this);
        this.setBackground(SwingUtils.GUI_COLOR);
        this.setIcon(new ImageIcon(SpaceshipImagesService.getCurrentSpaceshipImage()));
        this.addActionListener(e -> {
            PauseService.pauseTheGame();
            JDialog dialog = addButtonsToJDialog();
            configureDialog(dialog);
        });
    }

    private static void configureDialog(JDialog dialog) {
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setTitle(TITLE);
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    private JDialog addButtonsToJDialog() {
        JDialog dialog = new JDialog();
        Map<Integer, SpaceshipImage> spaceshipImages = SpaceshipImagesService.getSpaceshipImages();
        dialog.setLayout(new GridLayout(1, spaceshipImages.size()));
        spaceshipImages
                .forEach((id, spaceshipImage) -> addJButtonToDialog(id, spaceshipImage, dialog));
        return dialog;
    }

    private void addJButtonToDialog(Integer spaceshipId, SpaceshipImage spaceshipImage, JDialog dialog) {
        JButton button = new JButton();
        button.setIcon(new ImageIcon(spaceshipImage.getImage()));
        button.setBackground(Color.BLACK);
        dialog.add(button);
        button.addActionListener(event -> {
            SpaceshipImagesService.setCurrentSpaceshipImage(spaceshipId);
            dialog.setVisible(false);
            this.setIcon(new ImageIcon(spaceshipImage.getImage()));
        });
    }
}
