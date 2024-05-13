package main.space.invaders.utils;

import main.space.invaders.exception.FileLoadException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class FileLoader {

    private static final String resourcePath;

    static {
        resourcePath = Paths.get(".").normalize().toAbsolutePath() + "/resources/mob/";
    }

    public static Image loadImage(String fileName) {
        Image image;
        String url = resourcePath + fileName;
        try {
            image = ImageIO.read(new File(url));
        } catch (IOException e) {
            throw new FileLoadException("Error occurred while loading file " + url, e);
        }
        return Objects.requireNonNull(image);
    }
}
