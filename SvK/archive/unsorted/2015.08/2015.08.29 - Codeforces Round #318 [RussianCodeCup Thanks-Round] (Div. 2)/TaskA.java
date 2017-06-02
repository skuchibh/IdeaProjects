package created;

import sv.misc.ArrayUtils;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = IOUtils.readIntArray(in, n);
        int ans = 0;
        while (true) {
            int maxpos=0;int max=0;
            for(int i=0;i<n;i++)if(a[i]>=max){
                max=a[i];maxpos=i;
            }
            if(maxpos==0)break;
            a[maxpos]--;ans++;a[0]++;
        }
        out.print(ans);
    }
}
