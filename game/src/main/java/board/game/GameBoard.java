package board.game;

import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import java.util.List;

public class GameBoard extends GridPane {
    private static final int BOARD_SIZE = 10;
    private final QuestionProvider questionProvider;

    public GameBoard(QuestionProvider questionProvider) {
        this.questionProvider = questionProvider;
        initializeBoard();
    }

    private void initializeBoard() {
        setGridLinesVisible(true);
        setAlignment(Pos.CENTER);
        createTiles();
    }

    private void createTiles() {
        List<String> questions = questionProvider.getQuestions();
        int questionIndex = 0;

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                TileType tileType = determineTileType(row, col);
                String question = tileType == TileType.QUESTION ? 
                    questions.get(questionIndex++ % questions.size()) : "";
                
                Tile tile = new Tile(tileType, question);
                add(tile, col, row);

                // Hide internal tiles
                tile.setVisible(isVisibleTile(row, col));
            }
        }
    }

    private boolean isVisibleTile(int row, int col) {
        return row == 0 || col == 0 || row == BOARD_SIZE - 1 || col == BOARD_SIZE - 1;
    }

    private TileType determineTileType(int row, int col) {
        if (isCorner(row, col)) {
            return TileType.CORNER;
        } else if (isBorder(row, col)) {
            return TileType.QUESTION;
        }
        return TileType.EMPTY;
    }

    private boolean isCorner(int row, int col) {
        return (row == 0 && col == 0) || 
               (row == 0 && col == BOARD_SIZE - 1) ||
               (row == BOARD_SIZE - 1 && col == 0) || 
               (row == BOARD_SIZE - 1 && col == BOARD_SIZE - 1);
    }

    private boolean isBorder(int row, int col) {
        return row == 0 || col == 0 || row == BOARD_SIZE - 1 || col == BOARD_SIZE - 1;
    }
}