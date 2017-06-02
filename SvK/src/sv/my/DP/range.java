package sv.my.DP;

/**
 * Created by Surya Vamsi on 17-Jun-15.
 */
public class range {
    public static int max_subarray(int[] a) {
        int[] dp = new int[a.length]; dp[0] = a[0]; boolean x = true; int sum = a[0];
        for (int i = 1; i < dp.length; i++) {
            if (!x) sum += a[i];
            else sum += a[i];
            if (sum >= dp[i - 1]) {
                dp[i] = sum;
                if (sum < a[i]) {
                    x = false;
                    dp[i] = a[i];
                } else x = true;
            } else if (sum < dp[i - 1]) {
                dp[i] = dp[i - 1];
                x = false;
                sum = 0;
            }
        }
        return dp[dp.length - 1];
    }

}
