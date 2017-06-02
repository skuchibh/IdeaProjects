package sv.my.graph;

import java.util.Arrays;

public class UF {

    private int[] parent;  // parent[i] = parent of i
    private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
    private int count;     // number of components

    public UF(int N) {
        if (N < 0) throw new IllegalArgumentException();
        count = N;
        parent = new int[N];
        rank = new byte[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int size(int p){
        int ans=0;
        int prnt=find(p);
        System.out.println("prnt = " + prnt);
        System.out.println("Arrays.toString(parent) = " + Arrays.toString(parent));
        for(int i=1;i<parent.length;i++)if(parent[find(i)]==prnt)ans++;
        return ans;
    }

    public int find(int p) {
        if (p < 0 || p >= parent.length) throw new IndexOutOfBoundsException();
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(p==2 && q==8){
            System.out.println("rootP = " + rootP);
            System.out.println("rootQ = " + rootQ);
        }
        /*if(p==2 && q==8){
            System.out.println("rootP = " + rank[rootP]);
            System.out.println("rootQ = " + rank[rootQ]);
        }*/
        if (rootP == rootQ) return;

        // make root of smaller rank point to root of larger rank
        if      (rank[rootP] < rank[rootQ]) {rank[rootQ]++;parent[rootP] = rootQ;}
        else if (rank[rootP] > rank[rootQ]){ rank[rootP]++;parent[rootQ] = rootP;}
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
        System.out.println("Arrays.toString(rank) = " + Arrays.toString(rank));
        System.out.println("Arrays.toString(parent) = " + Arrays.toString(parent)+" "+p+" "+q);

    }


}
