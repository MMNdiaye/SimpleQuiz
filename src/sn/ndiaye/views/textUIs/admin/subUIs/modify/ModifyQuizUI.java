package sn.ndiaye.views.textUIs.admin.subUIs.modify;

import sn.ndiaye.domain.QuizCard;
import sn.ndiaye.logic.Quiz;
import sn.ndiaye.logic.io.QuizzesLoader;
import sn.ndiaye.views.textUIs.TextUI;
import sn.ndiaye.views.textUIs.admin.subUIs.create.CreateQuizCardUI;

import java.util.List;

public class ModifyQuizUI extends TextUI {
    private List<Quiz> quizzes;
    private Quiz selectedQuiz;

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
        ModifyQuizMenu menuUI = new ModifyQuizMenu(this);
        menuUI.start();
    }


    private List<Quiz> loadQuizzes() {
        System.out.println("File path: ");
        String filePath = scanner.nextLine();
        List<Quiz> quizzes = QuizzesLoader.loadQuizzesFromFile(filePath);
        if (quizzes.isEmpty())
            return null;
        return quizzes;
    }

    private Quiz chooseQuiz() {
        while (true) {
            showQuizzes(quizzes);
            String choice = scanner.nextLine();
            if (isValid(choice))
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

    private boolean isValid(String choice) {
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
        QuizCard quizCard = new CreateQuizCardUI().createQuizCard();
        selectedQuiz.toList().add(quizCard);
    }



    @Override
    public void stop() {

    }

    public static void main(String[] args) {
        ModifyQuizUI modifyQuizUI = new ModifyQuizUI();
        modifyQuizUI.start();
    }
}
