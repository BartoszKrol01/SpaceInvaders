package main.space.invaders.gui.frame.menu.listener;

import main.space.invaders.exception.ScoreFileException;
import main.space.invaders.utils.file.FileLoader;

import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFileActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent ignored) {
        JFileChooser chooser = new JFileChooser();
        int userAction = chooser.showSaveDialog(null);
        if (userAction == JFileChooser.APPROVE_OPTION) {
            FileWriter selectedFile = FileLoader.getFileWriter(chooser.getSelectedFile(), false);
            BufferedReader scoreFile = FileLoader.getScoreFileReader();
            String line;
            try {
                while ((line = scoreFile.readLine()) != null) {
                    selectedFile.write(line + "\n");
                }
                selectedFile.flush();
                selectedFile.close();
                scoreFile.close();
            } catch (IOException e) {
                throw new ScoreFileException("Error while saving score file.", e);
            }
        }
    }
}
