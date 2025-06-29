package sn.ndiaye.views.textUIs;

import sn.ndiaye.views.util.Option;

public class PlayerMenuUI extends MenuUI {
    private static final Option[] playerOptions = {Option.DO_QUIZ, Option.QUIT};

    PlayerMenuUI() {
        super(playerOptions);
    }


}
