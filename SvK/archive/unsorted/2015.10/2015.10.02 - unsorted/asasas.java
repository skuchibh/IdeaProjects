package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;
import java.util.TreeSet;

public class asasas {
    static TreeSet<String> set = new TreeSet<>();

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        int k = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] dp = new int[n];
        for(int i=0;i<k;i++) {
            dp[0] += a[i];
        }int i=0;
        int min=0;
        int value= dp[0];
        for(i=1;i<n;i++){int sum=0;int count=0;
            if(i+k-1<n)
            dp[i]=dp[i-1]-a[i-1]+a[i+k-1];
            else dp[i]=999999999;
            if(value>dp[i]){
                value=dp[i];
                min=i;
            }
        }
//        out.println(dp);
        out.println(min+1);

    }
}
