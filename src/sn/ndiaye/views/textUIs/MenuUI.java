package sn.ndiaye.views.textUIs;

import sn.ndiaye.views.textUIs.admin.subUIs.create.CreateQuizUI;
import sn.ndiaye.views.textUIs.admin.subUIs.display.ShowQuizzesUI;
import sn.ndiaye.views.textUIs.admin.subUIs.modify.ModifyQuizUI;
import sn.ndiaye.views.textUIs.player.GameUI;
import sn.ndiaye.views.util.Option;

public abstract class MenuUI extends TextUI {
    private final Option[] menuOptions;
    private final String menu;
    private boolean isExited;
    private static CreateQuizUI createQuizUI;
    private static ModifyQuizUI modifyQuizUI;


    public MenuUI(Option[] menuOptions) {
        this.menuOptions = menuOptions;
        menu = buildMenu();
        isExited = false;
    }

    private String buildMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Option option :  menuOptions)
            stringBuilder.append(option + "\n");
        return stringBuilder.toString();
    }

    @Override
    public void start() {
        while (true) {
            if (isExited)
                break;
            System.out.println(menu);
            readInputs();
        }
    }

    protected void readInputs() {
        try {
            int input = Integer.valueOf(scanner.nextLine());
            Option option = getOption(input);
            switch (option) {
                case ADD_QUIZ:
                    createQuizUI = new CreateQuizUI();
                    createQuizUI.start();
                    break;

                case MODIFY_QUIZ:
                    modifyQuizUI = new ModifyQuizUI();
                    modifyQuizUI.modifyQuiz();
                    break;

                case REMOVE_QUIZ:
                    modifyQuizUI = new ModifyQuizUI();
                    modifyQuizUI.removeQuiz();
                    break;

                case SHOW_QUIZZES:
                    new ShowQuizzesUI().start();
                    break;

                case DO_QUIZ:
                    new GameUI().start();
                    break;

                case ADD_CARD:
                    modifyQuizUI.addCard();
                    break;

                case MODIFY_CARD:
                    modifyQuizUI.modifyCard();
                    break;

                case REMOVE_CARD:
                    modifyQuizUI.removeCard();
                    break;

                case RENAME_QUIZ:
                    modifyQuizUI.renameQuiz();
                    break;

                case MODIFY_QUESTION:
                    modifyQuizUI.modifyQuestion();
                    break;

                case MODIFY_CORRECT_ANSWER:
                    modifyQuizUI.modifyCorrectAnswer();
                    break;

                case MODIFY_WRONG_ANSWER:
                    modifyQuizUI.modifyWrongAnswer();
                    break;

                case ADD_WRONG_ANSWER:
                    modifyQuizUI.addWrongAnswer();
                    break;

                case REMOVE_WRONG_ANSWER:
                    modifyQuizUI.removeWrongAnswer();
                    break;

                case QUIT:
                    stop();
                    break;

                default:
                    System.out.println("Please enter a valid input");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
        }
    }

    protected Option getOption(int input) {
        for (Option option : menuOptions) {
            if (input == option.getAccessNumber())
                return option;
        }
        return Option.NULL;
    }

    @Override
    public void stop() {
        isExited = true;
    }

}
