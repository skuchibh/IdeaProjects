package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

public class JULY15C {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long k = in.readLong();
            long x = k;
            long[] a = IOUtils.readLongArray(in, n);
            long ans = 0;
            long leftover = 0;
            inner:
            for (int i = 0; i < n; i++) {
                if (k != x) {
                    if (a[i] - k >= 0) {
                        a[i] -= k;
                        k = x;
                    } else {
                        k -= a[i];
                        k--;
                        System.err.println("k = " + k);
                        if(k==0)k=x;
                        a[i] = 0;
                        continue inner;
                    }
                    //if (k <= 1) {ans++;k = x;}
                }
                long temp = a[i] <= k ? (long) Math.ceil((double) a[i] / (double) k) : (long) Math.floor((double) a[i] / (double) k);
                ans += temp;
                //System.out.println("ans = " + ans);
                if (a[i] <= k) k -= a[i];
                else if (a[i] > k)
                    leftover = a[i] - (temp * k);
                if (leftover <= 0) leftover = 0;
                if (leftover > 0) {
                    ans++;
                    k -= leftover;
                    leftover = 0;
                }
                if (k > 1 && k != x) k--;
                else k = x;
                //System.out.println("k = " + k);
            }
            out.println(ans);

        }
    }
}
