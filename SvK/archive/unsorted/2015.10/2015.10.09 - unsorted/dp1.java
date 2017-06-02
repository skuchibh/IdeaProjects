package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class dp1 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int cap = in.nextInt();
        int nb = in.nextInt();
        int[] weights = new int[nb];
        int[] values = new int[nb];
        for (int i = 0; i < nb; i++) {
            weights[i] = in.nextInt();
            values[i] = in.nextInt();
        }
        int[][] dp = new int[nb + 1][cap + 1];
        Arrays.fill(dp[0], 0);
        for (int j = 0; j < nb + 1; j++) dp[j][0] = 0;
        for (int i = 1; i <= nb; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j - weights[i-1] >= 0) dp[i][j] =
                        Math.max(dp[i - 1][j], values[i-1] + dp[i-1][j-weights[i-1]]);
                else dp[i][j]=dp[i-1][j];
            }
        }
        out.println(dp[nb][cap]);

    }
}
