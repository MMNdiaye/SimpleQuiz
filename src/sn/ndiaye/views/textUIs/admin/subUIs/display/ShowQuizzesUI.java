package sn.ndiaye.views.textUIs.admin.subUIs.display;

import sn.ndiaye.logic.Quiz;
import sn.ndiaye.logic.io.QuizzesLoader;
import sn.ndiaye.views.textUIs.TextUI;
import java.util.List;

public class ShowQuizzesUI extends TextUI {
    private String filePath;
    private List<Quiz> quizzes;

    @Override
    public void start() {
        while (true) {
            readInputs();
            loadQuizzes();
            if (quizzes.isEmpty())
                System.out.println("No quiz saved in this file");
            else
                showQuizzes();

           if (!isContinued())
               break;

        }

    }

    private boolean isContinued() {
        System.out.println();
        System.out.println("Continue? y/n");
        String response = scanner.nextLine().toLowerCase();
        return response == "y";
    }

    private void loadQuizzes() {
        quizzes = QuizzesLoader.loadQuizzesFromFile(filePath);

    }

    private void showQuizzes() {
        for (Quiz quiz : quizzes) {
            System.out.print("\nQuiz: ");
            System.out.print(quiz);
            System.out.print("\nCards: ");
            quiz.toList().forEach(quizCard -> System.out.print("{"+quizCard + "}, "));
        }
    }

    @Override
    public void stop() {

    }

    @Override
    protected void readInputs() {
        System.out.println("File path: ");
        filePath = scanner.nextLine();
    }
}
