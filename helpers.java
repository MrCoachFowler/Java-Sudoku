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
    
}
