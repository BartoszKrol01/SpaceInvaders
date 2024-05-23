package main.space.invaders.drawable.shootable.spaceship;

import main.space.invaders.utils.FileLoader;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SpaceshipImagesService {

    private static final int SPACESHIPS_TO_LOAD = 2;
    private static final String SPACESHIP_PATH = "spaceship/spaceship_X.png";
    private static final Map<Integer, SpaceshipImage> spaceshipImages;

    static {
        spaceshipImages = new HashMap<>();
        for (int i = 1; i <= SPACESHIPS_TO_LOAD; i++) {
            SpaceshipImage image = new SpaceshipImage(FileLoader.loadImage(SPACESHIP_PATH.replaceAll("X", String.valueOf(i))));
            spaceshipImages.put(i, image);
        }
        spaceshipImages.get(1).setCurrent(true);
    }

    public static void setCurrentSpaceshipImage(Integer id) {
        findCurrentSpaceshipImage().setCurrent(false);
        Objects.requireNonNull(spaceshipImages.get(id)).setCurrent(true);
    }

    public static Image getCurrentSpaceshipImage() {
        return findCurrentSpaceshipImage().getImage();
    }

    private static SpaceshipImage findCurrentSpaceshipImage() {
        return spaceshipImages.values().stream()
                .filter(SpaceshipImage::isCurrent)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can not find current spaceship image"));
    }

    public static Map<Integer, SpaceshipImage> getSpaceshipImages() {
        return spaceshipImages;
    }
}
