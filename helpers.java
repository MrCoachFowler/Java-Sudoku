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

    public static void printSudoku(int[][] arr, int[][] origArr)
    {

        String horizBorder = " ";
        for(int i = 0; i < 9; i++)
        {
            horizBorder += "----";
        }
        System.out.println(horizBorder);
        for(int row = 0; row < arr.length; row++) 
        {
            System.out.print("|");
            for(int col = 0; col < arr[row].length; col++)
            {
                int val = arr[row][col];
                if(val == origArr[row][col]) {System.out.print(" " + val + " |");}
                else {System.out.print(" \u001B[32m" + val + "\u001B[0m |");}
            }
            System.out.println();
            System.out.println(horizBorder);
        }
    }

    public static void printSudoku(int[][] arr)
    {

        String horizBorder = "-";
        for(int i = 0; i < 10; i++)
        {
            horizBorder += "----";
        }
        System.out.println(horizBorder);
        
        for(int[] row : arr) 
        {
            int indexer = 0;
            System.out.print("||");
            for(int val : row)
            {
                indexer++;
                System.out.print(" " + val + " ");
                if(indexer % 3 == 0) {System.out.print("||");}
                else {System.out.print("|");}
            }
            System.out.println();
            System.out.println(horizBorder);
        }
    }

    public static int[][] arrayDeepCopy(int[][] arr)
    {
        int[][] res = new int[arr.length][arr[0].length];
        for(int row = 0; row < arr.length; row++)
        {
            for(int col = 0; col < arr[0].length; col++)
            {
                res[row][col] = arr[row][col];
            }
        }
        return res;
    }

    public static boolean contains(int[][] vals, int[] targetVal)
    {
        for(int[] val : vals)
        {
            if(val == targetVal)
            {
                return true;
            }
        }
        return false;
    }
}
