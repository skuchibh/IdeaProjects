package created;

import utils.InputReader;
import utils.OutputWriter;

public class mob {
    static int[] side;
    static int[] dp;
    static int[] ok;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        side = new int[11];
        dp = new int[1000001];
        side[0] = 2;
        for (int i = 1; i <= 8; i++) {
            side[i] = 3;

        }
        side[9] = 2;

    }

    static void preCompute() {
        dp[0] = 1;
        for (int i = 1; i <= 9; ++i) {
            dp[i] = dp[i - 1] + 1;
        }

    }
}
