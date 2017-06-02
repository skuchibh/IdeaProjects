package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SPOJ_BITMAP {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] arr = new int[rows][cols];
        int[][] ans = new int[rows][cols];
        for (int i = 0; i < rows; i++) Arrays.fill(ans[i], Integer.MIN_VALUE);
        Queue<Bit> q = new LinkedList<>();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                arr[i][j] = in.readCharacter() - '0';
                if (arr[i][j] == 1) {
                    ans[i][j]=0;
                    q.add(new Bit(i, j, 0));
                }
            }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Bit bit = q.poll();
            for (int z = 0; z < 4; z++) {
                int xx = bit.x + dx[z];
                int yy = bit.y + dy[z];
                if (xx >= 0 && yy >= 0 && xx < rows && yy < cols) {
                    if (ans[xx][yy] < 0) {
                        ans[xx][yy] = bit.dist + 1;
                        q.add(new Bit(xx, yy, bit.dist + 1));
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    class Bit {
        int x, y, dist;

        public Bit(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
