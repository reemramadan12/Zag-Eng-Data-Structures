import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
    public static String reversedString(String s) {
        Stack<Character> stack = new Stack<>();
        String reversed = "";

        for (int i = 0; i < s.length(); i++)
            stack.push(s.charAt(i));

        while (!stack.isEmpty())
            reversed += stack.pop();

        return reversed;
    }
}