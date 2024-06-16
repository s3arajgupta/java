package practice.neetCode.backtracking.medium;

public class wordSearch {

    public static void main(String[] args) {

        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(exist(board, "ABCCED"));

    }

    public static boolean[][] visted;
    public static Integer ROWS;
    public static Integer COLS;

    public static boolean exist(char[][] board, String word) {

        ROWS = board.length;
        COLS = board[0].length;
        visted = new boolean[ROWS][COLS];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (backtracking(r, c, 0, word, board))
                    return true;
            }
        }
        return false;

    }

    public static boolean backtracking(int r, int c, int n, String word, char[][] board) {

        if (n == word.length())
            return true;

        if (r < 0 || c < 0 ||
                r >= ROWS || c >= COLS ||
                visted[r][c] ||
                word.charAt(n) != board[r][c])
            return false;

        visted[r][c] = true;
        boolean res = (backtracking(r - 1, c, n + 1, word, board) ||
                backtracking(r + 1, c, n + 1, word, board) ||
                backtracking(r, c + 1, n + 1, word, board) ||
                backtracking(r, c - 1, n + 1, word, board));
        visted[r][c] = false;

        return res;
    }

    // public static HashSet<Pair<Integer, Integer>> set;
    // public static Integer ROWS;
    // public static Integer COLS;

    // public static boolean exist(char[][] board, String word) {

    // set = new HashSet<>();
    // ROWS = board.length;
    // COLS = board[0].length;

    // for (int r = 0; r < board.length; r++) {
    // for (int c = 0; c < board[0].length; c++) {
    // if (backtracking(r, c, 0, word, board))
    // return true;
    // }
    // }
    // return false;

    // }

    // public static boolean backtracking(int r, int c, int n, String word, char[][]
    // board) {

    // Pair<Integer, Integer> pair = new Pair<Integer, Integer>(r, c);

    // if (n == word.length())
    // return true;

    // if ((r < 0 || c < 0) ||
    // (r >= ROWS || c >= COLS) ||
    // set.contains(pair) ||
    // word.charAt(n) != board[r][c])
    // return false;

    // set.add(pair);
    // boolean res = (backtracking(r - 1, c, n + 1, word, board) ||
    // backtracking(r + 1, c, n + 1, word, board) ||
    // backtracking(r, c + 1, n + 1, word, board) ||
    // backtracking(r, c - 1, n + 1, word, board));
    // set.remove(pair);

    // return res;
    // }

}
