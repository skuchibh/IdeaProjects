import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Surya Vamsi on 16-Jun-16.
 */
public class sum {
    static ArrayList<Integer>[]list;static int[]ans;
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String x[] = br.readLine().split(" ");
            n = Integer.parseInt(x[0]);
            int e = Integer.parseInt(x[1]);
            ans=new int[n];
            list = new ArrayList[n];
            for(int i=0;i<n;i++)list[i]=new ArrayList<>();
            for (int i = 0; i < e; i++) {
                x = br.readLine().split(" ");
                int u = Integer.parseInt(x[0])-1;
                int v = Integer.parseInt(x[1])-1;
                list[u].add(v);
                list[v].add(u);
            }
            int source=0;
            source=(Integer.parseInt(br.readLine().trim()))-1;


            bfs(source,1);
            for(int i=0;i<n;i++){
                if(i!=source){
                    if(ans[i]==0){
                        System.out.print("-1 ");
                    }
                    else System.out.print(ans[i]*6 +" ");
                }
            }
            System.out.println();
        }

    }
    static void bfs(int s,int dist){
        Queue<Integer>q=new LinkedList<>();
        q.add(s);
        ans[s]=0;
        boolean[]vis=new boolean[n];
        vis[s]=true;
        while(!q.isEmpty()){
            int x=q.poll();
            for(int current:list[x]){
                if(!vis[current] && current!=s){
                    vis[current]=true;
                    ans[current]=ans[x]+1;
                    q.add(current);
                }
            }
        }

    }

}
