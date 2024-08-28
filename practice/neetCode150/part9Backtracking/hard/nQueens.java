package practice.neetCode150.part9Backtracking.hard;

import java.util.*;

public class nQueens {

    public static void main(String[] args) {

        nQueens sol = new nQueens();

        System.out.println(sol.solveNQueens(1));
        System.out.println(sol.solveNQueens(2));
        System.out.println(sol.solveNQueens(4));
        // System.out.println(sol.solveNQueens(8));

    }

    List<List<String>> result;
    List<String> temp;
    int dimension;
    HashSet<Integer> colsSet; // ranks
    HashSet<Integer> posDSet; // r + c = constant
    HashSet<Integer> negDSet; // r - c = constant

    public List<List<String>> solveNQueens(int n) {

        result = new ArrayList<>();
        temp = new ArrayList<>();
        this.dimension = n;
        colsSet = new HashSet<>();
        posDSet = new HashSet<>();
        negDSet = new HashSet<>();

        for (int i = 0; i < n; i++) {

            char[] row = new char[n];
            Arrays.fill(row, '.');

            temp.add(new String(row));

        }

        backtracking(0);
        return result;

    }

    // row by row
    public void backtracking(int row) {

        if (row == dimension) {

            result.add(new ArrayList<>(temp));
            return;

        }

        for (int col = 0; col < dimension; col++) {

            if (colsSet.contains(col) || posDSet.contains(row + col) || negDSet.contains(row - col))
                continue;

            setCharAt(row, col, 'Q');
            colsSet.add(col);
            posDSet.add(row + col);
            negDSet.add(row - col);

            backtracking(row + 1);

            setCharAt(row, col, '.');
            colsSet.remove(col);
            posDSet.remove(row + col);
            negDSet.remove(row - col);

        }

    }

    public void setCharAt(int row, int col, char c) {

        char[] arr = temp.get(row).toCharArray();
        arr[col] = c;

        temp.set(row, new String(arr));

    }

}
