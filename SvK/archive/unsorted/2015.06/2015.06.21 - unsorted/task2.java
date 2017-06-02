package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class task2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] cnt = new int[26];
        char[] a = in.readLine().toCharArray();
        for (int i = 0; i < n; i++) cnt[a[i] - 'a']++;
        long ans = n;
        for (int i = 0; i < n; i++) {
            if (cnt[a[i] - 'a'] > 1) {
                ans += cnt[a[i] - 'a'] - 1;
                cnt[a[i] - 'a']--;
            }
            }
        out.println(ans);
    }

    long fact(int n) {
        if (n == 1) return 1;
        return n * fact(n - 1);

    }
}
