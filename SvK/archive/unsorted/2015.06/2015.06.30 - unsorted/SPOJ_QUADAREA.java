package created;

import utils.InputReader;
import utils.OutputWriter;

public class SPOJ_QUADAREA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t=in.nextInt();
        while(t-->0){
            double a=in.readDouble();double b=in.readDouble();
            double c=in.readDouble();double d=in.readDouble();
            double s=a+b+c+d;
            s/=2;
            double ans=s-a;
            ans*=s-b;ans*=s-c;ans*=s-d;
            ans=Math.sqrt(ans);
            out.printFormat("%.2f",ans);
            out.println();
        }
    }
}
