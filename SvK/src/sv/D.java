package sv;

import utils.IOUtils;

import java.io.*;
import java.util.*;

public class D {
    FastScanner in;
    PrintWriter out;
    static int[][] grid;
    static boolean[][] vis;
    static int count = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int rows;
    static int cols;
    static ArrayList<Integer> list = new ArrayList<>();

    void solve() throws IOException {
        int testcases = in.nextInt();
        for (int t = 1; t <= testcases; t++) {
            out.println("Case #"+t+":");
            rows = in.nextInt();
            cols = in.nextInt();
            grid = new int[rows][cols];
            vis = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                char[] arr = in.next().toCharArray();
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = arr[j] - '0';
                }
            }
            int q = in.nextInt();
            while (q-- > 0) {
                char ch = in.next().charAt(0);
                if (ch == 'Q') {
                    count = 0;
                    vis=new boolean[rows][cols];
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            if (grid[i][j] == 1 && !vis[i][j]) {
                                count++;
                                dfs(i, j);

                            }
                        }
                    }
                    out.println(count);
                } else {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    int val = in.nextInt();
                    grid[x][y] = val;
                }
            }
        }
    }

    static void dfs(int i, int j) {
        vis[i][j] = true;
        Stack<Point> stk = new Stack<>();
        stk.push(new Point(i, j));
        while (!stk.isEmpty()) {
            //System.out.println("OK");
            Point dp = stk.pop();
            for (int z = 0; z < 4; z++) {
                int xx = dp.x + dx[z];
                int yy = dp.y + dy[z];
                if (xx >= 0 && xx < rows && yy >= 0 && yy < cols) {
                    if (!vis[xx][yy] && grid[xx][yy] == 1) {
                        vis[xx][yy] = true;
                        stk.push(new Point(xx, yy));
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    void run() {
        try {
            //in = new FastScanner(new File("C:\\Users\\Surya Vamsi\\Downloads\\GCJ\\C-large-practice.in"));
            //out = new PrintWriter(new File("C:\\Users\\Surya Vamsi\\Downloads\\GCJ\\C-large-practice.out"));
            in = new FastScanner(new File("C:\\Users\\Surya Vamsi\\Desktop\\CODEVITA\\A-large.in"));
            out = new PrintWriter(new File("C:\\Users\\Surya Vamsi\\Desktop\\CODEVITA\\A-large.out"));

            //in = new FastScanner(new File("C:\\Users\\Surya Vamsi\\Downloads\\GCJ\\a.in"));
            //out = new PrintWriter(new File("C:\\Users\\Surya Vamsi\\Downloads\\GCJ\\a.out"));
            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void runIO() throws IOException {
        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

    }

    public static void main(String[] args) {
        new D().run();
    }
}