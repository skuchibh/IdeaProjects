package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.BitSet;
import java.util.HashMap;

public class codevitaex1 {static BitSet set=new BitSet(1225);

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int start=in.nextInt();
        int end=in.nextInt();
        int index=in.nextInt();
        primeset();
        HashMap<Integer,Integer>map=new HashMap<>();int k=1;
        for(int i=start;i<=end;i++){
            if(set.get(i)){
                map.put(k,i);k++;
            }
        }
        try {

            out.println(map.get(index));

        }
        catch (Exception e){
            System.out.println("Invalid Input");
        }
    }
    static void primeset(){
        for(int i=2;i<1225;i++)set.set(i);
        for(int i=2;i<Math.sqrt(1225);i++){
            if(set.get(i)){
                for(int j=2*i;j<=1225;j+=i){
                    set.set(j,false);
                }
            }
        }
    }
}