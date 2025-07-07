package sn.ndiaye;

import sn.ndiaye.views.UserInterface;
import sn.ndiaye.views.textUIs.admin.AdminMenuUI;
import sn.ndiaye.views.textUIs.player.PlayerMenuUI;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new AdminMenuUI();
        ui.start();
        ui = new PlayerMenuUI();
        ui.start();
    }
}
