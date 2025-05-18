package Java_Bootcamp.OOPs.Enums;

// Enum with fields, constructor, and methods
enum Size {
    SMALL("S", 1), MEDIUM("M", 2), LARGE("L", 3);

    private final String label;
    private final int level;

    // Private constructor
    Size(String label, int level) {
        this.label = label;
        this.level = level;
    }

    // Getter for label
    public String getLabel() {
        return label;
    }

    // Getter for level
    public int getLevel() {
        return level;
    }

    // Instance method
    public boolean isLarge() {
        return this == LARGE;
    }
}
