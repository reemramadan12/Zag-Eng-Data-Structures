import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueUsingStacks {
    int size;
    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue(int item) {
        if (isEmpty())
            throw new NoSuchElementException("this stack is empty");

        if (stack2.isEmpty())
            moveOneToTwo();

        return stack2.pop();//because now stack2 contains the elements of the queue in the correct order
    }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException("this stack is empty");

        if (stack2.isEmpty())
            moveOneToTwo();

        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void moveOneToTwo() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());//take the element from stack1 and put it in stack2
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public void print() {
        if (isEmpty())
            throw new NoSuchElementException("this stack is empty");

        Stack<Integer> tempStack = new Stack<>();
        while (!stack2.isEmpty()) {
            tempStack.push(stack2.pop());
        }
        while (!tempStack.isEmpty()) {
            int item1 = tempStack.pop();
            System.out.println(item1 + "");
            stack2.push(item1);

            while (!stack1.isEmpty()) {
                int item2 = stack1.pop();
                System.out.println(item2 + " ");
                stack2.push(item2);
            }
        }
    }
}
