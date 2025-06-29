package sn.ndiaye.views;

import sn.ndiaye.domain.QuizCard;
import sn.ndiaye.logic.Quiz;
import sn.ndiaye.views.util.Option;


import java.util.Scanner;

public class AdminTextUI implements UserInterface{
    private final Scanner scanner;
    private static final Option[] menuOptions = {Option.ADD_QUIZ,
            Option.MODIFY_QUIZ, Option.QUIT};
    private static final String menu = buildMenu();


    public AdminTextUI() {
        scanner = new Scanner(System.in);
    }

    private static String buildMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Option option :  menuOptions)
            stringBuilder.append(option + "\n");
        return stringBuilder.toString();
    }

    @Override
    public void start() {
        boolean isExited = false;
        while (true) {

            if (isExited)
                break;

            System.out.println(menu);
            try {
                int input = Integer.valueOf(scanner.nextLine());
                switch (input) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 0:
                        isExited = true;
                        break;
                    default:
                        System.out.println("Please enter a valid input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }

        }
    }

    @Override
    public void stop() {

    }

    public static void main(String[] args) {
        AdminTextUI ui = new AdminTextUI();
        ui.start();
    }
}
