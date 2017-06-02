package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Task {static long temp=0;static boolean []visited;static List<Integer>[]edges;static long []arr;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t=in.nextInt();
        while(t-->0){temp=0;
            int nodes=in.nextInt();int nedges=in.nextInt();
            edges=new List[nodes+99];arr=new long[nodes+99];visited=new boolean[nodes+99];
            for(int i=0;i<edges.length;i++)edges[i]=new ArrayList<>();
            for(int i=0;i<nedges;i++){
                int x=in.nextInt();int y=in.nextInt();
                edges[x].add(y);edges[y].add(x);
            }long ans=0;
            for(int i=0;i<nodes;i++)arr[i+1]=in.readLong();
            for(int i=1;i<=nodes;i++){
                if(!visited[i]){
                    dfs(i);
                    ans=Math.max(ans,temp);
                    temp=0;
                }
            }out.println(ans);
        }
    }
    static void dfs(int i){
        visited[i]=true;
        Stack<Integer>stk=new Stack<>();
        stk.push(i);
        while(!stk.isEmpty()){
            int x=stk.pop();temp+=arr[x];
            for(int k=0;k<edges[x].size();k++){
                int xx=edges[x].get(k);
                if(!visited[xx]){stk.push(xx);visited[xx]=true;}
            }
        }
    }
}
