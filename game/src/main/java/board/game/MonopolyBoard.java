package board.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MonopolyBoard extends Application {
    private static final int WINDOW_SIZE = 800;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Monopoly Board Example");
        
        QuestionProvider questionProvider = new QuestionProvider();
        GameBoard gameBoard = new GameBoard(questionProvider);
        
        Scene scene = new Scene(gameBoard, WINDOW_SIZE, WINDOW_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}