package sn.ndiaye.logic;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Deque<T> implements Iterable<T>, Serializable {
    private Node firstNode;
    private Node lastNode;
    private int size;

    class Node implements Serializable{
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
        size++;
    }

    public void addToBottom(T item) {
        Node newNode = new Node(item);
        if (!isEmpty())
            lastNode.nextNode = newNode;
        else
            firstNode = newNode;

        lastNode = newNode;
        size++;
    }


    private boolean hasFirstNode() {
        return firstNode != null;
    }

    private boolean hasLastNode() {
        return lastNode != null;
    }

    public boolean isEmpty() {
        return !(hasFirstNode() || hasLastNode());
    }

    public int size() {
        return size;
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
