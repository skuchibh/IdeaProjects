package sv.my.graph.GraphAlgorithms;

import sv.my.graph.DirectedEdge;

/**
 * Created by Surya Vamsi on 16-Aug-15.
 */
public class FloydWarshall {
    private boolean hasNegativeCycle;
    private long[][] distTo;
    private DirectedEdge[][] edgeTo;

    public static int[][] FloydWarshall(int[][] graph, int n) {
        int[][] graphh = new int[n][n];
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    graphh[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
        return graphh;
    }


}
