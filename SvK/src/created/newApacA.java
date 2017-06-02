package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class newApacA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            out.println("Case #" + tt + ":");
            int top = in.nextInt();
            int[] scores = new int[top + 1];
            for (int i = 1; i <= top; i++) scores[i] = in.nextInt();
            int nC = in.nextInt();
            HashMap<String, Player> map = new HashMap<>();
            for (int i = 1; i <= nC; i++) {
                String[] temp = in.readLine().split(" ");
                int weight = Integer.parseInt(temp[0]);
                for (int j = 0; j < top; j++) {
                    String x = temp[j + 1];
                    if (map.get(x) == null) {
                        map.put(x, new Player(x));
                        map.get(x).scores.add(weight * scores[j + 1]);
                    } else {
                        map.get(x).scores.add(scores[j + 1] * weight);
                    }
                }
            }
            ArrayList<Player> players = new ArrayList<>();
            for (Player p : map.values()) {
                players.add(p);
            }
            int limit = in.nextInt();
            for (int i = 0; i < players.size(); i++) {
                players.get(i).total = players.get(i).getScore(limit);
            }
            Collections.sort(players);
            int rank = 0;
            int prev = -1;
            for (int i = 0; i < players.size(); ++i) {
                if (players.get(i).total != prev) {
                    rank = i + 1;
                    prev = players.get(i).total;
                }
                out.println(rank + ": " + players.get(i).name);
            }
        }
    }

    static class Player implements Comparable {
        String name;
        ArrayList<Integer> scores;
        int total;

        public Player(String name) {
            scores = new ArrayList<>();
            this.name = name;
        }

        public int getScore(int lim) {
            for (int i = 0; i < lim && i < scores.size(); i++) {
                total += scores.get(i);
            }
            return total;
        }

        @Override
        public int compareTo(Object o) {
            Player p = (Player) o;
            if (total != p.total) {
                return p.total - total;
            }
            return name.compareTo(p.name);
        }
    }
}
