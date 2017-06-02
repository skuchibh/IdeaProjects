package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.TreeSet;

public class spath {
    static TreeSet<TreeSet<Integer>>Paths;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int r=in.nextInt();
        int c=in.nextInt();
        int[][]dp=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dp[i][j]=in.nextInt();
            }
        }


    }

}
