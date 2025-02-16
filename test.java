public class test {
    public static void main(String[] args) 
    {
        int[][] puzzle = {
            {4, 0, 0, 8, 0, 1, 0, 0, 0},
            {0, 0, 6, 3, 4, 0, 8, 0, 0},
            {9, 8, 1, 2, 0, 0, 0, 3, 0},
            {7, 4, 0, 1, 0, 2, 0, 5, 8},
            {0, 0, 2, 0, 9, 0, 0, 4, 3},
            {3, 0, 8, 7, 0, 4, 2, 0, 1},
            {1, 0, 3, 4, 0, 0, 5, 0, 0},
            {8, 6, 0, 0, 0, 5, 0, 0, 4},
            {5, 0, 0, 0, 8, 0, 0, 0, 0}
        };

        SudokuChecker s = new SudokuChecker();
        if(s.solvePuzzle(puzzle))
        {
            System.out.println("The puzzle is solvable");
        }
        else
        {
            System.out.println("The puzzle is not solvable");
        }
    }
}
