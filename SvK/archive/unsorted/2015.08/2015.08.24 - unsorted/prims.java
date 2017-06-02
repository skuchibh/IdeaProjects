package created;

import sv.misc.ArrayUtils;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class prims {
    static int V;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        V = in.nextInt();
        int e = in.nextInt();
        int[][] g = new int[V][V];
        ArrayUtils.fill(g,Integer.MAX_VALUE);
        for (int i = 0; i < e; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            int cost = in.nextInt();
            g[x][y] = cost;
            g[y][x]=cost;
        }
        for(int i=0;i<V;i++)g[i][i]=0;
        int source = in.nextInt() - 1;
        out.println(prim(g, source));

    }

    long prim(int[][] graph, int source) {
        int parent[] = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];
        for (int i = 0; i < V; i++) {
            mstSet[i] = false;
            key[i] = Integer.MAX_VALUE;
        }
        key[source] = 0;
        parent[source] = -1;
        for (int count = 0; count < V; count++) {
            int u = minKey(key, mstSet);
        //System.out.println(Arrays.toString(key));
            mstSet[u] = true;
            //System.out.println(Arrays.toString(mstSet));
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != Integer.MAX_VALUE && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
            //System.out.println("key2 = " + Arrays.toString(key));
        }
       // System.out.println(Arrays.toString(key));
        long sum = 0;
        for (int x : key) sum += x;
        return sum;
    }

    int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < V; i++) {
            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                index = i;
            }
        }
      //  System.out.println("index = " + (index+1));
        return index;
    }
}
