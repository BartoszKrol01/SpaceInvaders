package main.space.invaders.drawable.shootable.mob;

import java.util.Arrays;

public enum MobType {
    LOWER(2, "mob/lower"),
    MIDDLE(2, "mob/middle"),
    UPPER(1, "mob/upper");

    private int rowsOccupied;
    private final String fileName;

    MobType(int rowsOccupied, String fileName) {
        this.rowsOccupied = rowsOccupied;
        this.fileName = fileName;
    }

    public static void calculateRowsOccupied(int newMobRowsValue) {
        Arrays.stream(MobType.values()).forEach(m -> m.rowsOccupied = 0);
        MobType mobType = LOWER;
        while (newMobRowsValue > 0) {
            mobType.rowsOccupied++;
            mobType = getNextMob(mobType);
            newMobRowsValue--;
        }
    }

    private static MobType getNextMob(MobType mobType) {
        return switch (mobType) {
            case LOWER -> MIDDLE;
            case MIDDLE -> UPPER;
            case UPPER -> LOWER;
        };
    }

    public int getRowsOccupied() {
        return rowsOccupied;
    }

    public String getFileName() {
        return fileName;
    }
}
