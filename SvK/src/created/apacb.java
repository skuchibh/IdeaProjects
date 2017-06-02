package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.HashSet;
import java.util.TreeSet;

public class apacb {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        for (int ii = 1; ii <= t; ii++) {
            out.println("Case #" + ii + ":");
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            int n3 = in.nextInt();
            int[] a = new int[n1];
            int[] b = new int[n2];
            int[] c = new int[n3];
            for (int i = 0; i < n1; i++) a[i] = in.nextInt();
            for (int i = 0; i < n2; i++) {
                b[i] = in.nextInt();
            }
            for (int i = 0; i < n3; i++) {
                c[i] = in.nextInt();
            }
            for(int i=0;i<n1;i++)
                for(int j=0;j<n3;j++){
                    inser(a[i],c[j]);
                }
            int qr=in.nextInt();int x=0;int y=0;
            while(qr-->0){
                int p=in.nextInt();
                int q=in.nextInt();
                int bv=0;
                //System.out.println(set);
                for(int i=0;i<n2 && bv==0;i++)
                    for(int j=0;j<n2 && bv==0;j++){
                        if(i==j)continue;
                        x=b[i];y=b[j];
                        if(get(y*p,x*q)){
                            bv=1;break;}
                    }
                if(bv==1)out.println("Yes");
                else out.println("No");
            }

        }
    }
    static boolean get(long x,long y){
        long g=gcd(x,y);
        x/=g;y/=g;
        //System.out.println("x+\" \"+y+\" \"+g = " + x+" "+y+" ");
        //System.out.println(set);

        for(Pair p:set){
            long xx=p.x;long yy=p.y;
            if(xx==x && yy==y)return true;
        }
        return false;
    }

    static class Pair {
        long x;
        long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static HashSet<Pair> set = new HashSet<>();

    static void inser(long x, long y) {
        long g = gcd(x, y);
        x /= g;
        y /= g;
        set.add(new Pair(x, y));
    }


    static long gcd(long x, long y) {
        return y==0?Math.abs(x):gcd(y, x % y);
    }
}
