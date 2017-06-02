package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

public class spox_mixtures {static int [][]dp,color;static int n;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        try {
            while (true) {
                n = in.nextInt();
                color=new int[n][n];
                for(int i=0;i<n;i++)color[i][i]=in.nextInt();
                matrixchain();
                //IOUtils.printTable(out,dp);
                out.println(dp[0][n-1]);
            }
        } catch (Exception e) {

        }
    }
    static void matrixchain(){
        dp=new int[n][n];
        for(int l=1;l<n;l++){
            for(int i=0;i<n-l;i++){
                int j=i+l;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    if(dp[i][j]>dp[i][k]+dp[k+1][j]+color[i][k]*color[k+1][j]){
                        dp[i][j]=dp[i][k]+dp[k+1][j]+color[i][k]*color[k+1][j];
                        color[i][j]=color[i][k]+color[k+1][j];color[i][j]%=100;
                    }
                }
            }
        }
    }
}
