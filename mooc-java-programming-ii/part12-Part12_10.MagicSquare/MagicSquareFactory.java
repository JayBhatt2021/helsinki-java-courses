public class MagicSquareFactory {
    public MagicSquare createMagicSquare(int size) {
        int row = 0;
        int col = size / 2;
        MagicSquare square = new MagicSquare(size);

        square.placeValue(row, col, 1);

        for (int num = 2; num <= size * size; num++) {
            int currentRow = row--;
            int currentColumn = col++;

            if (row < 0) {
                row = size - 1;
            }
            if (col > size - 1) {
                col = 0;
            }

            if (square.readValue(row, col) > 0) {
                row = currentRow + 1;
                col = currentColumn;
            }

            square.placeValue(row, col, num);
        }

        return square;
    }
}
