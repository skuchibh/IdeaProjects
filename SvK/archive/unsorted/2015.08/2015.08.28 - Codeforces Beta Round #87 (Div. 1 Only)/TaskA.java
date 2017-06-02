package created;

import sv.misc.ArrayUtils;
import utils.InputReader;
import utils.OutputWriter;

public class TaskA {static int[]depth;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
         depth = new int[n + 1];
        int max=0;
        for (int i = 1; i <= n; i++) {
            depth[i]=in.nextInt();
        }
        for(int i=1;i<=n;i++){
            max=Math.max(max,f(i));
        }
        out.println(max);

    }
    int f(int n){
        if(depth[n]==-1)return 1;
        else return 1+f(depth[n]);
    }

}
