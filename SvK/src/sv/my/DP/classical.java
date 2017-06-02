package sv.my.DP;

import java.util.Arrays;

/**
 * Created by Surya Vamsi on 18-Jun-15.
 */
public class classical {
    public static String LCS(String a,String b) {
        int len1=a.length();int len2=b.length();
        int [][]dp=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++)Arrays.fill(dp[i],0);
        for(int i=0;i<len1;i++)
            for(int j=0;j<len2;j++)
                dp[i+1][j+1]=(a.charAt(i)==b.charAt(j))?dp[i][j]+1:Math.max(dp[i+1][j],dp[i][j+1]);
        System.out.println(dp[len1][len2]);
        StringBuilder sb=new StringBuilder();
        for(int x=len1,y=len2;x>0 && y>0;){
            if(dp[x][y]==dp[x][y-1])y--;else if(dp[x][y]==dp[x-1][y])x--;
            else {sb.append(a.charAt(x-1));x--;y--;}
        }
        return sb.reverse().toString();
    }
}
