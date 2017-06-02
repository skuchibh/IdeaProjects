package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.Stack;

public class dfs {
    static int[][] grid;
    static boolean[][] vis;
    static int count = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int rows;
    static int cols;
    static ArrayList<Integer> list = new ArrayList<>();

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int testcases = in.nextInt();
        for (int t = 1; t <= testcases; t++) {
            out.println("Case #"+t+":");
            rows = in.nextInt();
            cols = in.nextInt();
            grid = new int[rows][cols];
            vis = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                char[] arr = in.readString().toCharArray();
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = arr[j] - '0';
                }
            }
            int q = in.nextInt();
            while (q-- > 0) {
                char ch = in.readCharacter();
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
}
