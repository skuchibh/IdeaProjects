package created;

import sv.misc.ArrayUtils;
import utils.InputReader;
import utils.OutputWriter;

public class pam {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int nFolders = in.nextInt();
        int[] folders = new int[nFolders];
        for (int i = 0; i < nFolders; i++) folders[i] = in.nextInt();
        out.println(f(folders, n));
    }

    static int f(int[] folders, int n) {
        int lo = ArrayUtils.maxElement(folders);
        int hi = 0;
        for (int x : folders) hi += x;
        while (lo < hi) {
            int x = lo + (hi - lo) / 2;
            int req = 1;
            int curr = 0;
            for (int i = 0; i < folders.length; i++) {
                if (curr + folders[i] <= x) {
                    curr+=folders[i];
                }
                else {
                    req++;
                    curr=folders[i];
                }
            }
            if(req>n)lo=x+1;
            else hi=x;
        }
        return lo;
    }
}