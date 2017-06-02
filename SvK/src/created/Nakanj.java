package created;

import sv.misc.ArrayUtils;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.LinkedList;
import java.util.Queue;

public class Nakanj {
    static int[] dx = {-2, -1, -2, -1, 2, 1, 2, 1};
    static int[] dy = {-1, -2, 1, 2, -1, -2, 1, 2};
    //static int startx, destx, desty, starty;
    static int[][] grid;
    static boolean[][] vis;
    static int[][] moves;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            moves = new int[8][8];
            vis = new boolean[8][8];
            int startx = in.readCharacter() - 'a';
            int starty = in.nextInt() - 1;
            moves[startx][starty] = 0;
            int destx = in.readCharacter() - 'a';
            int desty = in.nextInt() - 1;
            if (startx == destx && starty == desty) out.println(0);
            else
                out.println(bfs(out, startx, starty, destx, desty));

        }

    }

    static int bfs(OutputWriter out, int startx, int starty, int destx, int desty) {
        vis[startx][starty] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startx, starty));
        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            if (x == destx && y == desty) return moves[x][y];
            for (int z = 0; z < 8; z++) {
                int xx = x + dx[z];
                int yy = y + dy[z];

                if (xx < 0 || xx > 7 || yy < 0 || yy > 7 || vis[xx][yy]) continue;
                vis[xx][yy] = true;
                moves[xx][yy] = moves[x][y] + 1;
                q.add(new Point(xx, yy));
            }
        }
        return 0;
    }/*
    static void print(OutputWriter out,int [][]moves){
        IOUtils.printTable(out,moves);
        out.println();
        out.println();
    }*/

    static class Point {
        int x, y;

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
