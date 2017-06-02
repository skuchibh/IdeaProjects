package sv.my.graph.GraphAlgorithms;

import sv.my.Queues.MinPriorityQueue;
import sv.my.graph.DirectedEdge;
import sv.my.graph.EdgeWeighedDigraph;

import java.util.Stack;

/**
 * Created by Surya Vamsi on 01-Aug-15.
 */
public class DjikstrasAlgorithm {
    private long[] distTo;
    private DirectedEdge[] edgeTo;
    private MinPriorityQueue<Long>pq;

    public DjikstrasAlgorithm(EdgeWeighedDigraph graph,int source) {
        distTo=new long[graph.nvertices()];
        edgeTo=new DirectedEdge[graph.nvertices()];
        for(int i=0;i<graph.nvertices();i++)distTo[i]=Long.MAX_VALUE;
        distTo[source]=0;
        pq=new MinPriorityQueue<>(graph.nvertices());
        pq.insert(source,distTo[source]);
        while (!pq.isEmpty()){
            int v=pq.delMin();
            for(DirectedEdge e:graph.adj(v))relax(e);
        }
    }
    private void relax(DirectedEdge e){
        int v=e.from();int w=e.to();
        if(distTo[w]>Math.max(distTo[v],e.getWeight())){
            distTo[w]=Math.max(distTo[v],e.getWeight());
            edgeTo[w]=e;
            if(pq.contains(w))pq.decreaseKey(w,distTo[w]);
            else pq.insert(w,distTo[w]);
        }
        /*if(distTo[w]>distTo[v]+e.getWeight()){
            distTo[w]=distTo[v]+e.getWeight();
            edgeTo[w]=e;
            if(pq.contains(w))pq.decreaseKey(w,distTo[w]);
            else pq.insert(w,distTo[w]);
        }*/
    }
    public long distTo(int v){return distTo[v];}
    public boolean hasPath(int v){return distTo[v]<Long.MAX_VALUE;}
    public Iterable<DirectedEdge>pathTo(int v){
        if(!hasPath(v))return null;
        Stack<DirectedEdge>stk=new Stack<>();
        for(DirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()]){
            stk.push(e);
        }return stk;
    }
    private boolean check(EdgeWeighedDigraph graph,int s){
        for(DirectedEdge e:graph.edges()){
            if(e.getWeight()<0){
                System.err.println("Negative weights!");return false;
            }
        }
        if(distTo[s]!=0){
            System.err.println("distTo[s] and edgeTo are inconsistent");return false;
        }
        for(int i=0;i<graph.nvertices();i++){
            if(i==s)continue;
            if(edgeTo[i]==null && distTo[i]==Long.MAX_VALUE){
                System.err.println("distTo[s] and edgeTo are inconsistent");return false;}
        }
        for(int i=0;i<graph.nvertices();i++){
            if(i==s)continue;
            for(DirectedEdge e:graph.adj(i)){
                int w=e.to();int v=i;
                if(distTo[w]>distTo[v]+e.getWeight()){
                    System.err.println("edge "+e+" not relaxed");return false;
                }
            }
        }
        for(int w=0;w<graph.nvertices();w++){
            if(edgeTo[w]==null)continue;
            DirectedEdge e=edgeTo[w];
            int v=e.from();
            if(w!=e.to())return false;
            if(distTo[w]!=distTo[v]+e.getWeight())return false;
        }
        return true;
    }
}
