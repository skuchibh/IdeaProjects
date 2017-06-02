package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class temp {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int cities = in.nextInt();
            int roads = in.nextInt();
            int q = in.nextInt();
            List<Edge> graph[] = new List[cities + 1];
            for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
            Road[] arr = new Road[roads + 1];
            for (int i = 0; i < roads; i++) {
                int from = in.nextInt();
                int to = in.nextInt();
                int[] temp = new int[24];
                for (int k = 0; k < 24; k++)
                    temp[k] = in.nextInt();
                arr[i] = new Road(i + 1, temp);/*
                if(graph[i+1].isEmpty())graph[i+1]=new ArrayList<>();*/
                graph[from].add(new Edge(to, arr[i].cost));
            }
            while (q-- > 0) {
                int to = in.nextInt();
                int time = in.nextInt();
                int[] prio = new int[cities + 1];
                shortestPaths(graph, time, 1, prio);
                if (prio[to] != Integer.MAX_VALUE)
                    out.println(prio[to]);
                else out.println(-1);
            }


        }

    }

    public static void shortestPaths(List<Edge>[] graph, int time, int s, int[] prio) {
        int n = prio.length;
        //Arrays.fill(pred, -1);
        Arrays.fill(prio, Integer.MAX_VALUE);
        prio[s] = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || prio[u] > prio[j]))
                    u = j;
            }
            if (prio[u] == Integer.MAX_VALUE)
                break;
            visited[u] = true;
            int timex = time;
            time++;
            for (Edge e : graph[u]) {
                int v = e.t;
                int[] temp = e.cost;
                int nprio = prio[u] + temp[timex];
                if (prio[v] > nprio) {
                    prio[v] = nprio;
                    //          pred[v] = u;
                }
            }
        }
    }

    static class Edge {
        int t;
        int[] cost;

        public Edge(int t, int[] cost) {
            this.t = t;
            this.cost = cost;
        }
    }

    static class Road {
        int n;
        int[] cost;

        public Road(int n, int[] cost) {
            this.n = n;
            this.cost = cost;
        }
    }
}
