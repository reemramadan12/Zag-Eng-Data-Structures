import java.util.NoSuchElementException;

public class StackUsingDynamicArray {
    int[] items;
    int size = 0;
    int LastItem;

    public StackUsingDynamicArray(int size) {
        this.size = size;
        items = new int[size];
    }

    public StackUsingDynamicArray() {
        size = 100;
        items = new int[size];
    }

    public boolean isEmpty() {
        return LastItem == 0;
    }

    public void push(int value) {
        if (size == LastItem)
            createNewArray();

        items[LastItem] = value;//put this value in the last element of the dynamic array
        LastItem++;
    }

    private void createNewArray() {
        int[] newArray = new int[size * 2];

        for (int i = 0; i < LastItem; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }

    public int pop() {
        if (isEmpty())
            throw new NoSuchElementException("This stack is empty");

        int temp = items[LastItem - 1];
        LastItem--;
        return temp;
    }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException("This stack is empty");

        return items[LastItem - 1]; //LastItem is bigger than the index by 1
    }
}
