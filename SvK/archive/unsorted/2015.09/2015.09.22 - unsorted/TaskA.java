package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int ans = Integer.MIN_VALUE;int l=1;
        int local = a[0];
        for(int i=1;i<n;i++){
            if(a[i]>=local){
                local=a[i];
                ans=Math.max(ans,++l);
            }
            else {
                local=a[i];
                l=1;
                ans=Math.max(ans,l);
            }
        }
        out.println(ans);
    }
}
