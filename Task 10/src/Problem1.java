import java.util.HashMap;

public class Problem1 {
    public static void main(String[]args){
        String s = "Hello";

        HashMap<Character, Integer> hashTable = new HashMap<>(); //where character is the key and integer is the value

        for (int i = 0; i < s.length(); i++) {
            int value = hashTable.containsKey(s.charAt(i))? hashTable.get(s.charAt(i)): 0;
            hashTable.put(s.charAt(i), value + 1);

        }
        System.out.println(hashTable);
    }
}
/*
    for (int i = 0; i < s.length(); i++) {
    if(!hashTable.containsKey(s.charAt(i)))
                hashTable.put(s.charAt(i), 1);

            else{
                int value = hashTable.get(s.charAt(i));
                value++;
                hashTable.put(s.charAt(i), value);
            }
      } another valid solution
    */
