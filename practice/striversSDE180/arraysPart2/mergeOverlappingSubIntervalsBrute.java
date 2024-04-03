package practice.striversSDE180.arraysPart2;

import java.util.*;

public class mergeOverlappingSubIntervalsBrute {

    public static void main(String[] args) {

        // int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // int[][] arr = {{1, 3}};
        int[][] arr = {{1, 4}, {5, 6}};
        // List<List<Integer>> arr = new ArrayList<>();

        // arr.add(new ArrayList<>(Arrays.asList(1, 3)));
        // arr.add(new ArrayList<>(Arrays.asList(2, 6)));
        // arr.add(new ArrayList<>(Arrays.asList(8, 10)));
        // arr.add(new ArrayList<>(Arrays.asList(15, 18)));
        // arr.add(new ArrayList<>(Arrays.asList(1, 4)));
        // arr.add(new ArrayList<>(Arrays.asList(4, 5)));

        int [][] arrayRes = mergeOverlappingSubIntervalsBruteFunc(arr);
        for (int[] row : arrayRes){
            System.out.println(row[0] + " " + row[1]); 
        }
    }

    public static int[][] mergeOverlappingSubIntervalsBruteFunc(int [][] intervals){

        List<List<Integer>> outer = new ArrayList<>();
        for (int[] row : intervals){
            List<Integer> inner = new ArrayList<>();
            for(Integer ele : row){
                inner.add(ele);
            }
            outer.add(inner);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        if (outer.size() == 1) res.add(outer.get(0));
        for(int i = 1; i < outer.size(); i++){
            if(outer.get(i-1).get(1) >= outer.get(i).get(0)){
                res.add(new ArrayList<>(Arrays.asList(outer.get(i-1).get(0), outer.get(i).get(1))));
                // continue;
                // System.out.println(i);
            }
            res.add(outer.get(i));
        }

        // System.out.println("res.toString()");
        // System.out.println(res.toString());

        int[][] arrayRes = new int[res.size()][2];
        for (int i = 0; i < arrayRes.length; i++){
                arrayRes[i][0] = res.get(i).get(0); 
                arrayRes[i][1] = res.get(i).get(1); 
                // System.out.println(arrayRes[i][0] + " " + arrayRes[i][1]);
        }

        return arrayRes;
    } 
    
}
