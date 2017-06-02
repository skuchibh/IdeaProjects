package test;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
            long n=in.nextLong();long m=in.nextLong();
            out.println(check(n,m));

    }
    static long check(long n,long m){
        if(n==0 || m==0)return 0;
        if(n==m)return 1l;

        else
            return ((n/m)+check(m,n%m));

    }

}
