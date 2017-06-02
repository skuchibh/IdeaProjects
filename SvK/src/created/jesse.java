package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

public class jesse {
    static int[] arr;
    static int n, StrengthJesse;
    static int ans;
    static boolean yes;
    static int[] dp;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        StrengthJesse = in.nextInt();
        arr = IOUtils.readIntArray(in, n);
        dp = new int[n + 1];
        for(int i=0;i<n;i++){
            if(StrengthJesse>=arr[i]){
                ans++;
            }
            else {
                if(!yes){
                    yes=true;
                }
                else {
                    break;
                }
            }
        }
        out.println(ans);
    }
}
