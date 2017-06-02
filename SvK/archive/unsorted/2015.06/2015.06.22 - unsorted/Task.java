package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class Task {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int kk = in.nextInt();
        long ans = 0;
        int[] boys = IOUtils.readIntArray(in, n);
        int[] girls = IOUtils.readIntArray(in, n);
        Arrays.sort(boys);
        Arrays.sort(girls);
        int k = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if(Math.abs(boys[i]-girls[j])<=kk){
                ans++;i++;j++;
            }else if(boys[i]<girls[j])i++;
            else j++;
        }
        out.println(ans);


    }
}
