package practice.neetCode.backtracking.hard;

import java.util.*;

public class nQueens {

    public static void main(String[] args) {

        System.out.println(solveNQueens(2));

    }

    public static List<List<String>> result;
    public static List<String> temp;


    public static List<List<String>> solveNQueens(int n) {

        result = new ArrayList<>();
        temp = new ArrayList<>();

        if (n == 1){
            temp.add("Q");
            result.add(temp);
            return result;
        }
        if (n == 2){
            temp.add("Q.");
            temp.add("..");
            result.add(temp);
            return result;
        }
        
        backtracking(n);
        return result;

    }

    public static void backtracking(int n) {

    }
    
}