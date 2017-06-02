import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Codeforces508A {

    static int counter = 0;
    static boolean[][] board;

    public static void main(String[] args) throws IOException {

        PrintWriter out = new PrintWriter(System.out, true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        board = new boolean[n + 2][m + 2];
        int k = Integer.parseInt(temp[2]);
        boolean ticker = true;
        for (int i = 0; i < k; i++) {

            temp = br.readLine().split(" ");
            counter++;
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            board[x][y] = true;
            for (int dx = -1; dx <= 0; dx++) {
                for (int dy = -1; dy <= 0; dy++) {
                    if (board[x + dx][y + dy] && board[x + dx + 1][y + dy] && board[x + dx][y + dy + 1] && board[x + dx + 1][y + dy + 1]) {
                        ticker = false;

                    }
                }

            }
            if (!ticker) {
                out.println(i + 1);
                out.close();
            }


        }
        if (ticker) {
            out.println("0");
            out.close();
        }

    }
}
