package created;

import utils.InputReader;
import utils.OutputWriter;

public class rec {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int k = 6;
        out.println(value(61, k, false));
    }

    int value(int index, long k, boolean s) {
        if (index == 1 && k == 1) {
            if (s == false) return 0;
            else return 1;
        }
        long prevLength = 1l << (index - 1);
        prevLength--;
        //System.out.println("prevLength = " + prevLength);
        if (k == prevLength + 1) {
            if (s == false) return 0;
            else return 1;
        }
        if (k <= prevLength) return value(index - 1, k, s);
        if (k > prevLength + 1) {
            return value(index - 1, 2 * prevLength - k + 2, !s);
        }
        return 9999999;
    }
}
