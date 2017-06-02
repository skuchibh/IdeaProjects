package created;

import utils.InputReader;
import utils.OutputWriter;

public class b {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t=in.nextInt();
        while(t-->0){
            long a=in.readLong();
            long b=in.readLong();
            long x=a^b;
            out.println(Long.bitCount(x));
        }
    }
}
