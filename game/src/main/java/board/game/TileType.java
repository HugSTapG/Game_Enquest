package board.game;

import javafx.scene.paint.Color;

public enum TileType {
    CORNER("Corner", Color.LIGHTBLUE),
    QUESTION("?", Color.LIGHTGRAY),
    EMPTY("", Color.WHITE);

    private final String displayText;
    private final Color color;

    TileType(String displayText, Color color) {
        this.displayText = displayText;
        this.color = color;
    }

    public String getDisplayText() {
        return displayText;
    }

    public Color getColor() {
        return color;
    }
}