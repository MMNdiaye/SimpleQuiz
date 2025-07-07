package sn.ndiaye.logic;

import sn.ndiaye.domain.QuizCard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Quiz implements Iterable<QuizCard>, Serializable {
    private List<QuizCard> quizCards;
    private String theme;

    private Quiz(List<QuizCard> quizCards) {
        this.quizCards = Shuffler.shuffle(quizCards);
    }

    public static Quiz of(List<QuizCard> quizCards) {
        Quiz quiz = new Quiz(quizCards);
        return quiz;
    }


    public List<QuizCard> toList() {
        List<QuizCard> cards = new ArrayList<>();
        for (QuizCard quizCard : quizCards) {
            cards.add(quizCard);
        }
        return cards;
    }


    @Override
    public Iterator<QuizCard> iterator() {
        return quizCards.iterator();
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
