package created;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Surya Vamsi on 10-Oct-15.
 */
public class dummy {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine());
        int[]dp=new int[1000005];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<=1000000;i++){
            dp[i]+=dp[i-1];
            dp[i]+=(i-1)*dp[i-2];
            dp[i]%=1000000007;
        }
        while(t-->0){
            int n=Integer.valueOf(in.readLine());
            System.out.println(dp[n]);
        }
    }
}
