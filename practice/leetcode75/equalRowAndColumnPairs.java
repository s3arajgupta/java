package practice.leetcode75;

import java.util.*;

public class equalRowAndColumnPairs {

    public static void main(String[] args) {

        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        // int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(equalPairs(grid));
        
    }

    public static int equalPairs(int[][] grid) {

        Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
        
        for (int i = 0; i < grid.length; i++){
            ArrayList<Integer> rows = new ArrayList<>();
            for (int j = 0; j < grid.length; j++) {
                rows.add(grid[i][j]);
            }
            map.put(rows, map.getOrDefault(rows, 0) + 1);
        }
        
        // System.out.println(map);
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            ArrayList<Integer> cols = new ArrayList<>();
            for (int j = 0; j < grid.length; j++) {
                cols.add(grid[j][i]);
            }
            // System.out.println(cols);
            if (map.containsKey(cols)) count += map.get(cols);
        }

        return count;
        
    }

    // public static int equalPairs(int[][] grid) {

    //     List<ArrayList<Integer>> arrayRows = new ArrayList<>();
    //     List<ArrayList<Integer>> arraycols = new ArrayList<>();

    //     // for (int i = 0 ; i < grid.length; i++){
    //     //     ArrayList<Integer> rows = new ArrayList<>();
    //     //     for (int j = 0; j < grid.length; j++) {
    //     //         rows.add(grid[i][j]);
    //     //     }
    //     //     arrayRows.add(rows);
    //     // }
        
    //     // for (int i = 0 ; i < grid.length; i++){
    //     //         ArrayList<Integer> cols = new ArrayList<>();
    //     //         for (int j = 0; j < grid.length; j++) {
    //     //                 cols.add(arrayRows.get(j).get(i));
    //     //             }
    //     //             arraycols.add(cols);
    //     //         }
                
    //     for (int i = 0 ; i < grid.length; i++){
    //         ArrayList<Integer> rows = new ArrayList<>();
    //         ArrayList<Integer> cols = new ArrayList<>();
    //         for (int j = 0; j < grid.length; j++) {
    //             rows.add(grid[i][j]);
    //             cols.add(grid[j][i]);
    //         }
    //         arrayRows.add(rows);
    //         arraycols.add(cols);
    //     }

    //     System.out.println(arrayRows);
    //     System.out.println(arraycols);

    //     int count = 0;
    //     for (ArrayList r : arrayRows){
    //         for (ArrayList c : arraycols) {
    //             if (r.equals(c)) count++;
    //         }
    //     }

    //     return count;
        
    // }
    
}
