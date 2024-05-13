package main.space.invaders;

import main.space.invaders.utils.MobDisplayUtils;

import java.awt.*;
import java.util.Objects;

public class Mob {

    private final Image stay;
    private final Image go;
    private Image currentImage;
    private int xLocation;
    private int yLocation;
    private int stepsInRowCounter;
    private int direction;

    public Mob(Image stay, Image go, int xLocation, int yLocation) {
        this.stay = stay;
        this.go = go;
        currentImage = stay;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.stepsInRowCounter = 0;
        this.direction = 1;
    }

    public void drawImage(Graphics g) {
        g.drawImage(currentImage, xLocation, yLocation, null);
    }

    public void changeImage() {
        if (Objects.equals(currentImage, stay)) {
            currentImage = go;
        } else {
            currentImage = stay;
        }
        updateLocation();
    }

    private void updateLocation() {
        if (stepsInRowCounter == MobDisplayUtils.MOB_POSSIBLE_STEPS_IN_ONE_ROW) {
            stepsInRowCounter = 0;
            yLocation += MobDisplayUtils.TOTAL_MOB_SIZE;
            direction = direction * -1;
        } else {
            xLocation += direction * MobDisplayUtils.MOB_STEP_SIZE;
            stepsInRowCounter++;
        }
    }
}
