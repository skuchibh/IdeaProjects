package created;

import sv.my.graph.DirectedEdge;
import sv.my.graph.Edge;
import sv.my.graph.EdgeWeighedDigraph;
import sv.my.graph.GraphAlgorithms.DjikstrasAlgorithm;
import utils.InputReader;
import utils.OutputWriter;

public class EZDIJKST {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();int e=in.nextInt();
            EdgeWeighedDigraph graph=new EdgeWeighedDigraph(n);
            for(int i=0;i<e;i++){
                graph.addEdge(new DirectedEdge(in.nextInt()-1,in.nextInt()-1,in.readLong()));
            }
            int source=in.nextInt()-1;
            int dest=in.nextInt()-1;
            DjikstrasAlgorithm sp=new DjikstrasAlgorithm(graph,source);
            if(sp.hasPath(dest)){
                out.println(sp.distTo(dest));
            }
            else {
                out.println("NO");
            }

        }
    }
}
