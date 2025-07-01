package sn.ndiaye.views.textUIs.admin.subUIs.modify;

import sn.ndiaye.domain.QuizCard;
import sn.ndiaye.logic.Quiz;
import sn.ndiaye.logic.io.QuizzesLoader;
import sn.ndiaye.views.textUIs.TextUI;
import sn.ndiaye.views.textUIs.admin.subUIs.create.CreateQuizCardUI;

import java.io.IOException;
import java.util.List;

public class ModifyQuizUI extends TextUI {
    private List<Quiz> quizzes;
    private Quiz selectedQuiz;
    private QuizCard selectedQuizCard;
    private String filePath;

    @Override
    public void start() {
        readInputs();
    }


    @Override
    protected void readInputs() {
        quizzes = loadQuizzes();
        if (quizzes == null) {
            System.out.println("No quiz saved in this file");
            return;
        }
        selectedQuiz = chooseQuiz();
        ModifyQuizMenu menuUI = new ModifyQuizMenu();
        menuUI.start();
    }


    private List<Quiz> loadQuizzes() {
        System.out.println("File path: ");
        filePath = scanner.nextLine();
        List<Quiz> quizzes = QuizzesLoader.loadQuizzesFromFile(filePath);
        if (quizzes.isEmpty())
            return null;
        return quizzes;
    }

    private Quiz chooseQuiz() {
        while (true) {
            showQuizzes(quizzes);
            String choice = scanner.nextLine();
            if (isValid(choice, quizzes.size()))
                return quizzes.get(Integer.valueOf(choice));
            System.out.println("Not a valid choice please choose again.");
        }
    }

    private void showQuizzes(List<Quiz> quizzes) {
        System.out.println("Please choose the quiz to edit");
        for (int i = 0; i < quizzes.size(); i++) {
            String quizOption = i + "- " + quizzes.get(i);
            System.out.println(quizOption);
        }
    }

    private boolean isValid(String choice, int maxBound) {
        boolean isValidChoice = false;
        try {
            int choiceVal = Integer.valueOf(choice);
            boolean inBounds = (choiceVal >= 0) && (choiceVal < quizzes.size());
            if (inBounds)
                isValidChoice = true;
        } catch (NumberFormatException e) {

        }
        return isValidChoice;
    }

    public void addCard() {
        QuizCard newQuizCard = new CreateQuizCardUI().createQuizCard();
        Quiz modifiedQuiz = modifyQuiz(newQuizCard);
        modifiedQuiz.setTheme(selectedQuiz.getTheme());
        selectedQuiz = modifiedQuiz;
        saveChanges();
    }

    private Quiz modifyQuiz(QuizCard quizCard) {
        List<QuizCard> modifiedQuizCards = selectedQuiz.toList();
        modifiedQuizCards.add(quizCard);
        return Quiz.of(modifiedQuizCards);
    }

    private void saveChanges() {
        try {
            QuizzesLoader.saveQuizzesToFile(quizzes,filePath);
        } catch (IOException e) {
            System.out.println("Couldn't save changes");
        }
    }

    public void modifyCard() {
        selectedQuizCard = chooseQuizCard();
        ModifyQuizCardMenu menuUI = new ModifyQuizCardMenu();
        menuUI.start();
    }

    public void removeCard() {

    }

    private void showQuizCards(List<QuizCard> quizCards) {
        for (int i = 0; i < quizCards.size(); i++) {
            String quizCardOption = i + "- " + quizCards.get(i);
            System.out.println(quizCardOption);
        }
    }

    private QuizCard chooseQuizCard() {
        List<QuizCard> quizCards = selectedQuiz.toList();
        QuizCard chosenQuizCard;
        showQuizCards(quizCards);
        while (true) {
            String choice = scanner.nextLine();
            if (isValid(choice, quizCards.size())) {
                chosenQuizCard = quizCards.get(Integer.valueOf(choice));
                break;
            }
        }
        return chosenQuizCard;

    }

    public void modifyQuestion() {
        System.out.println("Old question: " + selectedQuizCard.getQuestion());
        System.out.println("New question: ");
        String newQuestion = scanner.nextLine();
        selectedQuizCard.setQuestion(newQuestion);
        saveChanges();
        System.out.println(QuizzesLoader.loadQuizzesFromFile(filePath).get(0).toList());
    }

    public void modifyCorrectAnswer() {
        System.out.println("Old correct answer: " + selectedQuizCard.
                getCorrectAnswer());
        System.out.println("New answer: ");
        String newAnswer = scanner.nextLine();
        selectedQuizCard.setCorrectAnswer(newAnswer);
        saveChanges();
    }


    @Override
    public void stop() {

    }



}
