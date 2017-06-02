package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class REN2013GCodechef {
    static int[][] ammo;
    static int[] x, y;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        x = new int[n + 2];
        y = new int[n + 2];
        ammo = new int[n + 2][n + 2];
        for(int i=1;i<=n+1;i++){
            x[i]=in.nextInt();y[i]=in.nextInt();
            ammo[0][i]=calc(0,0,x[i],y[i]);
        }
        for(int i=1;i<=n+1;i++){
            for(int j=0;j<=n+1;j++){
                if(i>j)ammo[i][j]=ammo[j][i];
                else if(i==j)ammo[i][j]=0;
                else{
                    ammo[i][j]=calc(x[i],y[i],x[j],y[j]);
                }
            }
        }
        //IOUtils.printTable(out,ammo);
        out.println(sp(n));



    }
    static int sp(int n){
        boolean[]vis=new boolean[n+2];
        int []dist=new int[n+2];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        while(!vis[n+1]){
            int min=n+1;
            for(int i=0;i<n+2;i++){
                if(!vis[i])if(dist[i]<dist[min])min=i;
            }
            vis[min]=true;
            for(int i=0;i<n+2;i++){
                if(!vis[i]){
                    int xx=dist[min]+ammo[i][min];
                    if(xx<dist[i])dist[i]=xx;
                }
            }

        }
        //System.out.println(Arrays.toString(dist));
        return dist[n+1];
    }

    static int calc(int x1, int y1, int x2, int y2) {
        int xx = (x2 - x1);
        xx = xx * xx;
        int yy = (y2 - y1);
        yy = yy * yy;
        return xx + yy;
    }
}
