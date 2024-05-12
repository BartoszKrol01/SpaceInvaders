package main.space.invaders;

import main.space.invaders.utils.FileLoader;

import java.awt.*;
import java.util.Objects;

public class Mob {

    private final Image stay;
    private final Image go;
    private Image currentImage;

    public Mob(String fileName) {
        this.stay = FileLoader.loadImage(fileName + "_1.png");
        this.go = FileLoader.loadImage(fileName + "_2.png");
        currentImage = stay;
    }

    public void drawImage(Graphics g) {
        g.drawImage(currentImage, 20, 20 , null);
    }

    public void changeImage() {
        if (Objects.equals(currentImage, stay)) {
            currentImage = go;
        } else {
            currentImage = stay;
        }
    }
}
