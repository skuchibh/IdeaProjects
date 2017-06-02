package sv.my.graph.GraphAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Surya Vamsi on 25-Aug-15.
 */
public class Kosaraju {
    static boolean dfs1=false,dfs2=false;
    public static List<List<Integer>>scc(List<Integer>[]graph){
        int n=graph.length;
        boolean[]used=new boolean[n];
        List<Integer>order=new ArrayList<>();
        for(int i=0;i<n;i++)
            if(!used[i])dfs(graph,used,order,i);

        List<Integer>[]reverseGraph=new List[n];
        for(int i=0;i<n;i++)reverseGraph[i]=new ArrayList<>();
        for(int i=0;i<n;i++)
            for(int j:graph[i])
                reverseGraph[j].add(i);
        List<List<Integer>>components=new ArrayList<>();
        Arrays.fill(used, false);
        Collections.reverse(order);
        for(int u:order)
            if(!used[u]){
                List<Integer>component=new ArrayList<>();
                dfs(reverseGraph,used,component,u);
                components.add(component);
            }
        return components;

    }
    public static boolean isScc(List<Integer>[]graph){
        int n=graph.length;
        boolean[]used=new boolean[n];
        for(int i=0;i<n;i++)
            for(int x:graph[i])
                if(!used[x])dfs(graph,used,x);
        for(boolean x:used)if(x==false)return false;
        List<Integer>[]reverseGraph=new List[n];
        for(int i=0;i<n;i++)reverseGraph[i]=new ArrayList<>();
        for(int i=0;i<n;i++)
            for(int x:graph[i])
                reverseGraph[x].add(i);
        for(int i=0;i<n;i++)
            for(int x:reverseGraph[i])
                if(!used[x])dfs(graph,used,x);
        for(boolean x:used)if(x==false)return false;
        return true;

    }
    static void dfs(List<Integer>[]graph,boolean[]used,int u){
        used[u]=true;
        for(int v:graph[u])
            if(!used[v])dfs(graph,used,v);
    }

    static void dfs(List<Integer>[]graph,boolean[]used,List<Integer>res,int u){
        used[u]=true;
        for(int v:graph[u])
        if(!used[v])
            dfs(graph,used,res,v);
        res.add(u);
    }
}
