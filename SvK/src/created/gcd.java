package created;

import utils.InputReader;
import utils.OutputWriter;

public class gcd {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a=120;int b=30;
        out.println(gcd(a,b));
    }
    static int gcd(int x,int y){
        return y==0?Math.abs(x):gcd(y,x%y);
    }
}
