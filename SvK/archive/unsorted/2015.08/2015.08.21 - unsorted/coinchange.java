package created;

import sun.nio.ch.IOUtil;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

public class coinchange {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int amount = in.nextInt();
        int n = in.nextInt();
        long[] arr = IOUtils.readLongArray(in, n);
        out.println(count2(arr, n, amount));

    }

    static long count2(long []arr,int n,int amount){
        long [][]dp=new long[amount+1][n];
        for(int i=0;i<n;i++)dp[0][i]=1;
        for(int i=1;i<amount+1;i++)
            for(int j=0;j<n;j++){
                long x=(i-arr[j]>=0)?dp[i-(int)arr[j]][j]:0;
                long y=(j>0)?dp[i][j-1]:0;dp[i][j]=x+y;
            }
        return dp[amount][n-1];
    }
}
