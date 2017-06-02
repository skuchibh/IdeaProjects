package created;

import utils.InputReader;
import utils.OutputWriter;

public class prob {
    static int[] val;
    static int[] size;
    static int cap, n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        cap = in.nextInt();
        n = in.nextInt();
        size = new int[n];
        val = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = in.nextInt();
            val[i] = in.nextInt();
        }
        out.println(knapsack());

    }

    static int knapsack() {
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 0; i < n + 1; i++) dp[i][0] = 0;
        for (int i = 0; i < cap + 1; i++) dp[0][i] = 0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<cap+1;j++){
                if(size[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-size[i-1]]);
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][cap];

    }
}
