package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class Farida {
    static int n;static long[]a,dp;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t=in.nextInt();
        for(int i=1;i<=t;i++){
            n=in.nextInt();
            a= IOUtils.readLongArray(in, n);
            dp=new long[n+1];
            Arrays.fill(dp,-1);
            out.print("Case "+i+": ");
            out.println(f(0));
        }
    }
    static long f(int index){
        if(index>=n)return 0;
        if(index==n-1)return a[index];
        long max=Long.MIN_VALUE;
        if(dp[index]!=-1)return dp[index];
        max=Math.max(a[index]+f(index+2),f(index+1));
        dp[index]=max;
        return dp[index];
    }
}
