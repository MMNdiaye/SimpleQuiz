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
            quizzes = (List<Quiz>) input.readObject();

        } catch (IOException  | ClassNotFoundException e) {
            //Couldn't read further
        }
        return quizzes;
    }

    public static void saveQuizzesToFile(List<Quiz> quizzes, String filePath) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream((filePath)));
        output.writeObject(quizzes);
    }

    public static void saveQuizToFile(Quiz quiz, String filePath) throws IOException, ClassNotFoundException {
        List<Quiz> quizzes = loadQuizzesFromFile(filePath);
        quizzes.add(quiz);
        saveQuizzesToFile(quizzes, filePath);
    }
}
