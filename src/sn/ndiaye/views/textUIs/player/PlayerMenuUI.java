package sn.ndiaye.views.textUIs.player;

import sn.ndiaye.views.textUIs.MenuUI;
import sn.ndiaye.views.util.Option;

public class PlayerMenuUI extends MenuUI {
    private static final Option[] playerOptions = {Option.DO_QUIZ, Option.QUIT};

    public PlayerMenuUI() {
        super(playerOptions);
    }


}
