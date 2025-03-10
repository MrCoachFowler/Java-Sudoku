public class test {
    public static void main(String[] args) 
    {
        int[][] puzzle = {
            {0, 0, 0, 3, 0, 0, 7, 0, 8},
            {9, 4, 0, 7, 0, 0, 0, 0, 1},
            {0, 0, 3, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 4, 8, 2, 0},
            {0, 1, 9, 0, 0, 0, 4, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 5, 0, 0, 1, 7},
            {2, 0, 0, 6, 4, 0, 0, 5, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0}
        };
        int[][] solvedPuzzle = helpers.arrayDeepCopy(puzzle);

        SudokuChecker s = new SudokuChecker();
        s.solvePuzzle(solvedPuzzle);
        helpers.printSudoku(solvedPuzzle, puzzle);
    }
}
