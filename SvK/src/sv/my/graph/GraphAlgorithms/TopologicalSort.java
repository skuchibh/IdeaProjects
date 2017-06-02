package sv.my.graph.GraphAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Surya Vamsi on 27-Aug-15.
 */
public class TopologicalSort {

    public static List<Integer> topologicalSort(List<Integer>[] graph,int a) {
        int n =a;
        boolean[] used = new boolean[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!used[i]) dfs(graph, used, res, i);
        }
        Collections.reverse(res);
        return res;
    }

    static void dfs(List<Integer>[] graph, boolean[] used, List<Integer> res, int u) {
        used[u] = true;
        //if(graph[u]==null)graph[u]=new ArrayList<>();
        try {
            for (int v : graph[u])
                if (!used[v]) dfs(graph, used, res, v);
        }
        catch (Exception e){
            System.out.println("u = " + u);
        }

        res.add(u);
        //System.out.println(res);
    }
}
