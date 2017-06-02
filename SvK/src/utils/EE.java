package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Surya Vamsi on 19-Jul-15.
 */
public class EE {
    static List<Integer>[] edges;
    static boolean[] visited;
    static int start = 0, end = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        edges = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < edges.length; i++) edges[i] = new ArrayList<>();
        while (true) {
            String[] temp = br.readLine().split(" ");
            if (temp[0].equals("-1")) break;
            int in1 = Integer.valueOf(temp[1]);
            int in2 = Integer.valueOf(temp[2]);
            if (temp[0].equals("C")) {
                int x = in1;
                int y = in2;
                edges[x].add(y);
                edges[y].add(x);
            } else if (temp[0].equals("Q")) {
                start = in1;
                end = in2;
                /*System.out.println(edges[start]);
                System.out.println(edges[2]);
                System.out.println(edges[3]);
                */
                visited = new boolean[n + 1];
                if (dfs(start)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
    static boolean dfs(int i) {
        Stack<Integer> stk = new Stack<>();
        stk.push(i);
        while (!stk.isEmpty()) {
            int v = stk.pop();
            if (!visited[v]) {
                visited[v] = true;
                for (int ii = 0; ii < edges[v].size(); ii++) {
                    //System.out.println(edges[v]);
                    if (edges[v].get(ii) == end) return true;
                    stk.push(edges[v].get(ii));
                }
            }
        }

        return false;
    }
}
