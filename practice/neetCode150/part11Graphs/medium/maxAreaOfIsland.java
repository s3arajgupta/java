package practice.neetCode150.part11Graphs.medium;

public class maxAreaOfIsland {

    public static void main(String[] args) {

        maxAreaOfIsland sol = new maxAreaOfIsland();
        int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
        System.out.println(sol.maxAreaOfIslandFunc(grid));

    }

    int m, n;
    boolean[][] visited;
    int max;
    int currArea;

    public int maxAreaOfIslandFunc(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        max = 0;
        currArea = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (!visited[i][j] && grid[i][j] == 1) {

                    area(grid, i, j);
                    max = currArea > max ? currArea : max;
                    currArea = 0;

                }

            }

        }

        return max;

    }

    public void area(int[][] grid, int i, int j) {

        if (i < 0 ||
                j < 0 ||
                i == m ||
                j == n)
            return;

        if (visited[i][j] || grid[i][j] == 0)
            return;

        visited[i][j] = true;
        currArea += 1;

        area(grid, i + 1, j);
        area(grid, i - 1, j);
        area(grid, i, j + 1);
        area(grid, i, j - 1);

        // return (1 + maxAreaOfIsland(grid, r + 1, c) +
        // maxAreaOfIsland(grid, r - 1, c) +
        // maxAreaOfIsland(grid, r, c + 1) +
        // maxAreaOfIsland(grid, r, c - 1));

    }

}
