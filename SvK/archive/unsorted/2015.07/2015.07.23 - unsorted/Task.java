package created;

import utils.InputReader;
import utils.OutputWriter;

public class Task {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int heros = in.nextInt();
            int above = 0;
            int towers = in.nextInt();
            int power = in.nextInt();
            for(int i=0;i<heros;i++){
                int x=in.nextInt();if(x<=power)continue;
                if(x%power==0){
                    above+=x/power-1;
                }else above+=x/power;
            }
            if (above >= towers) out.println("YES");
            else out.println("NO");
        }
    }
}
