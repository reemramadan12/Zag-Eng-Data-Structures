import java.util.HashMap;

public class Problem3 {
    public static void main(String[] args) {
        String s = "Hello";

        HashMap<Character, Integer> hashTable = new HashMap<>(); // where character is the key and integer is the value

        for (int i = 0; i < s.length(); i++) {
            if (!hashTable.containsKey(s.charAt(i))) {
                hashTable.put(s.charAt(i), 1);
            } else {
                int value = hashTable.get(s.charAt(i));
                value++;
                hashTable.put(s.charAt(i), value);
            }
        }

        char mostRepeatedCharacter = '\0';
        int maxFrequency = 0;

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            int frequency = hashTable.get(key);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostRepeatedCharacter = key;
            }
        }
        System.out.println(mostRepeatedCharacter);
    }
    /*time complexity = O(n)*/
}

