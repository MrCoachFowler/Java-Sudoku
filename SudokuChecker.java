import java.util.ArrayList;

public class SudokuChecker
{
    private int[] getRow(int[][] puzzle, int rowIndex)
    {
        return puzzle[rowIndex];
    }

    private int[] getCol(int[][] puzzle, int colIndex)
    {
        int[] res = new int[9];
        for(int i = 0; i < 9; i++)
        {
            res[i] = puzzle[i][colIndex];
        }
        return res;
    }

    private int[] getBox(int[][] puzzle, int rowIndex, int colIndex)
    {
        int rowTop = 3 * Math.floorDiv(rowIndex , 3);
        int colTop = 3 * Math.floorDiv(colIndex , 3);

        int[] res = new int[9];
        int i = -1;
        for(int row = rowTop; row < rowTop + 3; row++)
        {
            for(int col = colTop; col < colTop + 3; col++)
            {
                i++;
                res[i] = puzzle[row][col];
            }
        }
        //guess I could've also done a select copy but eh..
        return res;
    }

    private int[][] useContext(int[][] puzzle)
    {
        for(int rowIndex = 0; rowIndex < 9; rowIndex++)
        {
            for(int colIndex = 0; colIndex < 9; colIndex++)
            {
                if(puzzle[rowIndex][colIndex] > 0) {continue;}
                //cannot have numbers already in box
                int[] box = getBox(puzzle, rowIndex, colIndex);

                int[] contextVals = getContextValues(puzzle, rowIndex, colIndex);

                
                for(int i = 1; i <= 9; i++)
                {
                    if (contains(box, i)) {continue;}
                    if (helpers.countValuesInArray(contextVals, i) == 4)
                    {
                        puzzle[rowIndex][colIndex] = i;
                    }
                }
            }
        }
        return puzzle;
    }
        
    private int[] getContextValues(int[][] puzzle, int rowIndex, int colIndex)
    {
        //locate the top of the box
        int rowTop = 3 * Math.floorDiv(rowIndex , 3);
        int colTop = 3 * Math.floorDiv(colIndex , 3);

        //create a container for context values
        ArrayList<Integer> contextValues = new ArrayList<>();
        //collect context values
        for(int row = rowTop; row < rowTop + 3; row++)
        {
            if(row == rowIndex) {continue;}
            for(int val : getRow(puzzle, row))
            {
                contextValues.add(val);
            }
        }
        for(int col = colTop; col < colTop + 3; col++)
        {
            if(col == colIndex) {continue;}
            for(int val : getCol(puzzle, col))
            {
                contextValues.add(val);
            }
        }
        return helpers.intArrayFromArrayList(contextValues);
    }

    private boolean contains(int[] vals, int targetVal)
    {
        for(int val : vals)
        {
            if(val == targetVal)
            {
                return true;
            }
        }
        return false;
    }

    private int[] getPossibleNumbers(int[] row, int[] col, int[] box)
    {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++)
        {
            boolean possFromRow = !contains(row, i);
            boolean possFromCol = !contains(col, i);
            boolean possFromBox = !contains(box, i);

            if( possFromRow && possFromCol && possFromBox)
            {
                res.add(i);
            }
        }
        return helpers.intArrayFromArrayList(res);
    }

    public int[][] useDirect(int[][] puzzle)
    {
        for(int row = 0; row < 9; row++)
        {
            for(int col = 0; col < 9; col++)
            {
                if (puzzle[row][col] > 0) {continue;}

                int[] rowPoss = getRow(puzzle, row);
                int[] colPoss = getCol(puzzle, col);
                int[] boxPoss = getBox(puzzle, row, col);

                int[] possibleNums = getPossibleNumbers(rowPoss, colPoss, boxPoss);
                if(possibleNums.length == 1)
                {
                    puzzle[row][col] = possibleNums[0];
                }
            }
        }
        return puzzle;
    }

    public boolean solvePuzzle(int[][] puzzle)
    {
        
        int noChangeCount = 0;
        int[][] lastPuzzle = puzzle.clone();

        while(helpers.arrayHasZeros(puzzle))
        {
            puzzle = useContext(puzzle);
            puzzle = useDirect(puzzle);
            if(lastPuzzle == puzzle) { noChangeCount++;}
            else 
            {
                noChangeCount = 0;
                lastPuzzle = puzzle.clone();
            }
            if(noChangeCount >= 3)
            {
                System.out.println("Three failed loops. not solvable: ");
                helpers.printSudoku(puzzle);
                return false;
            }
        }
        System.out.println("Solvable!");
        helpers.printSudoku(puzzle);
        return true;
    }


}