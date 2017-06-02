package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

public class maxsubarray {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int posmax=0;
            int maxsofar=0,curmax=0;int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                int x=in.nextInt();
                if(x>=0)posmax+=x;
                max=Math.max(max,x);
                curmax+=x;
                //System.out.println("curmax = " + curmax);
                if(curmax>=0){

                    if(maxsofar<curmax)maxsofar=curmax;
                }
                else{
                    curmax=0;
                }
            }
            if(posmax==0)posmax=max;
            if(maxsofar==0)maxsofar=max;
            out.println(maxsofar+" "+posmax);

        }
    }

}
