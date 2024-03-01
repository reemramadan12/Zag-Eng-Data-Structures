import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashUsingChainingStrategy {
    private class Node {
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] array;
    private int count = 0;

    public HashUsingChainingStrategy(int value) {
        array = new LinkedList[value];
    }

    private int hash(int key) {
        return key % array.length;
    }

    public void put(int key, String value) {
        Node node = new Node(key, value);

        int index = hash(key);

        if (array[index] == null)
            array[index] = new LinkedList<>();

        for (Node node1 : array[index]) {
            if (node1.key == key) { //if I added a new char while we already have this char in our linkedlist then I should update its value not add a new linkedlist
                node1.value = value;
                return;
            }
        }
        array[index].add(node);// if not then create add a new node with the new char
        count++;
    }

    public String get(int key) {// takes a key and returns its value
        int index = hash(key);

        if (array[index] == null)
            throw new NoSuchElementException("This element isn't here");
        else {
            for (Node node1 : array[index]) {
                if (node1.key == key)
                    return node1.value;
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);

        if (array[index] == null)
            throw new NoSuchElementException("This element isn't here");
        else {
            for (Node node1 : array[index]) {
                if (node1.key == key) {
                    array[index].remove(node1);
                    count--;
                    return;
                }
            }
        }
        throw new NoSuchElementException("This element isn't here");
    }
    public int size(){
      return count;
    }
}


