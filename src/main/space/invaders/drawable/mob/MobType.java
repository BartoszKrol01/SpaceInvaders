package main.space.invaders.drawable.mob;

public enum MobType {
    LOWER(2, "mob/lower"),
    MIDDLE(2, "mob/middle"),
    UPPER(1, "mob/upper");

    private int rowsOccupied;
    private String fileName;

    MobType(int rowsOccupied, String fileName) {
        this.rowsOccupied = rowsOccupied;
        this.fileName = fileName;
    }

    public int getRowsOccupied() {
        return rowsOccupied;
    }

    public String getFileName() {
        return fileName;
    }
}
