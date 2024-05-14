package main.space.invaders;

import main.space.invaders.utils.MobDisplayUtils;

import java.awt.*;
import java.util.Objects;

import static main.space.invaders.utils.MobDisplayUtils.FIRST_MOB_POSSIBLE_STEPS_DOWN;
import static main.space.invaders.utils.MobDisplayUtils.MOB_POSSIBLE_STEPS_SIDE;
import static main.space.invaders.utils.MobDisplayUtils.MOB_STEP_SIZE;
import static main.space.invaders.utils.MobDisplayUtils.TOTAL_MOB_SIZE;

public class Mob {

    private final Image stay;
    private final Image go;
    private Image currentImage;
    private int xLocation;
    private int yLocation;
    private int horizontalStepsCounter;
    private int direction;
    private int verticalStepsCounter;
    private final int startRow;

    public Mob(Image stay, Image go, int xLocation, int yLocation, int startRow) {
        this.stay = stay;
        this.go = go;
        this.currentImage = stay;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.horizontalStepsCounter = 0;
        this.verticalStepsCounter = 0;
        this.direction = 1;
        this.startRow = startRow;
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
        if (horizontalStepsCounter >= MOB_POSSIBLE_STEPS_SIDE) {
            horizontalStepsCounter = 0;
            yLocation += TOTAL_MOB_SIZE;
            verticalStepsCounter++;
            checkIfGameIsOver();
            direction = direction * -1;
        } else {
            xLocation += direction * MOB_STEP_SIZE;
            horizontalStepsCounter++;
        }
    }

    private void checkIfGameIsOver() {
        if (verticalStepsCounter >= FIRST_MOB_POSSIBLE_STEPS_DOWN + startRow) {
            System.out.println("I've won - x -> " + xLocation + " y -> " + yLocation);
            System.out.println("GAME OVER!!!!!");
            throw new RuntimeException();
            //todo: handle win
        }
    }
}
