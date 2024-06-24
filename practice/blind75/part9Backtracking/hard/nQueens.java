// medium - hard problem

package practice.blind75.part9Backtracking.hard;

import java.util.*;

public class nQueens {

    public static void main(String[] args) {

        System.out.println(solveNQueens(4));

    }

    public static List<List<String>> result;
    public static List<String> board;

    public static HashSet<Integer> cols;
    public static HashSet<Integer> posD; // r + c = constant
    public static HashSet<Integer> negD; // r - c = constant

    public static List<List<String>> solveNQueens(int n) {

        result = new ArrayList<>();
        board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            // board.add(row.toString()); // not ninja
            board.add(new String(row));
        }
        // System.out.println(board);

        cols = new HashSet<>();
        posD = new HashSet<>();
        negD = new HashSet<>();

        backtracking(0, n, board); // row by row
        return result;

    }

    public static void setCharAt(int row, int col, char c, List<String> board) {

        char[] arr = board.get(row).toCharArray();
        arr[col] = c;
        board.set(row, new String(arr));

    }

    public static void backtracking(int row, int n, List<String> board) {

        if (row == n) {
            result.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (cols.contains(col) || posD.contains(row + col) || negD.contains(row - col))
                continue;

            // board.set(row, newRow(col, board.get(row)));
            setCharAt(row, col, 'Q', board);

            cols.add(col);
            posD.add(row + col);
            negD.add(row - col);

            backtracking(row + 1, n, board);

            // board.set(row, oldRow(col, board.get(row)));
            setCharAt(row, col, '.', board);

            cols.remove(col);
            posD.remove(row + col);
            negD.remove(row - col);

        }

    }

}

// public class nQueens {

// public static void main(String[] args) {

// System.out.println(solveNQueens(4));

// }

// public static List<List<String>> result;
// public static List<String> board;

// public static HashSet<Integer> cols;
// public static HashSet<Integer> posD; // r + c = constant
// public static HashSet<Integer> negD; // r - c = constant
// public static StringBuilder tempstr;

// public static List<List<String>> solveNQueens(int n) {

// result = new ArrayList<>();
// board = new ArrayList<>();

// tempstr = new StringBuilder();
// for (int i = 0; i < n; i++) {
// tempstr.setLength(0);
// for (int j = 0; j < n; j++) {
// tempstr.append(".");
// }
// board.add(tempstr.toString());
// }
// // System.out.println(board);

// cols = new HashSet<>();
// posD = new HashSet<>();
// negD = new HashSet<>();

// // if (n == 1) {
// // board.add("Q");
// // board.add(board);
// // return board;
// // }
// // if (n == 2) {
// // board.add("Q.");
// // board.add("..");
// // board.add(board);
// // return board;
// // }

// backtracking(0, n, board); // row by row
// return result;

// }

// public static String newRow(int col, String str) {

// tempstr = new StringBuilder(str);
// tempstr.setCharAt(col, 'Q');
// return tempstr.toString();

// }

// public static String oldRow(int col, String str) {

// tempstr = new StringBuilder(str);
// tempstr.setCharAt(col, '.');
// return tempstr.toString();

// }

// public static void backtracking(int row, int n, List<String> board) {

// if (row == n) { // end case
// // result.add(board); // The issue with your code is that you are adding the
// // board list directly to the result list. This means that when you make
// changes
// // to the board list, those changes are reflected in the result list as well
// // because both are pointing to the same memory reference. To fix this, you
// need
// // to create a deep copy of the board list before adding it to the result
// list.
// // System.out.println("board " + board);
// // System.out.println(result);
// result.add(new ArrayList<>(board));
// return;
// }

// for (int col = 0; col < n; col++) { // try for every row

// if (cols.contains(col) || posD.contains(row + col) || negD.contains(row -
// col))
// continue;

// // board.set(row, "Q");
// board.set(row, newRow(col, board.get(row)));
// // System.out.println("Q " + board);

// cols.add(col);
// posD.add(row + col);
// negD.add(row - col);

// backtracking(row + 1, n, board);

// // board.set(row, ".");
// board.set(row, oldRow(col, board.get(row)));
// // System.out.println(". " + board);

// cols.remove(col);
// posD.remove(row + col);
// negD.remove(row - col);

// }

// }

// }