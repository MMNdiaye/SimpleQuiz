package sn.ndiaye.views.textUIs;

import sn.ndiaye.views.util.Option;

import java.util.Scanner;

public abstract class MenuUI extends TextUI {
    private final Option[] menuOptions;
    private final String menu;
    private boolean isExited;

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
                    //createQuiz();
                    break;

                case MODIFY_QUIZ:
                    break;

                case REMOVE_QUIZ:
                    break;

                case DO_QUIZ:
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
        return null;
    }

    @Override
    public void stop() {
        scanner.close();
        isExited = true;
    }

}
