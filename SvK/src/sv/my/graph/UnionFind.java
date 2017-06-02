package sv.my.graph;

import java.util.TreeSet;

/**
 * Created by Surya Vamsi on 31-Jul-15.
 */
public class UnionFind {

    int[] size;
    int[] id;
    int count;
    TreeSet<Integer> set = new TreeSet<>();

    public int getComponents() {
        return count;
    }

    public UnionFind(int n) {
        size = new int[n];
        count = n - 1;
        id = new int[n];
        for (int i = 0; i < n-1; i++) {
            size[i] = 1;
            id[i] = i;
        }
    }

    public int size(int p) {
        return size[p];
    }

    public void union(int p, int q) {

        int rootp = find(p);
        int rootq = find(q);
        /*if (p == 1 && q == 5) {
            System.out.println("leaders " + rootp + " " + rootq);
            System.out.println("size[rootp] = " + size[rootp]);
            System.out.println("size[rootq] = " + size[rootq]);
        }*/
        if (rootp == rootq) return;
        if (size[rootp] < size[rootq]) {
            if (id[rootp]!=rootq) if (set.contains(id[rootp])) set.remove(id[rootp]);
            set.add(id[q]);
            //System.out.println("set1 = " + set);
            id[rootp] = rootq;size[rootq] += size[rootp];
        } else if (size[rootp] > size[rootq]) {
            //System.out.println("set2before = " + set);
            //System.out.println("rootp = " + rootp);
            set.add(id[rootp]);
            if (id[rootq]!=rootp) if (set.contains(id[rootq])) set.remove(id[rootq]);
            //System.out.println("set2 = " + set);
            size[rootp] += size[rootq];
            id[rootq] = rootp;
        } else {
            id[rootq] = rootp;
            //System.out.println(p + " " + q);
            size[rootp]++;
            set.add(id[p]);
            //System.out.println("set3 = " + set);
        }
        count--;
    }

    public TreeSet<Integer> set() {
        return set;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

}

