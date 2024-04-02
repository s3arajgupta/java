package practice.striversSDE180.arrays;
import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        for (int rows = 1; rows <= numRows; rows++){
            Integer ans = 1;
            List<Integer> ds = new ArrayList<>();
            ds.add(ans);
            for (int i = 1; i < rows; i++){
                // System.out.print(ans + " ");
                ans = ans * (rows-i)/i;
                ds.add(ans);
            }
            // System.out.println();
            res.add(ds);
        }
        return res;        
    }
}
