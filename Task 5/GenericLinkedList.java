import java.util.NoSuchElementException;

public class GenericLinkedList<T> {

    private class Node {
        public Node(T v) {
            value = v;
        }

        T value;
        Node nextNode;
    }

    private Node head;
    private Node tail;
    private int size = 0;

    private boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T item) {
        Node node = new Node(item);

        if (isEmpty()) {
            head = tail = node;
        } else {
            node.nextNode = head;
            head = node;
        }
        size++;
    }

    public void addLast(T item) {
        Node node = new Node(item);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.nextNode = node;
            tail = node;
        }
        size++;
    }

    public void removeFirst() {
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

    public void removeLast() {
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

    private Node beforeLast() {
        Node beforeLast = head;
        Node current = head;

        while (current.nextNode != null) {
            beforeLast = current;
            current = current.nextNode;
        }
        return beforeLast;
    }

    public int indexOf(T item) {
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

    public boolean Contains(T item) {
        int index = indexOf(item);

        return index != -1;
    }

    public int size() {
        return size;
    }

    public void printElements() {
        Node current = head;

        while (current != null) {
            System.out.println(current.value);
            current = current.nextNode;
        }
    }

    public void reverse() {
        if (isEmpty())
            return;

        Node previous = head;
        Node current = head.nextNode;

        while (current != null) {
            Node next = current.nextNode;//this should only be written inside the while loop
            current.nextNode = previous;
            previous = current;
            current = next;
        }
        Node temp = head; //to put the head on the last node and the tail on the first node because of the reverse
        head = tail;
        tail = temp;
        tail.nextNode = null;
    }


}
