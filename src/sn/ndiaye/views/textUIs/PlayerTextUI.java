package sn.ndiaye.views.textUIs;

import sn.ndiaye.views.util.Option;

public class PlayerTextUI extends TextUI{
    private static final Option[] playerOptions = {Option.DO_QUIZ, Option.QUIT};

    PlayerTextUI() {
        super(playerOptions);
    }

    @Override
    protected void readInputs() {
        try {
            int input = Integer.valueOf(scanner.nextLine());
            switch (input) {
                case 1:
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
}
