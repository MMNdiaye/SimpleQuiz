package sn.ndiaye.views.textUIs;

import java.util.List;
import java.util.Scanner;

public class ChoiceUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static <T> int selectIndexFromList(List<T> list) {
        return chooseFrom(list);
    }

    private static <T> int chooseFrom(List<T> list) {
        while(true) {
            show(list);
            String choice = scanner.nextLine();
            if (isValid(choice, list.size())) {
                int selectedIndex = Integer.valueOf(choice);
                return selectedIndex;
            }
            System.out.println("Not a valid choice please choose again.");
        }
    }


    private static <T> void show(List<T> list) {
        System.out.println("Please choose from this list");
        for (int i = 0; i < list.size(); i++) {
            String quizOption = i + "- " + list.get(i);
            System.out.println(quizOption);
        }
    }


    private static boolean isValid(String choice, int maxBound) {
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


}
