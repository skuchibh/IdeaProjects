package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.TreeSet;

public class frnd {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();
        TreeSet<Integer>set=new TreeSet<>();
        ArrayList<Integer>friend=new ArrayList<>();
        for(int i=0;i<n;i++){
            int x=in.nextInt();
            friend.add(x);
            int fl=in.nextInt();
            while(fl-->0){
                set.add(in.nextInt());
            }

        }
        for(int x:friend)if(set.contains(x))set.remove(x);
        out.println(set.size());
    }
}
