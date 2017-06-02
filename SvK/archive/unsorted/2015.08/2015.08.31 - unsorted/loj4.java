package created;

import sv.misc.ArrayUtils;
import utils.InputReader;
import utils.OutputWriter;

public class loj4 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t=in.nextInt();
        for(int ii=1;ii<=t;++ii){
            out.print("Case "+ii+": ");
            int n =in.nextInt();int e=in.nextInt();
            int[][]g=new int[n][n];
            ArrayUtils.fill(g,Integer.MAX_VALUE/2-10);
            for(int j=0;j<n;j++)g[j][j]=0;
            for(int r=0;r<e;r++){
                int x=in.nextInt();
                int y=in.nextInt();
                g[x][y]=1;
                g[y][x]=1;
            }
            for(int k=0;k<n;k++)
                for(int i=0;i<n;i++)
                    for(int j=0;j<n;j++)
                        g[i][j]=Math.min(g[i][j],g[i][k]+g[k][j]);
            int start=in.nextInt();int end=in.nextInt();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(i==start || i==end)continue;
                int dist=g[start][i]+g[i][end];
                max=Math.max(max,dist);
            }
            max=Math.max(max,g[start][end]);
            out.println(max);
        }
    }
}
