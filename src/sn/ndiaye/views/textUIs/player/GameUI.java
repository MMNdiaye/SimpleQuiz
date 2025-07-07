package sn.ndiaye.views.textUIs.player;

import sn.ndiaye.domain.QuizCard;
import sn.ndiaye.logic.Deque;
import sn.ndiaye.logic.Shuffler;
import sn.ndiaye.logic.Quiz;
import sn.ndiaye.logic.io.QuizzesLoader;
import sn.ndiaye.views.textUIs.ChoiceUI;
import sn.ndiaye.views.textUIs.TextUI;

import java.util.ArrayList;
import java.util.List;

public class GameUI extends TextUI {
    private Quiz selectedQuiz;
    private List<String> currentPossibleAnswers;
    private int questionCount;
    private int score;

    @Override
    public void start() {
        readInputs();
    }

    @Override
    protected void readInputs() {
        System.out.println("Choose a quiz");
        chooseQuiz();
        for (QuizCard quizCard : selectedQuiz) {
            questionCount++;
            showQuizCard(quizCard);
            int playerInput = ChoiceUI.selectIndexFromList(currentPossibleAnswers);
            String playerAnswer = currentPossibleAnswers.get(playerInput);
            checkAnswer(quizCard, playerAnswer);
            displayScore();
        }
    }

    private void chooseQuiz() {
        List<Quiz> quizzes = loadQuizzes();
        int selectedQuizIndex = ChoiceUI.selectIndexFromList(quizzes);
        selectedQuiz = quizzes.get(selectedQuizIndex);
    }

    private List<Quiz> loadQuizzes() {
        System.out.println("File path: ");
        String filePath = scanner.nextLine();
        List<Quiz> quizzes = QuizzesLoader.loadQuizzesFromFile(filePath);
        return quizzes;
    }

    private void showQuizCard(QuizCard quizCard) {
        System.out.println(quizCard.getQuestion());
        currentPossibleAnswers = quizCard.getAllAnswers();
    }

    private void checkAnswer(QuizCard quizCard, String playerAnswer) {
        String correctAnswer = quizCard.getCorrectAnswer();
        if (playerAnswer.equals(correctAnswer)) {
            System.out.println("Good job!");
            score++;
        }
        else
            System.out.println("Wrong! The correct answer was :" + correctAnswer);
    }

    private void displayScore() {
        String completeScore = score + "/" + questionCount;
        System.out.println("Current score :" + completeScore);
    }

    @Override
    public void stop() {

    }
}
