package sn.ndiaye.views.textUIs;

import sn.ndiaye.views.textUIs.admin.subUIs.create.CreateQuizUI;
import sn.ndiaye.views.textUIs.admin.subUIs.modify.ModifyQuizUI;
import sn.ndiaye.views.util.Option;

public abstract class MenuUI extends TextUI {
    private final Option[] menuOptions;
    private final String menu;
    private boolean isExited;
    private CreateQuizUI createQuizUI;
    private ModifyQuizUI modifyQuizUI;


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
                    new CreateQuizUI().start();
                    break;

                case MODIFY_QUIZ:
                    new ModifyQuizUI().start();
                    break;

                case REMOVE_QUIZ:
                    break;

                case DO_QUIZ:
                    break;

                case ADD_CARD:
                    modifyQuizUI.addCard();
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

    public void setCreateQuizUI(CreateQuizUI createQuizUI) {
        this.createQuizUI = createQuizUI;
    }

    public void setModifyQuizUI(ModifyQuizUI modifyQuizUI) {
        this.modifyQuizUI = modifyQuizUI;
    }
}
