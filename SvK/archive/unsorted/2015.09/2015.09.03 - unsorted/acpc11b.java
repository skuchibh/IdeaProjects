package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class acpc11b {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        outer:
        while (t-- > 0) {
            int n1 = in.nextInt();
            int[] a = new int[1010];
            int[] b = new int[1010];
            for (int i = 0; i < n1; i++) a[i] = in.nextInt();
            int n2 = in.nextInt();
            for (int i = 0; i < n2; i++) b[i] = in.nextInt();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < a.length; i++) {
                    if(a[i]==0)break;
                for (int j = 0; j < b.length; j++) {
                    if(b[j]==0)break;
                    min = Math.min(min, Math.abs(a[i] - b[j]));
                }
            }
            out.println(min);
        }
    }
}
