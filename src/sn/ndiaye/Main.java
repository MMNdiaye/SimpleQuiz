package sn.ndiaye;

import sn.ndiaye.views.UserInterface;
import sn.ndiaye.views.textUIs.admin.AdminMenuUI;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new AdminMenuUI();
        ui.start();
    }
}
