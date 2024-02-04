import java.util.NoSuchElementException;

public class QueueUsingFixedArray {
    int items[];
    int size;
    int count = 0;//counts the number of elements inside the array
    int first = 0;
    int last = 0;

    public QueueUsingFixedArray(int size) {
        this.size = size;
        items = new int[size];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public void enqueue(Integer item) {
        if (isFull())
            throw new NoSuchElementException("this queue is already full");

        items[last] = item;
        last = (last + 1) % size;
        count++;
    }

    public Integer dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("this queue is already empty");

        int temp = items[first];
        first = (first + 1) % size;
        count--;
        return temp;
    }

    public void print() {
        System.out.println("[");
        if (!isEmpty()) {
            System.out.println(items[first]);
            int current = (first + 1) % size;
            while (current != last) {
                System.out.println(", " + items[current]);
                current = (current + 1) % size;
            }
        }
        System.out.println("]");
    }
    public int size(){
        return size;
    }

}

