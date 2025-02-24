import java.util.ArrayList;

public class helpers {
    public static int[] intArrayFromArrayList(ArrayList<Integer> vals)
    {
        int[] res = new int[vals.size()];
        for(int i = 0; i < vals.size(); i++)
        {
            res[i] = vals.get(i);
        }
        return res;
    }

    public static int countValuesInArray(int[] arr, int targetVal)
    {
        int count = 0;
        for(int val : arr)
        {
            if(val == targetVal) {count++;}
        }
        return count;
    }

    public static boolean arrayHasZeros(int[] arr)
    {
        for(int val : arr) 
        {
            if(val == 0) {return true;}
        }
        return false;
    }
    public static boolean arrayHasZeros(int[][] arr)
    {
        for(int[] row : arr) 
        {
            if(arrayHasZeros(row)) {return true;}
        }
        return false;
    }

    public static int countZerosIn2DArray(int[][] arr)
    {
        int count = 0;
        for(int[] row: arr) 
        {
            for(int val : row)
            {
                if(val == 0) {count++;}
            }
        }
        return count;
    }

    public static void printSudoku(int[][] arr)
    {
        String horizBorder = " ";
        for(int i = 0; i < 9; i++)
        {
            horizBorder += "----";
        }
        System.out.println(horizBorder);
        for(int[] row : arr) 
        {
            System.out.print("|");
            for(int val : row)
            {
                System.out.print(" " + val + " |");
            }
            System.out.println();
            System.out.println(horizBorder);
        }
    }
}
