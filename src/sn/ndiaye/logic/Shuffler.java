package sn.ndiaye.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shuffler {
    private Shuffler() {

    }

    public static <T> List<T> shuffle(List<T> elements) {
        Random random = new Random();
        Deque<T> pile = new Deque<>();

        for (T element : elements) {
            double randomPicked = random.nextDouble();
            if (randomPicked < 0.5)
                pile.addToFront(element);
            else
                pile.addToBottom(element);
        }

        List<T> shuffledElements = new ArrayList<>();

        for (T element : pile)
            shuffledElements.add(element);

        return shuffledElements;
    }
}
