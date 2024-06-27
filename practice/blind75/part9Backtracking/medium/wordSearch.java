package practice.blind75.part9Backtracking.medium;

public class wordSearch {

    public static void main(String[] args) {

        wordSearch sol = new wordSearch();
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(sol.exist(board, "ABCCED"));

    }

    public char[][] board;
    public String word;
    public Integer ROWS;
    public Integer COLS;
    public boolean[][] visted;

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.word = word;
        ROWS = board.length;
        COLS = board[0].length;
        visted = new boolean[ROWS][COLS];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (backtracking(r, c, 0))
                    return true;
            }
        }
        return false;

    }

    public boolean backtracking(int r, int c, int n) {

        if (n == word.length())
            return true;

        if (r < 0 || c < 0 ||
                r == ROWS || c == COLS ||
                visted[r][c] ||
                word.charAt(n) != board[r][c])
            return false;

        visted[r][c] = true;
        boolean res = (backtracking(r - 1, c, n + 1) ||
                backtracking(r + 1, c, n + 1) ||
                backtracking(r, c + 1, n + 1) ||
                backtracking(r, c - 1, n + 1));
        visted[r][c] = false;

        return res;
        
    }

}
