package created;

public class BearPaints {
    public long maxArea(int A, int B, long M) {
        long ans = 0;
        for (int i = 1; i <= A; i++) {
            long x = M / i;
            System.out.println("x = " + x);
            if(x>=B)x=B;
            System.out.println("x2 = " + x);
            ans=Math.max(ans,x*i);
            System.out.println("x*i = " + x*i);
        }
        return ans;

    }
}
