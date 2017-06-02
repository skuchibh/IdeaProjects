package created;

import java.util.HashMap;

public class BearDartsDiv2 {
    public long count(int[] w) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int limit = 1000000;

        long ans = 0l;
        int n = w.length;
        for (int d = 0; d < n; ++d) {
            if (map.get(w[d]) != null) ans += map.get(w[d]);
            for (int a = 0; a < d; a++) {
                for (int b = a + 1; b < d; b++) {
                    long mul = (long) w[a] * (long) w[b] * (long) w[d];
                    if (mul <= limit) {
                        if (map.get((int) mul) == null) {
                            map.put((int) mul, 1);
                        } else {
                            int x = map.get((int) mul);
                            map.put((int) mul, x++);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
