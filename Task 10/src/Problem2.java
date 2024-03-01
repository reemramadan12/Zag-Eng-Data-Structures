import java.util.HashMap;

public class Problem2 {
    public static void main(String[] args) {
        String s = "Hello";
        HashMap<Character, Integer> hashTable = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {//Count the frequency of each character
            if (!hashTable.containsKey(s.charAt(i))) {
                hashTable.put(s.charAt(i), 1);
            } else {
                int value = hashTable.get(s.charAt(i));
                value++;
                hashTable.put(s.charAt(i), value);
            }
        }

        char firstNonRepeated = '\0'; //Find the first non-repeated character
        for (int i = 0; i < s.length(); i++) {
            if (hashTable.get(s.charAt(i)) == 1) {
                firstNonRepeated = s.charAt(i);
                break;
            }
        }

        if (firstNonRepeated != '\0') {
            System.out.println(firstNonRepeated);
        } else {
            System.out.println("No non-repeated characters found.");
        }
    }
}
