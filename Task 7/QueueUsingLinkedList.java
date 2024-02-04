import java.util.NoSuchElementException;

public class QueueUsingLinkedList {
    private class QueueNode {
        int item;
        QueueNode nextNode;

        public QueueNode(int item) {
            this.item = item;
            this.nextNode = null;
        }
    }

    private QueueNode head;
    private QueueNode tail;

    int size = 0;

    public QueueUsingLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(int item) {
        QueueNode newNode = new QueueNode(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("This queue is already empty");

        int item = head.item;
        head = head.nextNode;
        if (head == null) {
            tail = null;
        }
        return item;
    }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException("This queue is already empty");

        return head.item;
    }

    public void print() {
        if (isEmpty())
            throw new NoSuchElementException("This queue is already empty");

        QueueNode current = head;
        while (current != null) {
            System.out.println(current.item + " ");
            current = current.nextNode;
        }
    }

    public int size() {
        int count = 0;
        QueueNode current = head;
        while (current != null) {
            count++;
            current = current.nextNode;
        }
        return count;
    }
}

