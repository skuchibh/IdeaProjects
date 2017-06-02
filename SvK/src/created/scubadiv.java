package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class scubadiv {
    static cylinder[] arr;
    static int n;
    static int ch;
    static int reqA, reqB;
    static int[][][] dp, check;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        ch = 1010101010;
        while (t-- > 0) {
            reqA = in.nextInt();
            reqB = in.nextInt();
            n = in.nextInt();
            dp = new int[n + 1][reqA + 1][reqB + 1];
            check = new int[n + 1][reqA + 1][reqB + 1];
            arr = new cylinder[n + 1];
            for (int i = 0; i < n; i++) {
                int xx = in.nextInt();
                int yy = in.nextInt();
                int zz = in.nextInt();
                arr[i + 1] = new cylinder(xx, yy, zz);
            }
            out.println(min(1, 0, 0));
        }
    }

    static int min(int k, int O, int N) {
        if (O >= reqA && N >= reqB) return 0;
        if (k > n) return 1000000;
        if (O >= reqA) O = reqA;
        if (N >= reqB) N = reqB;
        if (check[k][O][N] == ch) return dp[k][O][N];
        check[k][O][N] = ch;
        dp[k][O][N] = Math.min(min(k + 1, O, N), min(k + 1, O + arr[k].A, N + arr[k].B) + arr[k].C);
        return dp[k][O][N];

    }


    static class cylinder {
        int A;
        int B;
        int C;

        public cylinder(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }
    }
}
