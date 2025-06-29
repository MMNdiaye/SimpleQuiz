package sn.ndiaye.logic.io;

import sn.ndiaye.domain.QuizCard;
import sn.ndiaye.logic.Quiz;

import java.io.*;
import java.util.List;

public final class QuizzesLoader {

    public static List<Quiz> loadQuizzesFromFile(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(filePath));
        List<List<QuizCard>> quizCardDecks = (List<List<QuizCard>>) input.readObject();
        List<Quiz> quizzes = quizCardDecks.stream().
                map(quizCards -> Quiz.of(quizCards)).
                toList();
        return quizzes;
    }

    public static void saveQuizToFile(Quiz quiz, String filePath) throws IOException, ClassNotFoundException {
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(filePath));
        List<Quiz> quizzes = loadQuizzesFromFile(filePath);
        quizzes.add(quiz);
        List<List<QuizCard>> quizCardDecks = quizzes.stream()
                .map(quizElement -> quizElement.toList()).
                toList();
        output.writeObject(quizCardDecks);
    }
}
