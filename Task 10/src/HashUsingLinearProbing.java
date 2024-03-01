import java.util.NoSuchElementException;

public class HashUsingLinearProbing {
    private int[] keys; // Array to store keys
    private String[] values; // Array to store values
    private int capacity; // Capacity of the hash table
    private int count = 0; // Number of elements in the hash table

    public HashUsingLinearProbing(int capacity) {
        this.capacity = capacity;
        keys = new int[capacity];
        values = new String[capacity];
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void put(int key, String value) {
        int index = hash(key);

        while (keys[index] != 0) {
            if (keys[index] == key) {
                values[index] = value; // Update value if key already exists
                return;
            }
            index = (index + 1) % capacity; // Linear probing to find next available slot
        }

        keys[index] = key;
        values[index] = value;
        count++;
    }

    public String get(int key) {
        int index = hash(key);

        while (keys[index] != 0) {
            if (keys[index] == key) {
                return values[index]; // Return value if key is found
            }
            index = (index + 1) % capacity; // Linear probing to check next slot
        }

        throw new NoSuchElementException("Key not found");
    }

    public void remove(int key) {
        int index = hash(key);

        while (keys[index] != 0) {
            if (keys[index] == key) {
                keys[index] = 0; // Remove key by setting it to 0
                values[index] = null; // Remove corresponding value
                count--;
                return;
            }
            index = (index + 1) % capacity; // Linear probing to check next slot
        }

        throw new NoSuchElementException("Key not found");
    }

    public int size() {
        return count;
    }
}
