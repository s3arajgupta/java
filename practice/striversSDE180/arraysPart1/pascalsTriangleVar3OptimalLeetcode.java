// make different functions to maintain code quality, it is not alll about solving problem

package practice.striversSDE180.arraysPart1;
import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        for (int rows = 1; rows <= numRows; rows++){
            
            // System.out.println();
            res.add(generateRow(rows));
        }
        return res;        
    }

    public List<Integer> generateRow (int n){
        Integer ans = 1;
        List<Integer> ds = new ArrayList<>();
        ds.add(ans);
        for (int i = 1; i < n; i++){
            // System.out.print(ans + " ");
            ans = ans * (n-i)/i;
            ds.add(ans);
        }
        return ds;
    }
}
