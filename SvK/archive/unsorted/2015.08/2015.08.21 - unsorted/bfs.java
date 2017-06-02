package created;

import sv.misc.ArrayUtils;
import sv.my.Queues.MinPriorityQueue;
import sv.my.graph.DirectedEdge;
import sv.my.graph.EdgeWeighedDigraph;
import sv.my.graph.GraphAlgorithms.DjikstrasAlgorithm;
import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class bfs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        //int t = in.nextInt();

        int n = in.nextInt();
        int e = in.nextInt();
        int[][] graph = new int[n][n];
        ArrayUtils.fill(graph, Integer.MAX_VALUE / 2 - 10);
        for (int i = 0; i < n; i++) graph[i][i] = 0;
        for (int i = 0; i < e; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            int cost = in.nextInt();
            graph[x][y] = cost;
        }
        
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        int q=in.nextInt();
        while(q-->0){
            int x=in.nextInt()-1;int y=in.nextInt()-1;
            if(graph[x][y]==Integer.MAX_VALUE/2-10)out.println(-1);
            else
            out.println(graph[x][y]);
        }
    }
}
