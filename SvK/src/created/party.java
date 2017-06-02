package created;

import utils.InputReader;
import utils.OutputWriter;

public class party {
    static int cap, n;
    static int[] cost;
    static int[] fun;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            cap = in.nextInt();
            n = in.nextInt();
            if (cap == 0 && n == 0) break;
            cost = new int[n];
            fun = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = in.nextInt();
                fun[i] = in.nextInt();
            }
            out.println(knap());
        }
    }

    static String knap() {
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 0; i < n + 1; i++) dp[i][0] = 0;
        for (int i = 0; i < cap + 1; i++) dp[0][i] = 0;
        int maxFun = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < cap + 1; j++) {
                if (cost[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], fun[i - 1] + dp[i - 1][j - cost[i - 1]]);

                } else {
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }
        int minMoney = 0;
        for (int i = 0; i < cap + 1; i++) {
            if (dp[n][i] == dp[n][cap]) {
                minMoney = i;
                break;
            }
        }

        int i = n;
        int j = minMoney;
        int optMoney = 0;
        while(i>0 && j>0){
            if(dp[i-1][j]!=dp[i][j]){
                optMoney+=cost[i-1];
                i--;
                j-=cost[i];
            }
            else --i;
        }
        return "" + optMoney + " " + dp[n][cap];

    }
}
