package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskC {
    static List<Integer>[] edges;
    static int ans = 0;
    static int max;
    static int[] c;
    static boolean[] vis;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int cats = in.nextInt();
        c = IOUtils.readIntArray(in, n);
        edges = new List[n];
        for (int i = 0; i < edges.length; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int x=in.nextInt();int y=in.nextInt();
            x--;y--;
            edges[x].add(y);
            edges[y].add(x);
        }
        vis = new boolean[n];
        max = cats;
        int catc = c[0];
        ans = 0;
        dfs(0, c[0]);
        out.println(ans);

    }

    private void dfs(int i, int catcount) {
        //System.out.println("catcount = " + catcount);

        if (vis[i] || catcount > max) return;
        if (edges[i].size() == 1 && i != 0) {
            if (catcount > max) {
                return;
            }
            ans++;
        }
        vis[i] = true;
        for (int k = 0; k < edges[i].size(); k++) {

            if (c[edges[i].get(k)] == 1) {
                dfs(edges[i].get(k), catcount + 1);
            } else dfs(edges[i].get(k), 0);
        }
    }
}
