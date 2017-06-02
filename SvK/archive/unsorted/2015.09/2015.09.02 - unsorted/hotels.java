package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

public class hotels {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        long amount = in.readLong();
        long[] a = new long[n];
        long sum = 0l;
        for (int i = 0; i < n; i++) {
            a[i] = in.readLong();
            sum += a[i];
        }
        if (sum <= amount) {
            out.println(sum);
            return;
        }
        long curr=0;int back=0;long max=0;
        for(int i=0;i<n;i++){
            curr+=a[i];
            while(curr>amount)curr-=a[back++];
            max=Math.max(max,curr);
        }
        out.println(max);


    }
}
