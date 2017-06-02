package created;

import utils.InputReader;
import utils.OutputWriter;

public class rust {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int cities = in.nextInt();
            int roads = in.nextInt();
            road[][] arr = new road[cities][cities];
            for (int i = 0; i < roads; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                arr[x][y].bus = in.nextInt();
                arr[x][y].taxi = in.nextInt();
            }
            for (int i = 0; i < cities; i++) {
                arr[i][i].bus = 0;
                arr[i][i].taxi = 0;
            }
            int source = in.nextInt() - 1;
            int dest = in.nextInt() - 1;
            int min=Integer.MAX_VALUE;

            for(int i=0;i<roads;i++){

            }
        }
    }

    static class road {
        int taxi;
        int bus;
        int min;

        public road(int taxi, int bus) {
            this.taxi = taxi;
            this.bus = bus;
            min = Math.min(taxi, bus);
        }
    }
}
