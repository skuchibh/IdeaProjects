package sv.my.graph;

/**
 * Created by Surya Vamsi on 31-Jul-15.
 */
public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;
    @Override
    public int compareTo(Edge that) {
        if(this.getWeight()<that.getWeight())return -1;
        else if(that.getWeight()<this.getWeight())return 1;
        else return 0;
    }

    public Edge( int v, int w,double weight) {
        if(v<0 || w<0)throw new IndexOutOfBoundsException("Vertec must be non negative!");
        this.weight = weight;
        this.w = w;
        this.v = v;
    }
    public double getWeight(){
        return weight;
    }
    public int either(){
        return v;
    }
    public int other(int vertex){
        if(vertex==v)return w;
        else if(vertex==w)return v;
        else throw new IllegalArgumentException("Illegal Endpoint..Maybe Self Edge");
    }
    public String toString(){
        return String.format("%d-%d %.5f",v,w,weight);
    }
}
