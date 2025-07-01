package sn.ndiaye.views.textUIs.admin.subUIs.modify;

import sn.ndiaye.views.textUIs.MenuUI;
import sn.ndiaye.views.util.Option;

public class ModifyQuizMenu extends MenuUI {
    private static final Option[] menuOptions = {Option.ADD_CARD, Option.MODIFY_CARD,
    Option.REMOVE_CARD, Option.QUIT};

    public ModifyQuizMenu() {
        super(menuOptions);
    }

}
