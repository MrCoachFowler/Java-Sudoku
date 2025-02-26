import java.util.ArrayList;

public class SudokuMaker
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

    public int[][] makeTable()
    {
        int[][] res = new int[9][9];
        for(int i = 0; i < 9; i++)
        {
            //collect all possible numbers for the new row
            ArrayList<ArrayList<Integer>> rowPossNums = new ArrayList<>();
            for(int j = 0; j < 9; j++)
            {
                int[] row = getRow(res, i);
                int[] col = getCol(res, j);
                int[] box = getBox(res, i, j);

                int[] possNums = getPossibleNumbers(row, col, box);
                ArrayList<Integer> possNumsArrayList = new ArrayList<>();
                for(int num : possNums) {possNumsArrayList.add(num);}
                rowPossNums.add(possNumsArrayList);
            }
            // for(ArrayList<Integer> col : rowPossNums)
            // {
            //     for(Integer value : col) {System.out.print(value);}
            //     System.out.println();
            // }
            //repeatedly loop over the row adding values where they must be. Stop when no more values are added
            //if a full pass is done without valid options, put in a random number and repeat
            boolean didSomething = true;
            Integer lastValPlaced = 0;
            int startVal = 0;
            int endVal = 9;
            while(didSomething)
            {
                didSomething = false;
                //check if any have only one option
                for(int j = 0; j < 9; j++)
                {
                    if(res[i][j] > 0) {continue;} //space already filled in
                    if(rowPossNums.get(j).size() == 1)
                    {
                        res[i][j] = rowPossNums.get(j).get(0);
                        lastValPlaced = rowPossNums.get(j).get(0);
                        didSomething = true;
                        break;
                    }
                }
                //if no change, then put a random valid number in first empty space
                if(!didSomething)
                {
                    for(int j = 0; j < 9; j++)
                    {
                        if(res[i][j] > 0) {continue;} //space already filled in

                        ArrayList<Integer> usableNums = rowPossNums.get(j);
                        // for(Integer v : usableNums) {System.out.print(v);}
                        // System.out.println();

                        //THIS IS A TERRIBLE HACK - try making the board, if it doesn't workout, just call it again to restart
                        if(usableNums.size() == 0) {return makeTable();}
                        //THE TERRIBLE HACK IS DONE NOW

                        int randIndex = (int) (Math.random() * usableNums.size());
                        Integer valueToPlace = usableNums.get(randIndex);
                        res[i][j] = (int) valueToPlace;
                        lastValPlaced = valueToPlace;
                        didSomething = true;
                        break;
                    }
                }
                for(ArrayList<Integer> usableNums : rowPossNums) {usableNums.remove(lastValPlaced);} //remove that value from possible
                // for(int v : res[i]) {System.out.print(v);}
                // System.out.println();
            }
        }
        
        return res;
    }
}