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

    public boolean solvePuzzle(int[][] puzzle)
    {
        
        boolean openValuesStill = true;
        int noChangeCount = 0;

        while(openValuesStill)
        {
            openValuesStill = false;
            boolean changedSomething = false;

            for(int row = 0; row < 9; row++)
            {
                for(int col = 0; col < 9; col++)
                {
                    if (puzzle[row][col] > 0)
                    {
                        continue;
                    }
                    int[] rowPoss = getRow(puzzle, row);
                    int[] colPoss = getCol(puzzle, col);
                    int[] boxPoss = getBox(puzzle, row, col);

                    int[] possibleNums = getPossibleNumbers(rowPoss, colPoss, boxPoss);
                    if(possibleNums.length == 1)
                    {
                        puzzle[row][col] = possibleNums[0];
                        changedSomething = true;
                    }
                    else
                    {
                        openValuesStill = true;
                    }
                }
            }
            
            if(changedSomething)
            {
                noChangeCount = 0;
            }
            else
            {
                noChangeCount++;
            }
            if(noChangeCount > 2)
            {
                System.out.println("Three useless passes, quitting...");
                return false;
            }
        }
        return true;
    }


}