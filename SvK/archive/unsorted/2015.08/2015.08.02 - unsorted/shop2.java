package created;

import sv.misc.ArrayUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.LinkedList;

public class shop2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            if(n%2==0){
                int start=n/2;
                int x=1;
                for(int i=start;i>0;i--){
                    out.print(i+" "+(i+x)+" ");x+=2;
                }
            }
            else if(n==3){
                out.print("2 1 3");
            }
            else{
                int start=n/2+1;
                int x=0;
                for(int i=start;i>0;i--){
                    if(x==0){
                    out.print(i+" ");}
                    else {
                        out.print(i+" "+(i+x)+" ");
                    }
                    x+=2;
                }
            }
            if(t>0)
            out.println();
        }
    }
}
