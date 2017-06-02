package sv.numbers;


import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Surya Vamsi on 21-Jul-15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        solve(in, out);
        out.close();
    }

    static void solve(BufferedReader in, PrintWriter out) throws IOException {
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            in.readLine();
            char x = in.readLine().charAt(0);
            int n = x - 'A' + 1;
            UnionFind uf = new UnionFind(n + 1);

            while (true) {
                String xxx = in.readLine();
                if (xxx.equals(null)) break;
                out.println(xxx);
            }}
    }

    static class UnionFind {
        int[] size;
        int[] id;
        int count;
        public int getComponents(){
            return count;
        }
        public UnionFind(int n) {
            size = new int[n];
            count = n-1;
            id = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                id[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootp = find(p);
            int rootq = find(q);
            if (rootp == rootq) return;
            if (size[rootp] < size[rootq]) id[rootp] = rootq;
            else if (size[rootp] > size[rootq]) id[rootq] = rootp;
            else {
                id[rootq]=rootp;size[rootp]++;
            }count--;
        }

        public int find(int p) {
            while(p!=id[p]){
                id[p]=id[id[p]];
                p=id[p];
            }return p;
        }

    }
}


