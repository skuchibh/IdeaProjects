package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class faridaa {
    static long[] a;
    static long[] dp;
    static int mons;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            out.print("Case " + tt + ": ");
            mons = in.nextInt();
            a = IOUtils.readLongArray(in, mons);
            dp = new long[mons];
            Arrays.fill(dp, -1);
            out.println(f(0));
        }
    }

    static long f(int index) {
        if (index >= mons) return 0;
        if (index == mons - 1) return a[index];
        if (dp[index] != -1) return dp[index];
        long max = Long.MIN_VALUE;
        max = Math.max(a[index] + f(index + 2), f(index + 1));
        dp[index] = max;
        return dp[index];
    }
}
