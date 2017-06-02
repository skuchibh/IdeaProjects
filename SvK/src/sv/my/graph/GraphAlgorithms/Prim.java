package sv.my.graph.GraphAlgorithms;

import sv.my.Queues.MinPriorityQueue;
import sv.my.Queues.Queue;
import sv.my.graph.Edge;
import sv.my.graph.EdgeWeighedGraph;


/**
 * Created by Surya Vamsi on 21-Aug-15.
 */
public class Prim {
    private Edge[] edgeTo;
    private long[] distTo;
    private boolean[] marked;
    private MinPriorityQueue<Long> pq;

    public void Prim(EdgeWeighedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new long[G.V()];
        marked = new boolean[G.V()];
        pq = new MinPriorityQueue<>(G.V());
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) Prim(G, i);
        }
    }

    public void Prim(EdgeWeighedGraph G, int v) {
        //Prim(G);
        distTo[v] = 0;
        pq.insert(v, distTo[v]);
        while (!pq.isEmpty()) {
            int w = pq.delMin();
            scan(G, w);
        }
    }

    public void Prim(EdgeWeighedGraph G, int v, boolean flag) {
        if (flag) {
            edgeTo = new Edge[G.V()];
            distTo = new long[G.V()];
            marked = new boolean[G.V()];
            pq = new MinPriorityQueue<>(G.V());
        }
        distTo[v] = 0;
        pq.insert(v, distTo[v]);
        while (!pq.isEmpty()) {
            int w = pq.delMin();
            scan(G, w);
        }
    }

    private void scan(EdgeWeighedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;
            if (e.getWeight() < distTo[w]) {
                distTo[w] = (long) e.getWeight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.getWeight();
        return weight;
    }


}
