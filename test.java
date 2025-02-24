public class test {
    public static void main(String[] args) 
    {
        int[][] puzzle = {
            {1, 0, 7, 0, 0, 0, 3, 0, 9},
            {0, 0, 0, 0, 7, 9, 1, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 6},
            {0, 8, 1, 0, 6, 0, 0, 0, 0},
            {0, 4, 0, 1, 0, 8, 2, 0, 0},
            {0, 6, 0, 0, 2, 0, 7, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 0, 0},
            {0, 7, 0, 8, 3, 0, 0, 5, 0},
            {4, 0, 0, 6, 0, 0, 0, 0, 0}
        };
        int[][] solvedPuzzle = helpers.arrayDeepCopy(puzzle);

        SudokuChecker s = new SudokuChecker();
        s.solvePuzzle(solvedPuzzle);
        helpers.printSudoku(solvedPuzzle, puzzle);
    }
}
