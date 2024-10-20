package modules;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class AdjacencyList {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {

        adj.get(i).add(j);
        adj.get(j).add(i);

    }

    public static ArrayList<Integer> bfsTraversal(int n, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Deque<Integer> deque = new LinkedList<>();

        deque.add(n);
        visited[n] = true;

        while (!deque.isEmpty()) {

            int node = deque.removeFirst();
            bfs.add(node);

            for (int j : adj.get(node)) {

                if (!visited[j]) {

                    deque.add(j);
                    visited[j] = true;

                }

            }

        }

        return bfs;

    }

    public static ArrayList<Integer> dfsTraversal(int startNode, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];

        dfs(startNode, dfs, adj, visited);

        return dfs;

    }

    public static void dfs(int n, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        visited[n] = true;
        dfs.add(n);

        for (int i : adj.get(n)) {

            if (!visited[i]) {

                dfs(i, dfs, adj, visited);

            }

        }

    }

    public static void main(String[] args) {

        int n = 5;
        int[][] edges = { { 2, 1 }, { 1, 3 }, { 2, 4 }, { 3, 4 }, { 2, 5 }, { 4, 5 } };

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++)
            addEdge(adj, edges[i][0], edges[i][1]);

        System.out.println("adj: " + adj);

        System.out.println("BFS: " + bfsTraversal(1, adj));
        System.out.println("DFS: " + dfsTraversal(1, adj));

    }

}
