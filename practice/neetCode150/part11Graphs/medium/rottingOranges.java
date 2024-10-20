package practice.neetCode150.part11Graphs.medium;

import java.util.Deque;
import java.util.LinkedList;

public class rottingOranges {

    public static void main(String[] args) {

        rottingOranges sol = new rottingOranges();
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

        System.out.println(sol.orangesRotting(grid));

    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int time = 0;
        int freshOranges = 0;
        Deque<int[]> deque = new LinkedList<>();

        // multi-sourced BFS prep
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2)
                    deque.add(new int[] { i, j });

                if (grid[i][j] == 1)
                    freshOranges++;

            }

        }

        // If no fresh oranges, return 0 immediately
        if (freshOranges == 0)
            return 0;

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!deque.isEmpty() && freshOranges > 0) {

            int size = deque.size();

            for (int i = 0; i < size; i++) {

                int[] currPair = deque.removeFirst();

                for (int[] dir : directions) {

                    int[] newPair = new int[] { currPair[0] + dir[0],
                            currPair[1] + dir[1] };

                    // Check if the new position is valid and does not contains a fresh orange
                    if (newPair[0] < 0 ||
                            newPair[0] == m ||
                            newPair[1] < 0 ||
                            newPair[1] == n ||
                            grid[newPair[0]][newPair[1]] != 1)
                        continue;

                    grid[newPair[0]][newPair[1]] = 2;
                    freshOranges--;
                    deque.add(new int[] { newPair[0], newPair[1] });

                }

            }

            time++;

        }

        return (freshOranges == 0) ? time : -1;

    }

}
