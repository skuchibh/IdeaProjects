package sv.collections.UnionFind;

import java.util.Arrays;

/**
 * Created by Surya Vamsi on 26-Jul-15.
 */
public class QuickFind {
    private int[]id;
    private int []size;

    public QuickFind(int N){
        id=new int[N];size=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;size[i]=1;
        }
    }
    private int root(int i){
        while(i!=id[i]){
            id[i]=id[id[i]];
            i=id[i];
        }return i;
    }
    public boolean find(int p,int q){
        return root(p)==root(q);
    }
    public void union(int p,int q){
        int rootp=root(p);int rootq=root(q);if(rootp==rootq)return;
        if(size[rootp]<size[rootq]){
            id[rootp]=rootq;size[rootq]+=size[rootp];
        }
        else{
            id[rootq]=rootp;size[rootp]+=size[rootq];
        }
//        System.out.println(Arrays.toString(id));
    }
}
