package created;

import sv.my.DP.classical;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class Task {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int money = in.nextInt();
        int n = in.nextInt();
        int[] cost = IOUtils.readIntArray(in, n);
        int[] fun = IOUtils.readIntArray(in, n);
        int [][]dp=new int[n+1][money+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=money;j++){
                if(i==0||j==0)dp[i][j]=0;
                else if(cost[i-1]<j)dp[i][j]=Math.max(dp[i-1][j],fun[i-1]+dp[i-1][j-cost[i-1]]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        IOUtils.printTable(out, dp);
        int x;
        int y;
        int pos = 0;
        for (int i = 0; i < money; i++)
            if (dp[n][i] == dp[n][money]) {
                pos = i;
                break;
            }
        x = n;
        int totcos = 0;
        y = pos;
        for(x=n,y=pos;x>0 && y>0;){
            if(dp[x][y]==dp[x-1][y])x--;
            else if(dp[x][y]==dp[x][y-1])y--;
            else{
                totcos+=cost[x-1];y-=fun[x-1];x--;
            }
        }
        out.println(totcos + " " + dp[n][money]);
    }
}
