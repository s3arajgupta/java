package practice.neetCode150.part11Graphs.medium;

import java.util.*;

public class pacificAtlanticWaterFlow {

    public static void main(String[] args) {

        pacificAtlanticWaterFlow sol = new pacificAtlanticWaterFlow();
        int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 } };

        System.out.println(sol.pacificAtlantic(heights));

    }

    int m, n;
    boolean[][] pacific;
    boolean[][] atlantic;
    int[][] heights;
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        m = heights.length;
        n = heights[0].length;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];
        this.heights = heights;

        for (int cols = 0; cols < n; cols++) {

            dfs(0, cols, pacific, heights[0][cols]);
            dfs(m - 1, cols, atlantic, heights[m - 1][cols]);

        }

        for (int rows = 0; rows < m; rows++) {

            dfs(rows, 0, pacific, heights[rows][0]);
            dfs(rows, n - 1, atlantic, heights[rows][n - 1]);

        }

        // System.out.println("pacific");
        // for (boolean[] i : pacific) {
        // System.out.println(Arrays.toString(i));
        // }
        // System.out.println("atlantic");
        // for (boolean[] i : atlantic) {
        // System.out.println(Arrays.toString(i));
        // }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {

                    res.add(new ArrayList<>(Arrays.asList(i, j)));

                }

            }

        }

        return res;

    }

    public void dfs(int i, int j, boolean[][] ocean, int prevHeight) {

        if (i < 0 ||
                i == m ||
                j < 0 ||
                j == n)
            return;

        if (heights[i][j] < prevHeight || ocean[i][j]) // Early termination
            return;

        ocean[i][j] = true;

        for (int[] dir : directions) {

            dfs(i + dir[0], j + dir[1], ocean, heights[i][j]);

        }

    }

}
