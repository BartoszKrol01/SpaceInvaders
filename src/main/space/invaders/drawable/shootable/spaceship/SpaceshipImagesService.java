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
    private static final String CURRENT_SPACESHIP_ERROR = "Can not find current spaceship ";
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

    public static Integer getCurrentSpaceshipImageId() {
        for (Map.Entry<Integer, SpaceshipImage> entry : spaceshipImages.entrySet()) {
            if (entry.getValue().isCurrent()) {
                return entry.getKey();
            }
        }
        throw getNoSuchElementException("id");
    }

    private static SpaceshipImage findCurrentSpaceshipImage() {
        return spaceshipImages.values().stream()
                .filter(SpaceshipImage::isCurrent)
                .findFirst()
                .orElseThrow(() -> getNoSuchElementException("image"));
    }

    private static NoSuchElementException getNoSuchElementException(String info) {
        return new NoSuchElementException(CURRENT_SPACESHIP_ERROR + info);
    }

    public static Map<Integer, SpaceshipImage> getSpaceshipImages() {
        return spaceshipImages;
    }
}
