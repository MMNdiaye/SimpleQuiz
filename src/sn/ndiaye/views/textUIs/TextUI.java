package sn.ndiaye.views.textUIs;

import sn.ndiaye.views.UserInterface;

import java.util.Scanner;

public abstract class TextUI implements UserInterface {
    protected static final Scanner scanner = new Scanner(System.in);

    protected abstract void readInputs();

}
