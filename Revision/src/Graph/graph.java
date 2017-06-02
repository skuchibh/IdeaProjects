package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Surya Vamsi on 17-Jun-16.
 */
public class graph {
    private int V;
    private LinkedList<Integer>adj[];

    public graph(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }
    public void addEdge(int u,int v){
        adj[u].add(v);
    }
    public void BFS(int v){
        boolean[] vis=new boolean[V];
        vis[v]=true;
        Queue<Integer>q=new LinkedList<>();
        q.add(v);
        while(!q.isEmpty()){
            v=q.poll();
            System.out.println(v+" ");
            for(int x:adj[v]){
                if(!vis[x]){
                    vis[x]=true;
                    q.add(x);
                }
            }
        }
    }
    public void DFS(int v){
        boolean vis[]=new boolean[V];
        Stack<Integer>stk=new Stack<>();
        stk.push(v);
        vis[v]=true;
        while(!stk.isEmpty()){
            v=stk.pop();
            System.out.println(v+" ");
            for(int x:adj[v]){
                if(!vis[x]){
                    stk.push(x);
                    vis[x]=true;
                }
            }
        }
    }
}
