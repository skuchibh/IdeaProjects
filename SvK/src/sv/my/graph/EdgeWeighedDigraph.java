package sv.my.graph;

import utils.InputReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Surya Vamsi on 31-Jul-15.
 */
public class EdgeWeighedDigraph {
    private static final String NEWLINE=System.getProperty("line.separator");
    private  int V;
    private  int E;
    private LinkedBag<DirectedEdge>[]adj;

    public EdgeWeighedDigraph(int V) {
        if(V<0)throw new IllegalArgumentException("number of vertices should be >0");
        this.V = V;
        this.E=0;
        adj=(LinkedBag<DirectedEdge>[])new LinkedBag[V];
        for(int v=0;v<adj.length;v++)adj[v]=new LinkedBag<>();
    }
    public EdgeWeighedDigraph(int V,int E, InputReader in){
        this(V);
        if(E<0)throw new IllegalArgumentException("Edges must be greater than 0!");
        for(int i=0;i<E;i++){
            int v=in.nextInt();int w=in.nextInt();long weight=in.readLong();
            addEdge(new DirectedEdge(v,w,weight));
        }
    }
    public void addEdge(DirectedEdge e){
        int v=e.from();int w=e.to();
        validate(v);validate(w);
        adj[v].add(e);E++;
        //System.out.println(adj[v]);
    }
    private void validate(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }
    public int nvertices(){return V;}public int nedges(){return E;}
    public int outdegree(int v){return adj[v].size();}
    public Iterable<DirectedEdge> adj(int v){
        validate(v);
        return adj[v];
    }
    public Iterable<DirectedEdge> edges(){
        LinkedBag<DirectedEdge>list=new LinkedBag<>();
        for(int i=0;i<V;i++)for(DirectedEdge e:adj(i))list.add(e);
        return list;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
