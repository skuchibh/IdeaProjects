package created;

import sun.nio.ch.IOUtil;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Task {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int req=in.nextInt();
            int []a= IOUtils.readIntArray(in, n);
            ArrayList<Integer>x=new ArrayList<>();
            for(int i=0;i<a.length;i++){
                x.add(Integer.bitCount(a[i]));
            }
            for (int i = 0; i < 0; i++) {

            }
            Collections.sort(x,Collections.reverseOrder());
            long ans=0;
            for(int i=0;i<req;i++){
                ans+=x.get(i);
            }
            out.println(ans);

        }
    }
}
