package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class AMR10G {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();int k=in.nextInt();
            int []h= IOUtils.readIntArray(in,n);
            Arrays.sort(h);
            int min=Integer.MAX_VALUE;
            for(int i=0;i+(k-1)<=h.length-1;i++){
                int x=h[i];int y=h[i+(k-1)];
                min=Math.min(min,Math.abs(x-y));
            }
            out.println(min);
        }
    }
}
