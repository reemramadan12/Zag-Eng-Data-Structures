import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        public Node(int v) {
            value = v;

        }

        int value;
        Node nextNode;
    }

    private Node head;
    private Node tail;
    private int size = 0;

    private boolean isEmpty() {
        return head == null;
    }


    public void addFirst(int item) { //O(1)
        Node node = new Node(item);

        if (isEmpty()) {
            head = tail = node;
            return;
        } else {
            node.nextNode = head;
            node = head;
        }
        size++;
    }

    public void addLast(int item) { //O(1)
        Node node = new Node(item);

        if (isEmpty()) {
            head = tail = node;
            return;
        } else {
            tail.nextNode = node;
            tail = node;
        }
        size++;
    }

    public void removeFirst() { //O(1)
        if (isEmpty())
            throw new NoSuchElementException("This is an empty list");

        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            head = head.nextNode;
            temp.nextNode = null;
        }
        size--;
    }

    public void removeLast() { //O(n)
        if (isEmpty())
            throw new NoSuchElementException("This is an empty list");

        if (head == tail) {
            head = tail = null;
        } else {
            Node beforeLast = beforeLast();
            tail = beforeLast;
            tail.nextNode = null;
        }
        size--;
    }

    private Node beforeLast() { //O(n)
        Node beforeLast = head;
        Node current = head;

        while (current.nextNode != null) {
            beforeLast = current;
            current = current.nextNode;
        }
        return beforeLast;
    }

    public int indexOf(int item) { //O(n)
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.value == item)
                return index;

            index++;
            current = current.nextNode;
        }
        return -1;
    }

    public boolean Contains(int item) { //O(1)
        int index = indexOf(item);

        return index != -1;
    }

    public int size() { //O(1)
        return size;
    }

    public void printElements() { //O(n)
        Node current = head;

        while (current != null) {
            System.out.println(current.value);
            current = current.nextNode;
        }
    }

    public int max() { //O(n)
        if (isEmpty())
            throw new NoSuchElementException("This is an empty list");

        int max = head.value;
        Node current = head.nextNode;
        while (current != null) {
            if (current.value > max)
                max = current.value;

            current = current.nextNode;
        }
        return max;
    }

    public int min() { //O(n)
        if (isEmpty())
            throw new NoSuchElementException("This is an empty list");

        int min = head.value;
        Node current = head.nextNode;
        while (current != null) {
            if (current.value < min)
                min = current.value;

            current = current.nextNode;
        }
        return min;
    }

}
