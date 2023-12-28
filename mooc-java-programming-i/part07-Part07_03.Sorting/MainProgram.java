public class MainProgram {
    public static void main(String[] args) {
        int[] array = {3, 1, 5, 99, 3, 12};
        System.out.println("Original array:");
        printArray(array);

        int smallestValue = smallest(array);
        System.out.println("Smallest element in the array: " + smallestValue);

        int indexOfSmallest = indexOfSmallest(array);
        System.out.println("Index of the smallest element: " + indexOfSmallest);

        sort(array);
        System.out.println("Sorted array:");
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static int smallest(int[] array) {
        int smallest = array[0];

        for (int i = 1; i < array.length; i++) {
            int element = array[i];

            if (element < smallest) {
                smallest = element;
            }
        }

        return smallest;
    }

    public static int indexOfSmallest(int[] array) {
        int smallest = array[0], index = 0;

        for (int i = 1; i < array.length; i++) {
            int element = array[i];

            if (element < smallest) {
                smallest = element;
                index = i;
            }
        }

        return index;
    }

    public static int indexOfSmallestFrom(int[] table, int startIndex) {
        int smallest = table[startIndex], index = startIndex;

        for (int i = startIndex + 1; i < table.length; i++) {
            int element = table[i];

            if (element < smallest) {
                smallest = element;
                index = i;
            }
        }

        return index;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallestIndex = indexOfSmallestFrom(array, i);
            swap(array, i, smallestIndex);
        }
    }
}
