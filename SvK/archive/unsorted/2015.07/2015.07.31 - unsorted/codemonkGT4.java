package created;

import utils.InputReader;
import utils.OutputWriter;

public class codemonkGT4 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();
        int edges=n-1;int x=0;
        for(int i=0;i<n;i++)x+=in.nextInt();
        if(x==2*edges)out.println("Yes");
        else out.println("No");
    }
}
