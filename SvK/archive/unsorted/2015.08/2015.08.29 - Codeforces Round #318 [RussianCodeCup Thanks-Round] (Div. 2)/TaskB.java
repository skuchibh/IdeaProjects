package created;

import utils.InputReader;
import utils.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int e = in.nextInt();
        int[] degree = new int[n + 1];
        boolean[][] g = new boolean[n + 1][n + 1];
        for (int i = 0; i < e; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x][y] = true;
            g[y][x] = true;
            degree[x]++;
            degree[y]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if(g[i][j])
                for (int k = j+1; k <= n; k++) {
                    if (g[j][k] && g[i][k]) {
                        min = Math.min(degree[i] + degree[j] + degree[k], min);
                    }
                }
            }
        }if(min==Integer.MAX_VALUE)min=0;
        out.println(min - 6>=0?min-6:-1);
    }

}
