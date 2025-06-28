package sn.ndiaye.logic;

import java.util.Iterator;

public class Deque<T> implements Iterable<T>{
    private Node firstNode;
    private Node lastNode;

    class Node {
        private T item;
        private Node nextNode;

        Node(T item) {
            this.item = item;
        }
    }

    public void addToFront(T item) {
        Node newNode = new Node(item);
        if (!isEmpty())
            newNode.nextNode = firstNode;
        else
            lastNode = newNode;

        firstNode = newNode;
    }

    public void addToBottom(T item) {
        Node newNode = new Node(item);
        if (!isEmpty())
            lastNode.nextNode = newNode;
        else
            firstNode = newNode;

        lastNode = newNode;
    }


    private boolean hasFirstNode() {
        return firstNode != null;
    }

    private boolean hasLastNode() {
        return lastNode != null;
    }

    private boolean isEmpty() {
        return !(hasFirstNode() || hasLastNode());
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node currNode = firstNode;
            @Override
            public boolean hasNext() {
                return currNode != null;
            }

            @Override
            public T next() {
                T item = currNode.item;
                currNode = currNode.nextNode;
                return item;
            }
        };
    }

}
