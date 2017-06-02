package created;

import utils.InputReader;
import utils.OutputWriter;

import java.math.BigInteger;
import java.util.HashMap;

public class Fib {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        BigInteger a=in.readBigInteger();
        BigInteger b = in.readBigInteger();
        int n = in.nextInt();
        int t = 2;
        HashMap<BigInteger, BigInteger> map = new HashMap<>();
        BigInteger num = BigInteger.ZERO;
        while (t++ < n ) {
            if (map.get(b) == null) map.put(b, b.multiply(b));
            num = map.get(b).add(a);
            //System.out.println("num = " + num);

            a=b;
            b=num;
        }
        out.println(b);
    }
}
