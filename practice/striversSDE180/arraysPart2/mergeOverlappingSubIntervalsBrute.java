package practice.striversSDE180.arraysPart2;

import java.util.*;

public class mergeOverlappingSubIntervalsBrute {

    public static void main(String[] args) {

        // int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // int[][] arr = {{1, 3}};
        // int[][] arr = {{1, 4}, {5, 6}};
        
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(1, 3)));
        arr.add(new ArrayList<>(Arrays.asList(2, 6)));
        arr.add(new ArrayList<>(Arrays.asList(8, 10)));
        arr.add(new ArrayList<>(Arrays.asList(10, 18)));
        // arr.add(new ArrayList<>(Arrays.asList(1, 4)));
        // arr.add(new ArrayList<>(Arrays.asList(4, 5)));
        // arr.add(new ArrayList<>(Arrays.asList(1, 3)));
        // arr.add(new ArrayList<>(Arrays.asList(1, 4)));
        // arr.add(new ArrayList<>(Arrays.asList(5, 6)));
        // arr.add(new ArrayList<>(Arrays.asList(7, 8)));
        // arr.add(new ArrayList<>(Arrays.asList(8, 9)));

        arr = mergeOverlappingSubIntervalsBruteFunc(arr);
        System.out.println(arr);
        // for (int[] row : arrayRes){
        //     System.out.println(row[0] + " " + row[1]); 
        // }
    }

    public static List<List<Integer>> mergeOverlappingSubIntervalsBruteFunc(List<List<Integer>> arr){

        List<List<Integer>> res = new ArrayList<>();

        if (arr.size() == 0) return arr;    
        if (arr.size() == 1) return arr;
        res.add(Arrays.asList(arr.get(0).get(0), arr.get(0).get(1)));
        for (int i = 1; i < arr.size(); i++){
            if (arr.get(i).get(0) <= res.get(res.size()-1).get(1)){
                System.out.println("if");
                // res.add(new ArrayList<>(Arrays.asList(arr.get(current).get(0), arr.get(i+1).get(1))));
                res.get(res.size()-1).set(1, arr.get(i).get(1));
                // current = i;
            }
            else{
                System.out.println("else");
                res.add(new ArrayList<>(Arrays.asList(arr.get(i).get(0), arr.get(i).get(1))));
            }
            System.out.println(res.toString());
        }

        return res;
    } 
    
}
