package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class qqpp {
    static int[]a={2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912};
    static int ans=0;
    static int n;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
      int n=in.nextInt();
        while(n>0){
            if(n%2==0)n/=2;
            else{
                ans++;
                n/=2;
            }
        }
        out.print(ans);
    }
}
