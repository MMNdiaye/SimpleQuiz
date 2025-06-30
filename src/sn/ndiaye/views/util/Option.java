package sn.ndiaye.views.util;

public enum Option {
    ADD_QUIZ(1, "Add a new quiz"),
    MODIFY_QUIZ(2, "Modify a quiz"),
    REMOVE_QUIZ(3, "Remove a quiz"),
    RENAME_QUIZ(4, "Edit the theme"),
    DO_QUIZ(1, "Do a quiz"),
    ADD_CARD(1, "Add a new card"),
    MODIFY_CARD(2,"Modify a card"),
    REMOVE_CARD(3, "Remove a card"),
    NULL(0, ""),
    QUIT(0, "Quit");

    private int accessNumber;
    private String text;

    Option(int accessNumber, String text) {
        this.accessNumber = accessNumber;
        this.text = text;
    }

    public int getAccessNumber() {
        return accessNumber;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return accessNumber + "- " + text;
    }
}
