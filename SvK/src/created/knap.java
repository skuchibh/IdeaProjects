package created;

import utils.InputReader;
import utils.OutputWriter;

public class knap {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int max = in.nextInt();
            int[] dp = new int[max + 1];
            dp[0] = 0;
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++) {
                arr[i + 1] = in.nextInt();
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < arr.length; j++) {
                    if (arr[j] > i) continue;
                    dp[i] = Math.max(dp[i],arr[j]+dp[i-arr[j]]);
                }
            }
            out.println(dp[max]);
        }
    }
}
