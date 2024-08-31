package practice.neetCode150.part11Graphs.medium;

import java.util.*;

import modules.Pair;

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

    private int island;
    private char[][] grid;
    private HashSet<Pair<Integer, Integer>> visited;
    private Pair<Integer, Integer> pair;
    private Deque<Pair<Integer, Integer>> deque;
    public List<Pair<Integer, Integer>> directions;

    public int numIslands(char[][] grid) {

        if (grid.length == 0 && grid[0].length == 0)
            return 0;

        island = 0;
        this.grid = grid;
        visited = new HashSet<>();
        System.out.println(visited);
        List<Pair<Integer, Integer>> directions = new ArrayList<>();
        directions.add(new Pair<Integer, Integer>(1, 0));
        directions.add(new Pair<Integer, Integer>(-1, 0));
        directions.add(new Pair<Integer, Integer>(0, 1));
        directions.add(new Pair<Integer, Integer>(0, -1));
        this.directions = directions;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                pair = new Pair<Integer, Integer>(i, j);
                if (grid[i][j] == '1' && !visited.contains(pair)) {
                    island++;
                    System.out.println("hel");
                    bfs(i, j);
                    // deque.removeAll(deque);
                }
            }
        }

        return island;

    }

    public void bfs(int i, int j) {

        deque = new LinkedList<>();
        visited.add(new Pair<Integer, Integer>(i, j));
        deque.add(new Pair<Integer, Integer>(i, j));

        // int size = deque.size();
        while (!deque.isEmpty()) {

            pair = deque.removeFirst();
            for (int d = 0; d < directions.size(); d++) {
                Pair<Integer, Integer> temp = new Pair<Integer, Integer>(directions.get(d).getFirst() + pair.getFirst(),
                        directions.get(d).getSecond() + pair.getSecond());
                if (temp.getFirst() >= 0 && temp.getSecond() >= 0
                        && temp.getFirst() < grid.length
                        && temp.getSecond() < grid[0].length
                        && grid[pair.getFirst() + directions.get(d).getFirst()][pair.getSecond()
                                + directions.get(d).getSecond()] == '1'
                        && !visited.contains(temp)) {
                    deque.add(temp);
                    visited.add(temp);
                }
            }

        }

    }

}