package created;

import utils.InputReader;
import utils.OutputWriter;

public class woodcutters {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] x = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            h[i] = in.nextInt();
        }
        int[][] dp = new int[n][3];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max((x[i] - h[i] > x[i - 1] ? dp[i - 1][0] + 1 : 0),
                    Math.max((x[i] - h[i] > x[i - 1] ? dp[i - 1][1] + 1 : 0),
                            x[i] - h[i] > x[i - 1] + h[i - 1] ? dp[i - 1][2] + 1 : 0));
            dp[i][1] = Math.max((x[i] > x[i - 1] ? dp[i - 1][0] : 0),
                    Math.max((x[i] > x[i - 1] ? dp[i - 1][1] : 0),
                            x[i] > x[i - 1] + h[i - 1] ? dp[i - 1][2] : 0));
//            if (i == n - 1) continue;
            dp[i][2] = Math.max((x[i - 1] < x[i] ? dp[i - 1][0] + 1 : 0),
                    Math.max((x[i - 1] < x[i] ? dp[i - 1][1] + 1 : 0),
                            x[i] > x[i - 1] + h[i - 1] ? dp[i - 1][2] + 1 : 0));

        }
        out.println(Math.max(dp[n - 1][1], Math.max(dp[n - 1][0], dp[n - 1][2])));
    }
}
