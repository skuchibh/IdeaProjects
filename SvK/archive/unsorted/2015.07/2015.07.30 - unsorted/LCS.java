package created;

import utils.InputReader;
import utils.OutputWriter;

public class LCS {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        out.println(LCS("ABCDE", "DACACBE"));
    }

    static int  LCS(String x, String t) {
        StringBuffer sb=new StringBuffer();
        int[][] dp = new int[1024][1024];
        int m=x.length();int n=t.length();
        for(int i=0;i<=m;i++)dp[i][n]=0;
        for(int i=0;i<=n;i++)dp[m][i]=0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                dp[i][j]=dp[i+1][j+1];
                if(x.charAt(i)==t.charAt(j)){dp[i][j]++;}
                else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        for(int i=0;i<x.length()+1;i++)
        {
            for(int j=0;j<t.length()+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        int i=0,j=0;
        while(i<m && j<n){
            if(dp[i+1][j]==dp[i][j])i++;else if(dp[i][j+1]==dp[i][j])j++;
            else{
                sb.append(x.charAt(i));i++;j++;
            }
        }
        System.out.println(sb.toString());
        return dp[0][0];
    }

}
