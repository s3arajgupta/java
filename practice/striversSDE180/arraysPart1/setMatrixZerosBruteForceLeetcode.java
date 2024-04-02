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
    
    static ArrayList<ArrayList<Integer>> setZeroesFunc(ArrayList<ArrayList<Integer>> matrix, int m, int n) {

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
}