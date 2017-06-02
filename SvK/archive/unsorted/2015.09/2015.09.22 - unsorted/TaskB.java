package created;

import utils.InputReader;
import utils.OutputWriter;

import java.math.BigInteger;
import java.util.Arrays;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();int d = in.nextInt();
        long []dp=new long[n];Friend[] arr = new Friend[n];
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            arr[i] = new Friend(a, b);
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++)if(i==0)dp[i]=arr[i].factor;
        else dp[i]=dp[i-1]+arr[i].factor;
        long maxx = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x = BinarySearch(arr, d, i, arr.length - 1, 0);
            long local=0;
            if(i==0)local=dp[x];
            else local=dp[x]-dp[i-1];
            maxx=Math.max(maxx,local);
        }
        out.println(maxx);

    }

    static int BinarySearch(Friend[] arr, int d, int lo, int hi, int key) {
        int dup = arr[lo].money;
        while (lo != hi) {
            int mid = lo + ((hi - lo) / 2);
            long temp = (long) dup + (long) d;
            if (temp <= arr[mid].money) {
                hi = mid;
            } else lo = mid;
            if (lo + 1 == hi) {
                if (temp > arr[hi].money) return hi;
                else return lo;
            }
        }
        return lo;
    }


    static BigInteger to(int n) {
        return BigInteger.valueOf(n);
    }

    static class Friend implements Comparable {
        int money;
        int factor;

        @Override
        public String toString() {
            return "Friend{" +
                    "money=" + money +
                    ", factor=" + factor +
                    '}';
        }

        public Friend(int money, int factor) {
            this.money = money;
            this.factor = factor;
        }

        @Override
        public int compareTo(Object o) {
            Friend f = (Friend) o;
            return this.money - f.money;
        }
    }
}
