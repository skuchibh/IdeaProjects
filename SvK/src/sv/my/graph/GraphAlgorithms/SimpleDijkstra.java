package sv.my.graph.GraphAlgorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Surya Vamsi on 21-Sep-15.
 */
public class SimpleDijkstra {
    public static void main(String[] args) {

    }
    static void shortestPaths(List<Edge>[] graph, int source, int[] dis) {
        int n = dis.length;
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[source] = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (i == -1 || dis[u] > dis[j])) u = j;
            }
            if (dis[u] == Integer.MAX_VALUE) break;
            vis[u] = true;
            for (Edge e : graph[u]) {
                int v = e.t;
                int ndis=dis[u]+e.cost;
                if(dis[v]>ndis){
                    dis[v]=ndis;
                }
            }
        }
    }

    static class Edge {
        int t;
        int cost;

        public Edge(int t, int cost) {
            this.t = t;
            this.cost = cost;
        }
    }
}
