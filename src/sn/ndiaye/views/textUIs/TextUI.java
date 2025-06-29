package sn.ndiaye.views.textUIs;

import sn.ndiaye.views.UserInterface;
import sn.ndiaye.views.util.Option;

import java.util.Scanner;

public abstract class TextUI implements UserInterface {
    protected final Scanner scanner;
    private final Option[] menuOptions;
    private final String menu;
    private boolean isExited;

    public TextUI(Option[] menuOptions) {
        scanner = new Scanner(System.in);
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

    protected abstract void readInputs();

    @Override
    public void stop() {
        scanner.close();
        isExited = true;
    }

}
