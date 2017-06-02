package created;

/**
 * Created by Surya Vamsi on 29-Sep-15.
 */
public class swg {
    String[] A;
    String[] tree;

    public swg(String[] a) {
        A = a;
//        String[]xxx=new String[1000010];
        tree = new String[100 * a.length + 10];
        build(1, 0, A.length - 1);
    }

    void build(int node, int s, int e) {
        if (s == e) {
            tree[node] = A[s];
            return;
        }
        if (s > e) return;
        int mid = (s + e) >> 1;
        build(2 * node, s, mid);
        build(2 * node + 1, mid + 1, e);/*
        StringBuffer sb=new StringBuffer();
        sb.append(tree[2*node]).append(tree[2*node+1]);*/
//        String x=tree[node*2]+""+tree[node*2+1];
        //System.out.println("x = " + x);
//        System.out.println("sb.toString() = " + sb.toString());
        tree[node] = ""+tree[node*2]+tree[node*2+1];
    }
    public String query(int from, int to) {
        return query(1, 0, A.length - 1, from, to);
    }

    void update(int node, int s, int e, int x, int y, int val) {
        if (s == e && s >= x && s <= y) {
            tree[node] =tree[node]=="0"?"1":"1";
            //System.out.println(s+" "+e);
            return;
        }
        if (s > e || e < x || s > y) return;
        int mid = (s + e) >> 1;
        int c = 2 * node;
        update(c, s, mid, x, y, val);
        update(c + 1, mid + 1, e, x, y, val);
        tree[node] = tree[c] + tree[c + 1];
    }

    String query(int node, int s, int e, int x, int y) {
        if (x <= s && y >= e) {
            return tree[node];
        }
        if (s == e && s == x) return tree[node];
        if (x > e || y < s || s > e) {
            return "";
        }
        int mid = (s + e) >> 1;
        String a1="";
        //System.out.println(s+" "+mid+" "+x+" "+y);
        a1 =""+ query(node * 2, s, mid, x, y);

        String a2 =""+ query(node * 2 + 1, mid + 1, e, x, y);
        return a1 + a2;
    }

    public String[] get() {
        return tree;
    }

}
