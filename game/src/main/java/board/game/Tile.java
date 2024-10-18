package board.game;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {
    private static final int TILE_SIZE = 80;
    private final TileType type;
    private final String question;

    public Tile(TileType type, String question) {
        this.type = type;
        this.question = question;
        initializeTile();
    }

    private void initializeTile() {
        Rectangle background = createBackground();
        Label label = createLabel();
        getChildren().addAll(background, label);
        setAlignment(javafx.geometry.Pos.CENTER);
    }

    private Rectangle createBackground() {
        Rectangle background = new Rectangle(TILE_SIZE, TILE_SIZE);
        background.setStroke(Color.BLACK);
        background.setFill(type.getColor());
        return background;
    }

    private Label createLabel() {
        Label label = new Label(type == TileType.QUESTION ? question : type.getDisplayText());
        label.setWrapText(true);
        label.setMaxWidth(TILE_SIZE - (double) 10);
        return label;
    }
}