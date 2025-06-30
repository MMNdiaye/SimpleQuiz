package sn.ndiaye.logic.io;

import sn.ndiaye.domain.QuizCard;
import sn.ndiaye.logic.Quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class QuizzesLoader {

    public static List<Quiz> loadQuizzesFromFile(String filePath) {
        List<Quiz> quizzes = new ArrayList<>();
        try {
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream(filePath));
            while (true) {
                List<QuizCard> quizCards = (List<QuizCard>) input.readObject();
                String theme = (String) input.readObject();
                Quiz quiz = Quiz.of(quizCards);
                quiz.setTheme(theme);
                quizzes.add(quiz);
            }

        } catch (IOException  | ClassNotFoundException e) {
            //Couldn't read further
        }
        return quizzes;
    }

    public static void saveQuizToFile(Quiz quiz, String filePath) throws IOException, ClassNotFoundException {
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(filePath));
        List<Quiz> quizzes = loadQuizzesFromFile(filePath);
        quizzes.add(quiz);
        quizzes.stream().forEach(qz -> {
            try {
                output.writeObject(qz.toList());
                output.writeObject(qz.getTheme());
            } catch (IOException e) {

            }
        });
    }
}
