package sv.my;

import java.util.List;

/**
 * Created by Surya Vamsi on 04-Jul-15.
 */
public class GraphUtils {
    static List<Integer>[] list;
    static boolean[] vis;

    public static int numberofConnectedComponents(List<Integer>[] graph) {
        list = graph;
        int con = 0;
        vis = new boolean[list.length];
        for (int i = 1; i < graph.length; i++) {
            if (!vis[i]) {
                dfs(i);
                con++;
            }
        }
        return con;
    }

    static void dfs(int n) {
        vis[n] = true;
        for (int i = 0; i < list[n].size(); i++) {
            int x = list[n].get(i);
            if (!vis[x]) dfs(x);
        }
    }
}