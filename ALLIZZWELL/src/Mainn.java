import java.io.IOException;

/**
 * Created by Surya Vamsi on 15-Feb-15.
 */
public class Mainn {

    static char[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r, c, kk;
    static boolean b, bb;
    private static int counta, countl, counti, countz, countw, counte;


    public static void main(String[] args) throws IOException {
        System.out.println(gcd(900000000000000009l,900000000000000010l  ));

    }
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }


}