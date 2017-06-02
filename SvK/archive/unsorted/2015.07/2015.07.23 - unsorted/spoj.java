package created;

import utils.InputReader;
import utils.OutputWriter;

public class spoj {
    public void solve(int testNumber, InputReader in, OutputWriter out) {int k=0;
        while (true) {
            String x = in.readString();
            if (x.charAt(0) == '-') break;
            char []arr=x.toCharArray();
            int i=0,ans=0,left=0,right=0;
            while (true){
                if(arr[i]=='{')left++;
                else if(arr[i]=='}' && left==0){
                    left++;ans++;
                }
                else {
                    left--;
                }
                i++;if(i==arr.length)break;
            }
            ans+=left/2;
            out.println(++k+". "+ans);
        }
    }
}
