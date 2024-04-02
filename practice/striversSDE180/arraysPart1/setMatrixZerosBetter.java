// Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
// Reason: We are traversing the entire matrix 2 times and each traversal is taking O(N*M) time complexity.

// Space Complexity: O(N) + O(M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
// Reason: O(N) is for using the row array and O(M) is for using the col array.

package practice.striversSDE180.arraysPart1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class setMatrixZerosBetter {
    
    static ArrayList<ArrayList<Integer>> setZeroes(ArrayList<ArrayList<Integer>> matrix, int m, int n) {

        ArrayList<Integer> rows = new ArrayList<>(Collections.nCopies(m, 0));
        ArrayList<Integer> cols = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix.get(i).get(j) == 0){
                    // // System.out.println(i + " " + j);
                    // markRow(matrix, m, n, i);
                    // markCol(matrix, m, n, j);
                    rows.set(i, 1);
                    cols.set(j, 1);
                }
            }
        }

        // System.out.println(matrix);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                if (rows.get(i) == 1 || cols.get(j) == 1){
                    matrix.get(i).set(j, 0);
                }
            }
        // for (int i = 0; i < m; i++){
        //     if(rows.get(i) == 1){
        //        for (int j = 0; j < m; j++){    
        //             matrix.get(i).set(j, 0);
        //         }
        //     }
        // }
        // for (int j = 0; j < n; j++){
        //     if(cols.get(j) == 1){
        //        for (int i = 0; i < n; i++){    
        //             matrix.get(i).set(j, 0);
        //         }
        //     }
        // }

        return matrix;
    }

    public static void main (String args[]){

        // int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1,0,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));

        System.out.println(matrix);
        
        int m = matrix.size();
        int n = matrix.get(0).size();
        
        ArrayList<ArrayList<Integer>> ans = setZeroes(matrix, m, n);
        
        System.out.println("Answer");
        // System.out.println(ans);
        // OR
        for (ArrayList<Integer> row : ans){
            for (Integer ele : row){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}