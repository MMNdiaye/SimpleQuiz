package sn.ndiaye.views.textUIs;

import sn.ndiaye.views.util.Option;

public class AdminTextUI extends TextUI {

    private static final Option[] adminOptions = {Option.ADD_QUIZ,
            Option.MODIFY_QUIZ, Option.QUIT};


    public AdminTextUI() {
        super(adminOptions);
    }


    @Override
    public void readInputs() {
        try {
            int input = Integer.valueOf(scanner.nextLine());
                switch (input) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 0:
                        stop();
                        break;
                    default:
                        System.out.println("Please enter a valid input");
                }
        } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
        }

    }


    public static void main(String[] args) {
        TextUI ui = new AdminTextUI();
        ui.start();
    }
}
