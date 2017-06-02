package sv.my.graph;

/**
 * Created by Surya Vamsi on 21-Aug-15.
 */
public class EdgeWeighedGraph {
    private int V;
    private int E;
    private LinkedBag<Edge>[]adj;

    public EdgeWeighedGraph(int v) {
        this.V = v;
        this.E=0;
        adj=(LinkedBag<Edge>[])new LinkedBag[V];
        for(int i=0;i<V;i++)adj[i]=new LinkedBag<>();
    }
    public Iterable<Edge> edges() {
        LinkedBag<Edge> list = new LinkedBag<>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // only add one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public Iterable<Edge> adj(int v){return adj[v];}
    public int degree(int v){return adj[v].size();}
    public int V(){return V;}
    public int E(){return E;}
    public void addEdge(Edge e){
        int v=e.either();
        int w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
}
