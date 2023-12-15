import java.util.Stack;

public class BalancedBrackets {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (openBracket(c)) {
               stack.push(c);
            }

            else if(closedBracket(c)){
               char open = stack.pop();
               if(!isMatch(open,c))
                   return false;
            }
        }

        return stack.isEmpty();//if the stack is empty then it'll return true meaning that the expression is balanced
    }
    private static boolean isMatch(char open, char closed) {
        return  (open == '(' && closed == ')') ||
                (open == '{' && closed == '}') ||
                (open == '<' && closed == '>') ||
                (open == '[' && closed == ']');
    }


    private static boolean openBracket(char c) {
        return (c == '(' || c == '{' || c == '[' || c == '<');
    }

    private static boolean closedBracket(char c) {
        return (c == ')' || c == '}' || c == ']' || c == '>');
    }
}

