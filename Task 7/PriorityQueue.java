import java.util.NoSuchElementException;

public class PriorityQueue {
    private int count = 0;
    int size;
    private int[] arr;

    public PriorityQueue(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void enqueue(int item) {
        if (isFull())
            throw new NoSuchElementException("this Queue is full");

        int i = getIndex(item);
        arr[i] = item;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("this Queue is empty");

        int temp = arr[0];
        for (int i = 0; i < count - 1; i++)
            arr[i] = arr[i + 1];
        count--;
        return temp;
    }

    private int getIndex(int item) {
        int i = count - 1;
        for (; i >= 0; i--) {
            if (arr[i] > item)
                arr[i + 1] = arr[i];
            else
                break;
        }
        return i + 1;
    }

    public boolean isFull() {
        return count == size; //or == arr.length
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return size;
    }
}
