import java.util.Random;
import java.lang.*;

public class General
{
    public static void main(String[] args)
    {
      int num = 3456;
      int revNumber = reverseNum(num);
      System.out.println("The reversed Number is " + revNumber);

      int randNum = 10;
      int mathRand = randomIntValue (randNum);
      System.out.println("Random number from 0 to " + randNum + " is " + mathRand);

      int minNum = 5;
      int maxNum = 10;
      int MinandMax = randomMinandMax(minNum, maxNum);
      System.out.println("Random number between " +  minNum +  " and " + maxNum + " is " + MinandMax);

      char randomChar = randomCharacter();
      System.out.println("Random character: " + randomChar);

      Character [] array = {'a', 'b', 'c', 'd'};
      printArray(array);

    }
    public static int reverseNum (int revNum) {
        int reverse = 0;
        int remainder = 0;
        for (; revNum != 0; revNum = revNum / 10) {
            remainder = revNum % 10;
            reverse = reverse * 10 + remainder;
        }
        return reverse;
    }
    public static int randomIntValue (int randNum)
    {
        return (int) (Math.random() * (randNum + 1));
    }
    public static int randomMinandMax (int min, int max)
    {
        return (int) (min + (max - min) * Math.random());
    }
    public static char randomCharacter ()
    {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'a');
    }
    public static <T> void printArray(T [] array)
    {
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
}
