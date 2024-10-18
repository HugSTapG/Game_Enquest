package board.game;

import java.util.List;
import java.util.ArrayList;

public class QuestionProvider {
    public List<String> getQuestions() {
        List<String> questions = new ArrayList<>();
        // Add your questions here
        questions.add("What is the capital of France?");
        questions.add("Who wrote Romeo and Juliet?");
        questions.add("What is 2 + 2?");
        // Add more questions...
        return questions;
    }
}