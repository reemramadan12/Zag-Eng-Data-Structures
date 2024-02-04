import java.util.Scanner;

public class HotPotatoGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextByte();

        QueueUsingFixedArray queue = new QueueUsingFixedArray(size);

        for (int i = 0; i < size; i++){
            String names = input.next();
            queue.enqueue(Integer.valueOf(names));
        }

        int tosses = input.nextInt();
        while(queue.count > 1){
            for (int i = 0; i< tosses - 1;i++)
                queue.enqueue(queue.dequeue());

            queue.dequeue();
        }
        System.out.println(queue.dequeue());

    }
}
