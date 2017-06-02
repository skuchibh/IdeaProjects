package created;

import sv.misc.ArrayUtils;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class snake {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        int[][] grid = new int[100][100];
        while (t-- > 0) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (i == j) grid[i][j] = 0;
                    if ((j - i) > 0 && (j - i) <= 6) grid[i][j] = 1;
                    else grid[i][j] = Integer.MAX_VALUE / 2 - 10;
                }
            }

        /*for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }*/
            int lad = in.nextInt();
            while (lad-- > 0) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                grid[x][y] = 0;
            }
            int snks = in.nextInt();
            int[] bool = new int[100];
            while (snks-- > 0) {
                int x = in.nextInt() - 1;
                Arrays.fill(grid[x],Integer.MAX_VALUE/2-10);
                int y = in.nextInt() - 1;
                grid[x][y] = 0;
            }


            for (int k = 0; k < 100; k++)
                for (int i = 0; i < 100; i++)
                    for (int j = 0; j < 100; j++) {
                        //if (bool[k] == 1 ) continue;
                        grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                        //if (i == 0 && j == 99)
                            //System.err.println(grid[i][j] + " " + i + " " + k + " " + " " + j + " " + grid[i][k] + " " + grid[k][j]);
                    }
            /*for(int i=0;i<100;i++){
                for(int j=0;j<100;j++){
                    System.out.print(grid[i][j]+" ");
                }
                System.out.println();
            }*/
            if (grid[0][99] != Integer.MAX_VALUE / 2 - 10)
                out.println(grid[0][99]);
            else out.println(-1);

        }
    }
}
