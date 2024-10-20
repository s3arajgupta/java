package practice.neetCode150.part11Graphs.medium;

public class surroundedRegions {

    public static void main(String[] args) {

        surroundedRegions sol = new surroundedRegions();
        char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        char[][] res = sol.solve(board);

        for (char[] row : res)
            System.out.println(row);

    }

    int m, n;
    char board[][];
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public char[][] solve(char[][] board) {

        m = board.length;
        n = board[0].length;
        this.board = board;

        for (int cols = 0; cols < n; cols++) {

            dfs(0, cols, 'O');
            dfs(m - 1, cols, 'O');

        }

        for (int rows = 0; rows < m; rows++) {

            dfs(rows, 0, 'O');
            dfs(rows, n - 1, 'O');

        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                if (board[i][j] == 'T')
                    board[i][j] = 'O';

            }

        }

        return board;

    }

    public void dfs(int i, int j, char ch) {

        if (i < 0 || j < 0 || i == m || j == n)
            return;

        if (board[i][j] != ch) // exit conditions, neighbour cell should be ch
            return;

        board[i][j] = 'T';

        for (int[] dir : directions) {

            dfs(i + dir[0], j + dir[1], ch);

        }

    }

}
