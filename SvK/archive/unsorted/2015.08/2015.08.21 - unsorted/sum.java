package created;

import utils.InputReader;
import utils.OutputWriter;

public class sum {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n=in.readLong();
        long max=0;
        for(long i=0;i<n;i++)max+=in.readLong();
        out.println(max);
    }
}
