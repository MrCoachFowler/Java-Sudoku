public class test {
    public static void main(String[] args) 
    {
        int[][] puzzle = {
            {0, 0, 9, 0, 0, 0, 4, 0, 0},
            {0, 1, 0, 7, 0, 0, 3, 2, 0},
            {0, 8, 4, 0, 0, 0, 0, 0, 6},
            {0, 0, 0, 3, 9, 0, 0, 5, 0},
            {0, 0, 0, 0, 3, 0, 0, 4, 0},
            {0, 9, 0, 0, 0, 6, 0, 0, 2},
            {8, 0, 0, 0, 7, 2, 0, 1, 9},
            {0, 0, 0, 8, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        SudokuChecker s = new SudokuChecker();
        s.solvePuzzle(puzzle);
    }
}
