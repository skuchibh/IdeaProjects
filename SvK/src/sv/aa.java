package sv;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Surya Vamsi on 21-Aug-15.
 */
public class aa {
    ArrayList<Integer> list = new ArrayList<>();
    static int[] b;
    static char[] p, t;
    static int m, n;
    static char[] showmatches;
    static String matches;
    static BufferedReader in;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        try {
            while (true) {
                int n = Integer.parseInt(in.readLine());
                p = in.readLine().toCharArray();
                m = p.length;
                b = new int[m + 1];
                preProcess();
                kmpSearch(in, out);
                out.println();
            }
        } catch (Exception e) {

        }
        out.close();

    }

    static void kmpSearch(BufferedReader in, PrintWriter out) throws IOException {
        int i = 0;
        int j = 0;
        char ch;
        //System.out.println(Arrays.toString(b));
        while ((ch = (char) in.read()) != '\n') {
            while (j >= 0 && ch != p[j]) {
                //System.out.println("OK"+" "+ch);
                j = b[j];
            }
            i++;
            j++;
            if (j == m) {
                out.println(i - m);
                j = b[j];
            }
        }
    }

    static void preProcess() {
        int i = 0;
        int j = -1;
        b[i] = j;
        while (i < m) {
            while (j >= 0 && p[i] != p[j]) {
                j = b[j];
            }
            i++;
            j++;
            b[i] = j;
        }
    }

}
