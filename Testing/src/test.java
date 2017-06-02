import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in * Actual solution is at the top
 *
 * @author Maverickk
 */
class test {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }
}


class TaskA {
    static char[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r, c, kk,ticker,tttt;
    private static int counta, countl, counti, countz, countw, counte;static String ttt;
    static ArrayList<String> ansarray = new ArrayList<String>();


    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int t = in.nextInt();

        for (kk = 0; kk < t; kk++) {
            r = in.nextInt();
            c = in.nextInt();

            maze = new char[r + 2][c + 2];
            visited = new boolean[r + 2][c + 2];
            for (int i = 1; i <= r; i++) {
                String temp = in.next();
                for (int j = 1; j <= c; j++) {

                    maze[i][j] = temp.charAt(j - 1);
                }
            }

            if (maze[1][1] == 'A') counta += 1;
            if (maze[1][1] == 'L') countl += 1;
            if (maze[1][1] == 'I') counti += 1;
            if (maze[1][1] == 'Z') countz += 1;
            if (maze[1][1] == 'W') countw += 1;
            if (maze[1][1] == 'E') counte += 1;

            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    if (!visited[i][j]) {
                        tttt=dfs(i, j, out, kk);

                    }
                }
            }
            if (tttt == 1) {
                ansarray.add(TaskA.kk, "YES");
            }
            if (kk > 0 && ansarray.get(kk) != null)
                ansarray.add(kk, "NO");
            else if (ansarray.isEmpty()) {
                ansarray.add(kk, "NO");
            }


        }
        for (int h = 0; h < ansarray.size()-1; h++) {
            System.out.println(ansarray.get(h));
        }
    }


    static int dfs(int i, int j, PrintWriter out, int kk) {

        visited[i][j] = true;
        ttt = null;

        for (int z = 0; z < 4; z++) {
            int xx = i + dx[z];
            int yy = j + dy[z];
            if (xx > 0 && yy > 0 && xx <= r && yy <= c && !visited[xx][yy]) {
                if (maze[xx][yy] == 'A') counta += 1;
                if (maze[xx][yy] == 'L') countl += 1;
                if (maze[xx][yy] == 'I') counti += 1;
                if (maze[xx][yy] == 'Z') countz += 1;
                if (maze[xx][yy] == 'W') countw += 1;
                if (maze[xx][yy] == 'E') counte += 1;
                //System.out.println("Z="+counta);
                dfs(xx, yy, out, kk);
            }

            if (visited[xx][yy]) {
                if (counta > 0 && countl >= 4 && counti > 0 && countz >= 2 && countw > 0 && counte > 0) {
                    ticker = 1;


                }
            }
        }

        return  ticker;
    } }


    class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }



