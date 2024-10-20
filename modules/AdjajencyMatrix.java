package modules;

public class AdjajencyMatrix {

    public static void addEdge(int[][] mat, int i, int j) {

        mat[i][j] = 1;
        mat[j][i] = 1; // Since the graph is undirected

    }

    public static void displayMatrix(int[][] mat) {

        for (int[] row : mat) {

            for (int element : row)
                System.out.print(element + " ");

            System.out.println();

        }

    }

    public static void main(String[] args) {

        int n = 5;
        int[][] edges = { { 2, 1 }, { 1, 3 }, { 2, 4 }, { 3, 4 }, { 2, 5 }, { 4, 5 } };

        int[][] mat = new int[n + 1][n + 1]; // one-based graph

        for (int i = 0; i < edges.length; i++)
            addEdge(mat, edges[i][0], edges[i][1]);

        displayMatrix(mat);

    }

}
