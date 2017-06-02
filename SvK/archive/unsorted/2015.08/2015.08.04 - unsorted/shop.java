package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.PriorityQueue;

public class shop {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (true) {
            int columns = in.nextInt();
            int rows = in.nextInt();
            if(columns==0 && rows==0)return;
            int sourcex = 0, sourcey = 0, destx = 0, desty = 0;
            int[][] grid = new int[rows][columns];
            //System.out.println("rows+\" \"+columns = " + rows+" "+columns);
            for(int i=0;i<rows;i++){
                char []ch=in.readString().toCharArray();
                for(int j=0;j<columns;j++){
                    if(ch[j]=='S'){
                        sourcex=i;sourcey=j;
                    }
                    else if(ch[j]=='D'){
                        destx=i;desty=j;
                    }
                    else if(ch[j]=='X'){
                        grid[i][j]=Integer.MAX_VALUE;
                    }
                    else {
                        grid[i][j]=ch[j]-'0';
                    }
                }
            }


            PriorityQueue<Position> q = new PriorityQueue<>();
            boolean[][] vis = new boolean[rows][columns];
            q.add(new Position(sourcex, sourcey, 0));
            int cost = 0;
            int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
            while (!q.isEmpty()) {
                Position dequeue = q.poll();
                int x = dequeue.x;
                int y = dequeue.y;
                cost = dequeue.cost;
                if (x == destx && y == desty) break;
                if (vis[x][y]) continue;
                vis[x][y] = true;
                for (int z = 0; z < 4; z++) {
                    int xx = x + dx[z];
                    int yy = y + dy[z];
                    if (xx < 0 || yy < 0 || yy >= columns || xx >= rows || vis[xx][yy]) continue;
                    q.add(new Position(xx, yy, cost + grid[xx][yy]));
                }
            }
            out.println(cost);
        }
    }

    static class Position implements Comparable<Position> {
        public int x, y, cost;

        public Position(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Position o) {
            return cost - o.cost;
        }
    }
}
