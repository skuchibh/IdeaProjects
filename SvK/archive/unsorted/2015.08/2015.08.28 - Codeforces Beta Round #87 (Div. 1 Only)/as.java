package created;

import utils.InputReader;
import utils.OutputWriter;

import java.math.BigInteger;

public class as {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        BigInteger x = in.readBigInteger();
        BigInteger y = in.readBigInteger();
        x=x.subtract(BigInteger.ONE);
        BigInteger max = x.multiply((x.add(BigInteger.ONE)));
        max = max.divide(new BigInteger("2"));
        BigInteger min = y.multiply((y.add(BigInteger.ONE)));
        min = min.divide(new BigInteger("2"));
        out.println(min.subtract(max));
    }
}
