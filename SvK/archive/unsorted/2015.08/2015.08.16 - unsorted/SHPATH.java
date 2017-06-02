package created;

import sv.my.graph.DirectedEdge;
import sv.my.graph.EdgeWeighedDigraph;
import sv.my.graph.GraphAlgorithms.DjikstrasAlgorithm;
import utils.InputReader;
import utils.OutputWriter;

import java.util.HashMap;

public class SHPATH {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            HashMap<String, Integer> map = new HashMap<>();
            int a = 0;
            EdgeWeighedDigraph graph = new EdgeWeighedDigraph(n);
            for (int i = 0; i < n; i++) {
                String x = in.readString();
                map.put(x, a++);
                int conn = in.nextInt();
                for (int j = 0; j < conn; j++) {
                    int to = in.nextInt();
                    graph.addEdge(new DirectedEdge(i, to - 1, in.nextInt()));
                }
            }
            int q = in.nextInt();
            while (q-- > 0) {
                int from = map.get(in.readString());
                int to = map.get(in.readString());
                DjikstrasAlgorithm sp=new DjikstrasAlgorithm(graph,from);
                out.println(sp.distTo(to));
            }
        }
    }
}
