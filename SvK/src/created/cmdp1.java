package created;

import sv.misc.ArrayUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class cmdp1 {
    static int n;
    static long[] dp;
    static int[][] costs;
    static final int MOD=1000000007;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t=in.nextInt();
        dp=new long[1000004];
        dp[0]=1;dp[1]=1;dp[2]=2;
        dp[3]=4;
        for(int i=4;i<=1000000;i++){
            dp[i]+=dp[i-1];
            dp[i]+=(i-1)*dp[i-2];
            dp[i]%=MOD;
        }

        while(t-->0){
            int n=in.nextInt();
            out.println(dp[n]);
        }
    }

}
