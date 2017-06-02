import utils.InputReader;
import utils.OutputWriter;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;


public class PureTesting {

    static char[] xx = new char[1];

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        utils.InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);int a=1;
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.out.println(Arrays.toString(i));

        out.close();
    }

}
