package sn.ndiaye.domain;

import sn.ndiaye.logic.Deque;
import sn.ndiaye.logic.Shuffler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuizCard implements Serializable {
    private String question;
    private final List<String> wrongAnswers;
    private String correctAnswer;

    public QuizCard() {
        wrongAnswers = new ArrayList<>();
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void addWrongAnswer(String wrongAnswer) {
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

    public List<String> getWrongAnswers() {
        return wrongAnswers;
    }

    public List<String> getAllAnswers() {
        List<String> answers = combineAnswers();
        List<String> shuffledAnswers = Shuffler.shuffle(answers);
        return shuffledAnswers;
    }

    private List<String> combineAnswers() {
        List<String> answers = new ArrayList<>();
        for (String wrongAnswer : wrongAnswers)
            answers.add(wrongAnswer);
        answers.add(correctAnswer);
        return answers;
    }

    public String toString() {
        return "Question: " + question +
                " Answer: " + correctAnswer +
                " Bad answers: " + wrongAnswers;
    }
}
