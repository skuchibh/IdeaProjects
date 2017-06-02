package created;

import utils.InputReader;
import utils.OutputWriter;

public class aibohp {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.readLine();
            //String rev = new StringBuffer(s).reverse().toString();
            short min=lcs(s, new StringBuffer(s).reverse().toString());
            out.println(s.length()-min);
        }
    }


    static short lcs(String s1, String s2) {
        short[][] dp = new short[(short)(s1.length() + 1)][(short)(s2.length() + 1)];
        char []a=s1.toCharArray();char[]b=s2.toCharArray();
        short n=(short)s1.length();int m=(short)s2.length();
        for(short i=1;i<=(short)n;i++){
            for(short j=1;j<=(short)m;j++){
                if(a[i-1]==b[j-1])dp[i][j]=(short)(dp[i-1][j-1]+(short)1);
                else
                    dp[i][j]=(short)(Math.max(dp[i-1][j],dp[i][j-1]));
            }
        }
        return dp[n][m];
    }
}
