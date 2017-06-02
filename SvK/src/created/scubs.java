package created;

import sv.misc.ArrayUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;
import java.util.HashMap;

public class scubs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        for (int ii = 1; ii <= t; ii++) {
            int n = in.nextInt();
            int e = in.nextInt();
            int[][] order = new int[n][3];
            int[][] g = new int[n][n];
            for (int[] x : g) Arrays.fill(x, Integer.MAX_VALUE / 2 - 10);
            for (int j = 0; j < n; j++) g[j][j] = 0;
            for (int k = 0; k < e; k++) {
                int from = in.nextInt();
                int to = in.nextInt();
                int cost = in.nextInt();
                g[from][to] = Math.min(g[from][to], cost);
                g[to][from] = Math.min(g[to][from], cost);
                int[] temp = {to, from, cost};
                order[k] = temp;
            }
            for (int k = 0; k < n; k++)
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
            for(int i=0;i<order.length;i++){
                int from=order[i][0];
                int to=order[i][1];
                int cost=order[i][2];
                if(g[from][to]!=cost && g[to][from]!=cost)out.println(i);
            }
        }
    }
}
