package sv.SegmentTreeLazy;

/**
 * Created by Surya Vamsi on 28-Sep-15.
 */
public class SegmentTree {
    // 0-Indexing

    int[] A;
    int[] tree;
    int[] lazy;

    public void lazyUpdate(int from, int to, int val) {
        updateLazyRange(1, 0, A.length - 1, from, to, val);
    }

    void updateLazyRange(int node, int start, int end, int l, int r, int val) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
        if (start > end || start > r || end < l) return;
        if (start >= l && end <= r) {
            tree[node] += (end - start + 1) * val;
            if (start != end) {
                lazy[node * 2] += val;
                lazy[node * 2 + 1] += val;
            }
            return;
        }
        int mid = (start + end) >> 1;
        updateLazyRange(node * 2, start, mid, l, r, val);
        updateLazyRange(node * 2 + 1, mid + 1, end, l, r, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public int lazyQuery(int from, int to) {
        return queryLazyRange(1, 0, A.length - 1, from, to);
    }

    int queryLazyRange(int node, int start, int end, int l, int r) {
        if (start > end || start > r || end < l) return 0;
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                tree[node * 2] += lazy[node];
                tree[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
            //System.out.println("OKOK");
        }

        if (start >= l && end <= r) return tree[node];
        int mid = (start + end) >> 1;
        int p1 = queryLazyRange(node * 2, start, mid, l, r);
        int p2 = queryLazyRange(node * 2 + 1, mid + 1, end, l, r);
        return p1 + p2;
    }

    public void updateRange(int from, int to, int val) {
        updateRange(1, 0, A.length - 1, from, to, val);
    }

    public void update(int index, int val) {
        update(1, 0, A.length - 1, index, val);
    }

    public int query(int from, int to) {
        return query(1, 0, A.length - 1, from, to);
    }

    void updateRange(int node, int start, int end, int l, int r, int val) {
        if (start > end || start > r || end < l) {
            return;
        }
        if (start == end) {
            tree[node] = A[start];
            return;
        }
        int mid = (start + end) >> 1;
        updateRange(node * 2, start, mid, l, r, val);
        updateRange(node * 2 + 1, mid + 1, end, l, r, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public int[] get() {
        return tree;
    }

    public void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = A[start];
        } else {
            int mid = start + end;
            mid >>= 1;
            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            A[idx] += val;
            tree[node] += val;
        } else {
            int mid = start + end;
            mid >>= 1;
            if (start <= idx && idx <= mid) {
                update(node * 2, start, mid, idx, val);
            } else {
                update(node * 2 + 1, mid + 1, end, idx, val);
            }
            int q1 = tree[node * 2];
            int q2 = tree[node * 2 + 1];
            tree[node] = q1 + q2;
        }
    }

    int query(int node, int start, int end, int l, int r) {
        if (l > end || r < start) {
            return 0;
        }
        if (l <= start && r >= end) {
            return tree[node];
        }
        int mid = start + end;
        mid >>= 1;
        int p1 = query(node * 2, start, mid, l, r);
        int p2 = query(node * 2 + 1, mid + 1, end, l, r);
        return p1 + p2;
    }

    public SegmentTree(int[] a) {
        A = a;
        tree = new int[4 * a.length + 2];
        lazy = new int[4 * A.length + 2];
        build(1, 0, A.length - 1);
    }
}
