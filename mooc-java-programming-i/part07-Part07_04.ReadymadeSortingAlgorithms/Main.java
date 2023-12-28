import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 1, 5, 99, 3, 12};
        sort(array);

        String[] sArray = {"Jay", "John", "Bob"};
        sort(sArray);

        ArrayList<Integer> iList = new ArrayList<>();
        iList.add(3);
        iList.add(5);
        iList.add(3);
        sortIntegers(iList);

        ArrayList<String> sList = new ArrayList<>();
        sList.add("Jay");
        sList.add("John");
        sList.add("Bob");
        sortStrings(sList);
    }

    public static void sort(int[] array) {
        Arrays.sort(array);

        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void sort(String[] array) {
        Arrays.sort(array);

        for (String element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void sortIntegers(ArrayList<Integer> integers) {
        Collections.sort(integers);

        for (int element : integers) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void sortStrings(ArrayList<String> strings) {
        Collections.sort(strings);

        for (String element : strings) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
