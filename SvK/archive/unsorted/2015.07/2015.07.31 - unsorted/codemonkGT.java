package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class codemonkGT {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            Set<Integer>set=new TreeSet<>();
            for(int i=0;i<n;i++){
                int x=in.nextInt();int y=in.nextInt();
                set.add(x);set.add(y);
            }
            out.println(set.size());
        }
    }
}
