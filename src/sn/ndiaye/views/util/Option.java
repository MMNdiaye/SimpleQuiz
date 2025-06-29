package sn.ndiaye.views.util;

public enum Option {
    ADD_QUIZ(1, "Add a new quiz"),
    MODIFY_QUIZ(2, "Modify a quiz"),
    REMOVE_QUIZ(3, "Remove a quiz"),
    DO_QUIZ(1, "Do a quiz"),
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
