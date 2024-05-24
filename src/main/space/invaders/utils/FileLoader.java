package main.space.invaders.utils;

import main.space.invaders.exception.FileLoadException;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class FileLoader {

    private static final String RESOURCE_PATH;
    private static final String FILE_EXTENSION = ".png";

    static {
        RESOURCE_PATH = Paths.get(".").normalize().toAbsolutePath() + "/resources/";
    }

    public static Image loadImage(String fileName) {
        Image image;
        String url = RESOURCE_PATH + fileName + FILE_EXTENSION;
        try {
            image = ImageIO.read(new File(url));
        } catch (IOException e) {
            throw new FileLoadException("Error occurred while reading input file " + url, e);
        }
        return Objects.requireNonNull(image);
    }
}
