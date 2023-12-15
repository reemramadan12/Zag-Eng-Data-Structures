import java.util.NoSuchElementException;
import java.util.Stack;

public class StackUsingLinkedList {
    private class Node {
        int value;
        Node bottom;

        public Node(int value) {
            this.value = value;

        }
    }

    Node top;

    public boolean isEmpty() {
        return top == null;

    }

    public void push(int Item) {
        Node newNode = new Node(Item); //create new node and put the new item that'll be pushed in this node
        newNode.bottom = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty())
            throw new NoSuchElementException("This stack is empty");

        Node temp = top;
        top = top.bottom;
        temp.bottom = null; //because it's a deleted node now

        return temp.value;
    }

    public int peek(){
        if(isEmpty())
            throw new NoSuchElementException("This stack is empty");

        return top.value;
    }
}
