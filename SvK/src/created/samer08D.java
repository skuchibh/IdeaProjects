package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;
import java.util.jar.Pack200;

public class samer08D {
    static int check;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            check = in.nextInt();
            if(check==0)return;
            String a = in.readLine();
            String b = in.readLine();
            out.println(LCS(a, b));
        }
    }

    static int LCS(String a, String b) {
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        int min = 0;
        int[][] dp = new int[x.length + 1][y.length + 1];
        int[][] ans = new int[x.length + 1][y.length + 1];
        int max = 0;
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                ans[i][j] = Math.max(ans[i - 1][j], ans[i][j - 1]);
                dp[i][j] = 0;
                if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] >= check) {
                        for (int z = check; z < dp[i][j] + 1; z++) {
                            ans[i][j] = Math.max(ans[i][j], ans[i - z][j - z] + z);
                        }
                    }
                }
            }
        }

        /*for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/
        return ans[x.length][y.length];

    }
}
