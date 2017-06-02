package created;

import sv.SegmentTreeLazy.SegmentTree;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class roy {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int max = 1000000;
        int[] start = new int[max + 1];
        int[] end = new int[max + 1];
        int[] days = new int[max + 1];
        int[] ans = new int[max + 1];
        int nu = in.nextInt();
        while (nu-- > 0) {
            int from=in.nextInt();int to=in.nextInt();
            start[from]++;
            end[to]++;
        }
        int count=0;
        for(int i=0;i<max+1;i++){
            count+=start[i];
            days[i]=count;
            count-=end[i];
        }
        for(int i=0;i<max+1;i++){
            ans[days[i]]++;
        }
        for(int i=max-1;i>0;i--){
            ans[i]+=ans[i+1];
        }
        int q=in.nextInt();
        while(q-->0){
            out.println(ans[in.nextInt()]);
        }
    }
}
