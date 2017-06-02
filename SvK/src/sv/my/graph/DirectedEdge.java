package sv.my.graph;

/**
 * Created by Surya Vamsi on 31-Jul-15.
 */
public class DirectedEdge {
    private final int v;
    private final int w;
    private final long weight;

    public DirectedEdge(int v, int w, long weight) {
        if(v<0)throw new IndexOutOfBoundsException("Vertex must be nonnegative ");
        if(w<0)throw new IndexOutOfBoundsException("Vertex must be nonnegative ");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public int to(){
        return w;
    }
    public int from(){
        return v;
    }
    public long getWeight(){
        return weight;
    }
    public String toString(){
        return v+"->"+w+" "+weight;
    }
}
