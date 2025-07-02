package sn.ndiaye.views.textUIs.admin.subUIs.modify;

import sn.ndiaye.domain.QuizCard;
import sn.ndiaye.logic.Quiz;
import sn.ndiaye.logic.io.QuizzesLoader;
import sn.ndiaye.views.textUIs.TextUI;
import sn.ndiaye.views.textUIs.admin.subUIs.create.CreateQuizCardUI;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ModifyQuizUI extends TextUI {
    private List<Quiz> quizzes;
    private Quiz selectedQuiz;
    private QuizCard selectedQuizCard;
    private int selectedIndex;
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
        selectedQuiz = chooseFrom(quizzes);

    }

    public void modifyQuiz() {
        start();
        ModifyQuizMenu menuUI = new ModifyQuizMenu();
        menuUI.start();
    }

    public void removeQuiz() {
        start();
        quizzes.remove(selectedQuiz);
    }


    private List<Quiz> loadQuizzes() {
        System.out.println("File path: ");
        filePath = scanner.nextLine();
        List<Quiz> quizzes = QuizzesLoader.loadQuizzesFromFile(filePath);
        if (quizzes.isEmpty())
            return null;
        return quizzes;
    }


    private<T> T chooseFrom(List<T> list) {
        while(true) {
            show(list);
            String choice = scanner.nextLine();
            if (isValid(choice, list.size())) {
                selectedIndex = Integer.valueOf(choice);
                return list.get(selectedIndex);
            }
            System.out.println("Not a valid choice please choose again.");
        }
    }


    private<T> void show(List<T> list) {
        System.out.println("Please choose from this list");
        for (int i = 0; i < list.size(); i++) {
            String quizOption = i + "- " + list.get(i);
            System.out.println(quizOption);
        }
    }


    private boolean isValid(String choice, int maxBound) {
        boolean isValidChoice = false;
        try {
            int choiceVal = Integer.valueOf(choice);
            boolean inBounds = (choiceVal >= 0) && (choiceVal < maxBound);
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
        selectedQuizCard = chooseFrom(selectedQuiz.toList());
        ModifyQuizCardMenu menuUI = new ModifyQuizCardMenu();
        menuUI.start();
    }

    public void removeCard() {
        selectedQuizCard = chooseFrom(selectedQuiz.toList());
        selectedQuiz.toList().remove(selectedIndex);
        saveChanges();
    }


    public void renameQuiz() {
        showChange("theme" , selectedQuiz.getTheme());
        selectedQuiz.setTheme(getChange());
        saveChanges();
    }

    public void modifyQuestion() {
        showChange("question", selectedQuizCard.getQuestion());
        selectedQuizCard.setQuestion(getChange());
        saveChanges();
    }

    public void modifyCorrectAnswer() {
        showChange("correct answer", selectedQuizCard.getCorrectAnswer());
        selectedQuizCard.setCorrectAnswer(getChange());
        saveChanges();
    }

    private void showChange(String type, String value) {
        System.out.println("Old " + type + ": " + value);
        System.out.println("New " + type + ": ");
    }

    private String getChange() {
        String change = scanner.nextLine();
        return change;
    }

    public void modifyWrongAnswer() {
        String selectedWrongAnswer = chooseFrom(selectedQuizCard.getWrongAnswers());
        showChange("bad answer", selectedWrongAnswer);
        replaceWrongAnswer();
        saveChanges();
    }

    private void replaceWrongAnswer() {
        String modifiedWrongAnswer = getChange();
        selectedQuizCard.getWrongAnswers().remove(selectedIndex);
        selectedQuizCard.getWrongAnswers().add(modifiedWrongAnswer);
    }

    public void addWrongAnswer() {
        System.out.println("New wrong answer: ");
        String newAnswer = scanner.nextLine();
        selectedQuizCard.getWrongAnswers().add(newAnswer);
        saveChanges();
    }

    public void removeWrongAnswer() {
        chooseFrom(selectedQuizCard.getWrongAnswers());
        selectedQuizCard.getWrongAnswers().remove(selectedIndex);
        saveChanges();
    }

    @Override
    public void stop() {

    }



}
