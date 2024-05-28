package main.space.invaders.utils.file;

import main.space.invaders.exception.FileLoadException;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class FileLoader {

    private static final String RESOURCE_PATH;
    private static final String PNG = ".png";

    static {
        RESOURCE_PATH = Paths.get(".").normalize().toAbsolutePath() + "/resources/";
    }

    public static Image loadImage(String fileName) {
        Image image;
        String url = RESOURCE_PATH + fileName + PNG;
        try {
            image = ImageIO.read(new File(url));
        } catch (IOException e) {
            throw new FileLoadException("Error occurred while reading input file " + url, e);
        }
        return Objects.requireNonNull(image);
    }

    public static BufferedReader getScoreFileReader() {
        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader(getScoreFile()));
        } catch (FileNotFoundException e) {
            throw new FileLoadException("Error occurred while reading input file ", e);
        }
        return file;
    }

    public static FileWriter getScoreFileWriter() {
        return getFileWriter(getScoreFile(), true);
    }

    public static FileWriter getFileWriter(File file, boolean append) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, append);
        } catch (IOException e) {
            throw new FileLoadException("Error occurred while reading input file", e);
        }
        return fileWriter;
    }

    private static File getScoreFile() {
        String fileName = "score.txt";
        return new File(RESOURCE_PATH + "/score/" + fileName);
    }
}
