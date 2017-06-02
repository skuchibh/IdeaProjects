package created;

import utils.InputReader;
import utils.OutputWriter;

public class c4 {
    static int[] a;
    static boolean[] yes;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();

        a = new int[n];
        yes = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int modd = x % 10;
            if (modd == 0) {
                yes[i] = false;
                a[i] = x;
                continue;
            }
            if (modd == 1 || modd == 5 || modd == 6) yes[i] = true;
            a[i] = x;
        }
        while (q-- > 0) {
            int ch = in.nextInt();
            if (ch == 2) {
                    out.println("Automorphic: "+compute2(in.nextInt(),in.nextInt()));
            }
            else if(ch==1){
                int a=in.nextInt();int b=in.nextInt();
                int range=b-a+1;
                out.println("Non Automorphic: "+(range-(compute2(a,b))));
            }
            else if(ch==3){
                int a=in.nextInt();int b=in.nextInt();
                update(a,b);
            }
        }
    }
    static int compute2(int l,int r){
        int ans=0;
        for(int i=l;i<=r;i++){
            if(yes[i])ans++;
        }
        return ans;
    }

    static void update(int index, int n) {
        int modd = n % 10;
        if (modd == 1 || modd == 5 || modd == 6) {
            yes[index] = true;
            a[index] = n;
        }
        else {
            yes[index]=false;
            a[index]=n;
        }
    }
}
