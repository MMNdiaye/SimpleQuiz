package sn.ndiaye.views.textUIs.admin.subUIs.modify;

import sn.ndiaye.views.textUIs.MenuUI;
import sn.ndiaye.views.util.Option;

public class ModifyQuizCardMenu extends MenuUI {
    private static final Option[] menuOptions = {Option.MODIFY_QUESTION,
     Option.MODIFY_CORRECT_ANSWER, Option.MODIFY_WRONG_ANSWER,
     Option.ADD_WRONG_ANSWER, Option.REMOVE_WRONG_ANSWER, Option.QUIT};

    public ModifyQuizCardMenu() {
        super(menuOptions);
    }
}
