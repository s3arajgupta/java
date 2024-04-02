package practice.striversSDE180.arraysPart1;

import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        
        ArrayList<ArrayList<Integer>> matrixArrayList = new ArrayList<>();

        for (int[] row : matrix){
            ArrayList<Integer> rowList = new ArrayList<>();
            for(int ele : row){
                rowList.add(ele);
            }
            matrixArrayList.add(rowList);
        }

        int m = matrixArrayList.size();
        int n = matrixArrayList.get(0).size();
        ArrayList<ArrayList<Integer>> ans = setZeroesFunc(matrixArrayList, m, n);
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                matrix[i][j] = ans.get(i).get(j);
            }
    }

    static ArrayList<ArrayList<Integer>> setZeroesFunc(ArrayList<ArrayList<Integer>> matrix, int m, int n) {

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

}