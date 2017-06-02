package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();
        char []a=in.readLine().toCharArray();
        int []cnt=new int[2];
        for(char x:a)cnt[x-'0']++;
        out.println(n-(2*Math.min(cnt[0],cnt[1])));
    }
}
