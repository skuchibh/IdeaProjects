package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.math.BigInteger;
import java.util.Arrays;

public class cube {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        for (int testcase = 1; testcase <= t; testcase++) {
            out.println("Case #" + testcase + ":");
            int nd = in.nextInt();
            int nq = in.nextInt();
            int[] dimens = new int[nd];
            for (int i = 0; i < nd; i++) dimens[i] = in.nextInt();
            while (nq-- > 0) {
                int x = in.nextInt();
                int y = in.nextInt();
                int dif=y+1-x;
                double ans=1;double root=1.0/(double)dif;
                //System.out.println("dif+\" \"+root = " + dif + " " + root);
                for(int i=x;i<=y;i++){
                    System.out.println("dimens[i]+\" \"+root = " + dimens[i]+" "+root);
                    ans*=Math.pow(dimens[i],root);
                    System.out.println(ans);
                }
                out.printFormat("%.10f",ans);
                out.println();
            }
        }
    }
}
