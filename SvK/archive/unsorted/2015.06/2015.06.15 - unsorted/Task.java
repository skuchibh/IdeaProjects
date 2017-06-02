package created;

import sv.misc.ArrayUtils;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

public class Task {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t=in.nextInt();
        int []a= IOUtils.readIntArray(in,t);
        int []b=new int[3000];
        for(int x:a)b[x]++;
        int max= ArrayUtils.maxElement(a);
        int ans=1;
        for(int i=0;i<t;i++){ans=1;
            for(int j=max;j>a[i];j--){
                if(a[i]!=max)ans+=b[j];
                else ans=1;
            }
            out.print(ans +" ");
        }
    }
}
