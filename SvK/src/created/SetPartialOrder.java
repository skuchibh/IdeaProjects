package created;

import java.util.HashSet;
import java.util.Set;

public class SetPartialOrder {
    public String compareSets(int[] a, int[] b) {
        Set<Integer>A=new HashSet<>();
        Set<Integer>B=new HashSet<>();
        for(int x:a)A.add(x);
        for(int x:b)B.add(x);
        boolean yes1=A.containsAll(B);
        boolean yes2=B.containsAll(A);
        if(yes1 && yes2)return "EQUAL";
        if(yes1)return "GREATER";
        if(yes2)return "LESS";
        return "INCOMPARABLE";
    }
}
