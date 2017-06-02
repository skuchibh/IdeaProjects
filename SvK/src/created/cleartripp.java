package created;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Surya Vamsi on 26-Jun-15.
 */
public class cleartripp {
    static int[][] grid = new int[5][5];static int kk=0;
    static int dx[]={0,0,1,-1};static int dy[]={1,-1,0,0};
    static boolean [][]visited;static StringBuffer sb;static StringBuffer sb2;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k = 0;
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) grid[i][j] = ++k;
        for(int i=0;i<5;i++){kk=0;sb=new StringBuffer();sb2=new StringBuffer();visited=new boolean[5][5];
            String []temp=br.readLine().split(" ");
            int start=Integer.parseInt(temp[0]);int end=Integer.parseInt(temp[1]);
            int row=start/5;row=start%5==0?row-1:row;int col=start%5;col=col==0?col+4:col-1;
            sb.append(grid[row][col]+" ");
            dfs(row, col, end);
            System.out.println(sb.toString());
        }
    }

    static String dfs(int i,int j,int dest){
        visited[i][j]=true;if(kk!=0)return "";
        for(int z=0;z<4;z++){
            int xx=i+dx[z];int yy=j+dy[z];
            if(xx>=0 && xx<5 && yy>=0 && yy<5){
                if(!visited[xx][yy]){
                    if(grid[xx][yy]==dest){kk++;
                        sb.append(sb2.toString());sb.append(grid[xx][yy]+" ");return sb.toString();
                    }else if(grid[xx][yy]!=dest){
                        sb2.append(grid[xx][yy]+" ");dfs(xx,yy,dest);if(kk!=0)return "";
                    }
                }
            }
        }return "";
    }
}
