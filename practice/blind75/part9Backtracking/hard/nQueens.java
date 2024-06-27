package practice.blind75.part9Backtracking.hard;

import java.util.*;

public class nQueens {

    public static void main(String[] args) {

        nQueens sol = new nQueens();
        System.out.println(sol.solveNQueens(4));
        System.out.println(sol.solveNQueens(2));

    }

    public List<List<String>> result;
    public List<String> temp;
    public int queens;

    public HashSet<Integer> cols; // same cols (vertical)
    public HashSet<Integer> posD; // r + c = constant
    public HashSet<Integer> negD; // r - c = constant

    public List<List<String>> solveNQueens(int n) {

        result = new ArrayList<>();
        temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.'); // ninja
            // temp.add(row.toString()); // not ninja
            temp.add(new String(row));
        }

        cols = new HashSet<>();
        posD = new HashSet<>();
        negD = new HashSet<>();
        this.queens = n;
        backtracking(0); // row by row
        return result;

    }

    public void setCharAt(int row, int col, char c) {

        char[] arr = temp.get(row).toCharArray();
        arr[col] = c;
        temp.set(row, new String(arr));

    }

    public void backtracking(int row) {

        if (row == queens) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // medium - hard problem
        for (int col = 0; col < queens; col++) {

            if (cols.contains(col) || posD.contains(row + col) || negD.contains(row - col))
                continue;

            setCharAt(row, col, 'Q');
            cols.add(col);
            posD.add(row + col);
            negD.add(row - col);

            backtracking(row + 1);

            setCharAt(row, col, '.');
            cols.remove(col);
            posD.remove(row + col);
            negD.remove(row - col);

        }

    }

}
