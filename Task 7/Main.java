import java.util.Stack;

public class Main {
    public static void main(String[] args) {
       QueueUsingFixedArray queue = new QueueUsingFixedArray(10);

    }
    public static void reversedQueue(QueueUsingFixedArray queue){
        Stack<Integer> S= new Stack<>();
        while(!queue.isEmpty())
            S.push(queue.dequeue());

        while(!S.isEmpty())
            queue.enqueue(S.pop());
    }
}