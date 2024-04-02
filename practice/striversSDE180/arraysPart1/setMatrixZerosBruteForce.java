// Time Complexity: O((N*M)*(N + M)) + O(N*M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
// Reason: Firstly, we are traversing the matrix to find the cells with the value 0. It takes O(N*M). Now, whenever we find any such cell we mark that row and column with -1. This process takes O(N+M). So, combining this the whole process, finding and marking, takes O((N*M)*(N + M)).
// Another O(N*M) is taken to mark all the cells with -1 as 0 finally.

// Space Complexity: O(1) as we are not using any extra space.

package practice.striversSDE180.arraysPart1;

import java.util.ArrayList;
import java.util.Arrays;

class setMatrixZerosBruteForce {

    static void markRow (ArrayList<ArrayList<Integer>> matrix, int m, int n, int i){

        for (int col = 0; col < n; col++){
            if (matrix.get(i).get(col) != 0)
                matrix.get(i).set(col, -1);
        }
    }

    static void markCol (ArrayList<ArrayList<Integer>> matrix, int m, int n, int j){

        for (int row = 0; row < m; row++){
            if (matrix.get(row).get(j) != 0)
                matrix.get(row).set(j, -1);
        }
    }
    
    static ArrayList<ArrayList<Integer>> setZeroes(ArrayList<ArrayList<Integer>> matrix, int m, int n) {

        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix.get(i).get(j) == 0){
                    // System.out.println(i + " " + j);
                    markRow(matrix, m, n, i);
                    markCol(matrix, m, n, j);
                }
            }
        }

        // System.out.println(matrix);

        for (int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(matrix.get(i).get(j) == -1)
                    matrix.get(i).set(j, 0);

        // System.out.println(matrix);

        return matrix;
    }

    public static void main (String args[]){

        // int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,1,0)));
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