package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.HashMap;

public class major {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        outer:
        while (t-- > 0) {
            int n = in.nextInt();
            int benchmark = n % 2 == 0 ? n / 2 : n / 2 + 1;
            HashMap<Integer, Integer> map = new HashMap<>();int max=0;
            boolean yes=false;int prev=0;
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                if (map.get(x) == null) map.put(x, 1);
                else map.put(x, map.get(x) + 1);
                if (map.get(x) > benchmark) {
                    prev=x;yes=true;
                }
            }
            if(yes)out.println("YES " + prev);
            else
            out.println("NO");

        }
    }
}
