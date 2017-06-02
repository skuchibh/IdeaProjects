package created;

import utils.InputReader;
import utils.OutputWriter;

public class neg {
    static int n;
    static int[] BIT=new int[1000];

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n=in.nextInt();
        int[]a=new int[n+1];
        int i;
        for(i=1;i<=n;i++){
            a[i]=in.nextInt();
            update(i,a[i]);
        }
        out.println(query(n)-query(3)+query(1));

    }

    static void update(int x, int val) {
        for (; x <= n; x += x & (-x))
            BIT[x] += val;

    }
    static void updatee(int x,int val){
        for(;x<=n;x+=x&(-x)){
            BIT[x]+=val;
        }
    }
    static int query(int x){
        int sum=0;
        for(;x>0;x-=x&(-x))
            sum+=BIT[x];
        return sum;
    }
}