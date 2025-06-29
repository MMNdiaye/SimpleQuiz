package sn.ndiaye.logic;

import sn.ndiaye.domain.QuizCard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Quiz implements Iterable<QuizCard> {
    private static Deque<QuizCard> quizCardsPile;
    private String theme;

    private Quiz() {
        quizCardsPile = new Deque<>();
    }

    public static Quiz of(List<QuizCard> quizCards) {
        Quiz quiz = new Quiz();
        shuffleCards(quizCards);
        return quiz;
    }

    private static void shuffleCards(List<QuizCard> quizCards) {
        Random random = new Random();
        for (QuizCard card : quizCards) {
            if (!card.isUsable()) {
                continue;
            }
            double randomPicked = random.nextDouble();
            if (randomPicked < 0.5)
                quizCardsPile.addToFront(card);
            else
                quizCardsPile.addToBottom(card);
        }
    }

    public List<QuizCard> toList() {
        List<QuizCard> cards = new ArrayList<>();
        for (QuizCard quizCard : quizCardsPile) {
            cards.add(quizCard);
        }
        return cards;
    }

    @Override
    public Iterator<QuizCard> iterator() {
        return quizCardsPile.iterator();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String toString() {
        if (theme != null)
            return theme;
        else
            return "No theme quiz";
    }
}
