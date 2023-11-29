public class DynamicArray {
    int LastElement = 0;
    int Size = 0;
    int[] array;

    public void printArray() {
        for (int i = 0; i < LastElement; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public void insertElement(int element) {
        if (LastElement == Size) {
            Size *= 2;
            int[] newArray = new int[Size];
            copyArray(array, newArray);
            array = newArray;
        }
        array[LastElement] = element;
        LastElement++;
    }

    private void copyArray(int[] array, int[] newArray) {
        for (int i = 0; i < LastElement; i++)
            newArray[i] = array[i];
    }

    public void removeAt(int index) {
        if (array.length == 0)
            System.out.println("The array is empty ");
        else if (index < 0 || index >= LastElement)
            System.out.println("This is out of range ");
        else {
            for (int i = index; i < LastElement; i++)
                array[i] = array[i + 1];

            LastElement--;
        }

    }

    public int indexOf(int element) {
        for (int i = 0; i < LastElement; i++) {
            if (array[i] == element)
                return i;
        }
        return -1;
    }

    public int at(int index) {
        for (int i = 0; i < LastElement; i++) {
            if (i == index)
                return array[i];
        }
        return -1;
    }

    public int max(int[] array) {
        int Max = array[0];
        for (int i = 0; i < LastElement; i++) {
            if (array[i] > Max)
                Max = array[i];
        }
        return Max;
    }

    public int min(int[] array) {
        int Min = array[0];
        for (int i = 0; i < LastElement; i++) {
            if (array[i] < Min)
                Min = array[i];
        }
        return Min;
    }

    public void remove(int element) {
        int index = indexOf(element);
        if (index != -1)
            removeAt(index);
    }
}
