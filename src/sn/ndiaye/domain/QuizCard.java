package sn.ndiaye.domain;

import java.util.HashSet;
import java.util.Set;

public class QuizCard {
    private String question;
    private final Set<String> wrongAnswers;
    private String correctAnswer;

    public QuizCard() {
        wrongAnswers = new HashSet<>();
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void addBadAnswer(String wrongAnswer) {
        wrongAnswers.add(wrongAnswer);
    }

    public boolean isUsable() {
        boolean hasQuestion = (question != null);
        boolean hasCorrectAnswer = (correctAnswer != null);
        boolean hasAtLeastOneBadAnswer = (wrongAnswers.size() > 0);

        if (hasQuestion && hasCorrectAnswer && hasAtLeastOneBadAnswer)
            return true;

        return false;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public Set<String> getWrongAnswers() {
        return wrongAnswers;
    }

    public String toString() {
        return "Question: " + question +
                " Answer: " + correctAnswer +
                " Bad answers: " + wrongAnswers;
    }
}
