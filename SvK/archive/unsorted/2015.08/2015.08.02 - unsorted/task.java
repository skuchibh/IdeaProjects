package created;

import sv.misc.ArrayUtils;
import utils.InputReader;
import utils.OutputWriter;

public class task {
    static int[] dirtiness;
    static int minright=0,minleft=0;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int member=in.nextInt();
            int b=0;
            if(member%n==0)b=member/n-1;
            else b=member/n;int bb=0;
            dirtiness=new int[n+1];

        }
    }

    static void lookLeft(int member,int min) {
        for(int i=1;i<dirtiness.length;i++){
            if(dirtiness[i]==min){
                dirtiness[i]++;return;
            }
        }
    }

    static void lookRight(int member,int min) {
        for(int i=dirtiness.length-1;i>0;i--){
            if(dirtiness[i]==min){
                dirtiness[i]++;return;
            }
        }
    }
}
