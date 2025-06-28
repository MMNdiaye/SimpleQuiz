package sn.ndiaye.domain;

import java.util.HashSet;
import java.util.Set;

public class QuizCard {
    private String question;
    private final Set<String> badAnswers;
    private String correctAnswer;

    public QuizCard() {
        badAnswers = new HashSet<>();
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void addBadAnswer(String badAnswer) {
        badAnswers.add(badAnswer);
    }

    public boolean isUsable() {
        boolean hasQuestion = (question != null);
        boolean hasCorrectAnswer = (correctAnswer != null);
        boolean hasAtLeastOneBadAnswer = (badAnswers.size() > 0);

        if (hasQuestion && hasCorrectAnswer && hasAtLeastOneBadAnswer)
            return true;

        return false;
    }
}
