package practice.neetCode150.part1ArrayAndHashing.medium;

import java.util.*;

public class validSudoku {

    public static void main(String args[]) {

        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println(isValidSudoku(board));

    }

    public static boolean isValidSudoku(char[][] board) {

        int len = board.length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len; j++) {

                if (board[i][j] != '.') {

                    if (set.contains(i + "row" + board[i][j]) ||
                            set.contains(j + "col" + board[i][j]) ||
                            set.contains(i / 3 + " " + j / 3 + "box" + board[i][j]))
                        return false;

                    set.add(i + "row" + board[i][j]);
                    set.add(j + "col" + board[i][j]);
                    set.add(i / 3 + " " + j / 3 + "box" + board[i][j]);

                }

            }

        }

        return true;

    }

}
