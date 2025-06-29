package sn.ndiaye.views.textUIs.admin.subUIs;

import sn.ndiaye.domain.QuizCard;
import sn.ndiaye.logic.Quiz;
import sn.ndiaye.logic.io.QuizzesLoader;
import sn.ndiaye.views.textUIs.TextUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewQuizUI extends TextUI {

    public NewQuizUI() {
        super();
    }

    @Override
    public void start() {
        readInputs();
    }

    @Override
    public void stop() {

    }

    @Override
    protected void readInputs() {
        List<QuizCard> quizCards = createCards();
        Quiz quiz = createQuiz(quizCards);
        saveQuiz(quiz);
    }

    private List<QuizCard> createCards() {
        List<QuizCard> quizCards = new ArrayList<>();
        while (true) {
            QuizCard newCard = initializeQuestion();
            addAnswerToQuizCard(newCard);
            quizCards.add(newCard);
            System.out.println("QuizCard added successfully");
            if (hasFinishedAdding())
                break;
        }
        return quizCards;
    }

    private Quiz createQuiz(List<QuizCard> quizCards) {
        Quiz newQuiz = Quiz.of(quizCards);
        System.out.println("Quiz theme:");
        String theme = scanner.nextLine();
        newQuiz.setTheme(theme);
        return newQuiz;
    }

    private void saveQuiz(Quiz quiz) {
        System.out.println("Quiz created successfully. File path to save it:");
        String filePath = scanner.nextLine();
        try {
            QuizzesLoader.saveQuizToFile(quiz, filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }



    private QuizCard initializeQuestion() {
        QuizCard quizCard = new QuizCard();
        System.out.println("Enter a new Question:");
        quizCard.setQuestion(scanner.nextLine());
        return quizCard;
    }

    private void addAnswerToQuizCard(QuizCard quizCard) {
        System.out.println("Enter the correct answer:");
        quizCard.setCorrectAnswer(scanner.nextLine());
        addEnoughWrongAnswers(quizCard);
    }

    private void addEnoughWrongAnswers(QuizCard quizCard) {
        boolean hasEnoughAnswers;
        while (true) {
            System.out.println("Add a wrong answer:");
            quizCard.addWrongAnswer(scanner.nextLine());
            hasEnoughAnswers = quizCard.getWrongAnswers().size() > 1;
            if (!hasEnoughAnswers)
                continue;
            if (hasFinishedAdding())
                break;
        }
    }

    private boolean hasFinishedAdding() {
        boolean hasFinished;
        System.out.println("Continue? y/n");
        String continuationAnswer = scanner.nextLine().toLowerCase();
        hasFinished = continuationAnswer.equals("n");
        return hasFinished;
    }


}
