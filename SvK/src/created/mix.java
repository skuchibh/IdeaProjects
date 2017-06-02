package created;

import utils.InputReader;
import utils.OutputWriter;

public class mix {
    static int n;
    static int[][] colors;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        try {
            while (true) {
                n = in.nextInt();
                colors=new int[n][n];
                for (int i = 0; i < n; i++) {
                    colors[i][i] = in.nextInt();
                }
                out.println(mix());
            }
        } catch (Exception e) {

        }
    }

    static int mix() {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 0;
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int val = dp[i][k] + dp[k + 1][j] + (colors[i][k] * colors[k + 1][j]);
                    if (dp[i][j] > val) {
                        dp[i][j] = val;
                        colors[i][j] = colors[i][k] + colors[k + 1][j];
                        colors[i][j] %= 100;
                    }
                }

            }
        }
        return dp[0][n - 1];
    }
}

