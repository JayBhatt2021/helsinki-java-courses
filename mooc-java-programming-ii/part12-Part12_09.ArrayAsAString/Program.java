public class Program {
    public static void main(String[] args) {
        int rows = 2;
        int columns = 3;
        int[][] matrix = new int[rows][columns];

        matrix[0][1] = 5;
        matrix[1][0] = 3;
        matrix[1][2] = 7;
        System.out.println(arrayAsString(matrix));

        int[][] matrixTwo = {
                {3, 2, 7, 6},
                {2, 4, 1, 0},
                {3, 2, 1, 0}
        };
        System.out.println(arrayAsString(matrixTwo));
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sb.add(array[i][j]);
            }
            sb.add("\n");
        }

        return sb.toString();
    }
}
