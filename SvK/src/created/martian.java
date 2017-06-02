package created;

import utils.InputReader;
import utils.OutputWriter;

public class martian {
    static int R, C;
    static int[][][] sum;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            R = in.nextInt();
            C = in.nextInt();
            if(R+C==0)break;
            sum = new int[2][R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    int s = in.nextInt();
                    sum[1][i][j] = s;
                    if (j > 0) sum[1][i][j] += sum[1][i][j - 1];
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    int s = in.nextInt();
                    sum[0][i][j] = s;
                    if (i > 0) {
                        sum[0][i][j] += sum[0][i - 1][j];
                    }
                }
            }
            out.println(solve());

        }
    }

    static int solve() {
        int[][] dp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int sum1 = sum[0][i][j];
                int sum2 = sum[1][i][j];
                if(j>0)sum1+=dp[i][j-1];
                if(i>0)sum2+=dp[i-1][j];
                dp[i][j]=Math.max(sum1,sum2);
            }
        }
        return dp[R-1][C-1];
    }
}
