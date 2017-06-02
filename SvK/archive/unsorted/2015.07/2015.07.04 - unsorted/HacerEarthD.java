package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

public class HacerEarthD {static int [][]grid;static boolean[][]vis;
    static int []dx={-1,1,0,0};static int []dy={0,0,-1,1};static int n,k=0;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n=in.nextInt();
        grid=new int[n][n];
        vis=new boolean[n][n];
        for(int i=0;i<n;i++)grid[i]=IOUtils.readIntArray(in,n);
        if(grid[n-1][n-1]==1){
            out.println(0);return;
        }
        if(grid[n-2][n-1]==1 && grid[n-1][n-2]==1){out.println(0);return;}
        vis[0][0]=true;
        dfs(0,0);
        out.print(k);
    }
    static void dfs(int i,int j){
        vis[i][j]=true;
        //System.out.println("i+\" \"+j = " + i+" "+j);
        for(int z=0;z<4;z++){
            int xx=i+dx[z];int yy=j+dy[z];
            if(xx>=0 && yy>=0 && xx<n && yy<n){
                if(xx==n-1 && yy==n-1){
                    k++;return;
                }
                else if(grid[xx][yy]!=1 && !vis[xx][yy])
                {dfs(xx,yy);
                vis[xx][yy]=false;}
            }
        }
    }
}
