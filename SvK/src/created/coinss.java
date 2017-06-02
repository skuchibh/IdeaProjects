package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.HashMap;

public class coinss {
    static HashMap<Long,Long>map=new HashMap<>();

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long amount = in.readLong();
        out.print(max(amount));
    }

    static long max(long inr) {
        if (inr <= 5) return inr;
        Long val=(Long)map.get(inr);
        if(val!=null)return val;

        long curr = max(inr / 2) + max(inr / 3) + max(inr / 4);
        System.out.println("OK");
        if(curr>inr){
            map.put(inr,curr);
            return curr;
        }
        else {
            map.put(inr,inr);
            return inr;
        }
    }
}
