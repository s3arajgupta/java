package practice.neetCode150.part11Graphs.medium;

public class numberOfIslands {

    public static void main(String[] args) {

        numberOfIslands sol = new numberOfIslands();
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(sol.numIslands(grid));

    }

    int island;
    int m;
    int n;
    boolean[][] visited;

    public int numIslands(char[][] grid) {

        island = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (!visited[i][j] && grid[i][j] == '1') {

                    island++;
                    sizeOfIslands(visited, grid, i, j);

                }

            }

        }

        return island;

    }

    public void sizeOfIslands(boolean[][] visited, char[][] grid, int i, int j) {

        if (i < 0 ||
                j < 0 ||
                i == m ||
                j == n)
            return;

        if (visited[i][j] || grid[i][j] == '0')
            return;

        visited[i][j] = true;

        sizeOfIslands(visited, grid, i + 1, j);
        sizeOfIslands(visited, grid, i - 1, j);
        sizeOfIslands(visited, grid, i, j + 1);
        sizeOfIslands(visited, grid, i, j - 1);

    }

}