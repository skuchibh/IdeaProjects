package sv;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by rammohan on 27-aug-15.
 */
public class isotope {
    static List<Set<Integer>> nodes;
    static boolean[] vis;
    static int end;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        solve(in, out);
        //  alternate( ip, ll, ul);
        //  consecutive( ip, ll, ul);
        //  wildcard( ip,ll,ul);
        out.close();
    }

    static void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        int ll = in.nextInt();
        int ul = in.nextInt();
        outer:
        while (t-- > 0) {

            String ip = in.readLine();
            char[] ip1 = ip.toCharArray();
            if (ip1[0] == 'A')
                alternate(ip, ll, ul);
            else if (ip1[0] == 'C')
                consecutive(ip, ll, ul);
            else
                wildcard(ip, ll, ul);

        }
    }


    static void alternate(String ip, int ll, int ul) {
        int count = 0;
        char p = ip.charAt(1);
        outer:
        for (int j = 100; j <= ul; j++) {
            String s = "" + j;
            int n = s.length();
            for (int k = 0; k + 2 <= n-1; k++) {
                if (s.charAt(k) == s.charAt(k + 2) && s.charAt(k) == p) {
                    count++;
                    continue outer;
                }

            }
        }

        System.out.println(count);
    }


    static void consecutive(String ip, int ll, int ul) {
        // System.out.println("okk");
        int count = 0;
        char p = ip.charAt(2);
        //  System.out.println("p value="+p);
        for (int j = 20; j < ul; j++) {
            int ld = j % 10;
            // System.out.println("ld value="+ld);
            if (p == ld + '0') {
                String s = Integer.toString(j);
                int n = s.length();
                //  System.out.println("n value="+n);
                for (int k = 0; k <= n; k++) {
                    if (s.charAt(k) == s.charAt(k + 1)) {
                        count++;
                        break;
                    } else
                        break;
                }
            } else {
                continue;
            }
        }
        System.out.println(count);
    }

    static void wildcard(String ip, int ll, int ul) {
        int count = 0;
        int n = ip.length();
        String xx="1";int ref=Integer.parseInt(xx);
        int end=ref+1;String ref2=""+end;
        for(int i=0;i<n-1;i++){xx=xx+"0";ref2=ref2+"0";}
        int start=Integer.parseInt(xx);
        end=Integer.parseInt(ref2);
        int min=Math.min(end, ul);
        System.out.println(start+" "+min+" "+end);
        char[] ip2 = ip.toCharArray();
        count=min-start;
        if(count==0){ System.out.println("1");return;}
        // System.out.println("count="+count);

        System.out.println(count);
    }

    static class InputReader {
        private boolean finished = false;

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int peek() {
            if (numChars == -1)
                return -1;
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c))
                    res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r')
                    buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0)
                s = readLine0();
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines)
                return readLine();
            else
                return readLine0();
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(readString());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public char readCharacter() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public boolean isExhausted() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1)
                read();
            return value == -1;
        }

        public String next() {
            return readString();
        }

        public SpaceCharFilter getFilter() {
            return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}