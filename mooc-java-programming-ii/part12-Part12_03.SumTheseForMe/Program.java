public class Program {
    public static void main(String[] args) {
        int[] numbers = {3, -1, 8, 4};

        System.out.println(sum(numbers, 0, 0, 0, 0));
        System.out.println(sum(numbers, 0, 0, 0, 10));
        System.out.println(sum(numbers, 0, 1, 0, 10));
        System.out.println(sum(numbers, 0, 1, -10, 10));
        System.out.println(sum(numbers, -1, 999, -10, 10));
    }

    // toWhere is exclusive
    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        if (fromWhere < 0) {
            fromWhere = 0;
        }

        if (toWhere > array.length) {
            toWhere = array.length;
        }

        int sum = 0;
        for (int i = fromWhere; i < toWhere; i++) {
            int num = array[i];

            if (smallest <= num && num <= largest) {
                sum += num;
            }
        }

        return sum;
    }
}
