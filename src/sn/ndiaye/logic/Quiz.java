package sn.ndiaye.logic;

import sn.ndiaye.domain.QuizCard;

import java.util.Iterator;
import java.util.List;
import java.util.Random;


class Quiz implements Iterable<QuizCard> {
    private static Deque<QuizCard> quizCardsPile;

    private Quiz() {
        quizCardsPile = new Deque<>();
    }

    public static Quiz of (List<QuizCard> quizCards) {
        Quiz quiz = new Quiz();
        shuffleCards(quizCards);
        return quiz;
    }

    private static void shuffleCards(List<QuizCard> quizCards) {
        Random random = new Random();
        for (QuizCard card : quizCards) {
            double randomPicked = random.nextDouble();
            if (randomPicked < 0.5)
                quizCardsPile.addToFront(card);
            else
                quizCardsPile.addToBottom(card);
        }
    }

    @Override
    public Iterator<QuizCard> iterator() {
        return quizCardsPile.iterator();
    }
}
