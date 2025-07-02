package sn.ndiaye.views.textUIs.admin;

import sn.ndiaye.views.textUIs.MenuUI;
import sn.ndiaye.views.util.Option;

public class AdminMenuUI extends MenuUI {

    private static final Option[] adminOptions = {Option.ADD_QUIZ,
            Option.MODIFY_QUIZ,Option.REMOVE_QUIZ, Option.SHOW_QUIZZES, Option.QUIT};

    public AdminMenuUI() {
        super(adminOptions);
    }


}
