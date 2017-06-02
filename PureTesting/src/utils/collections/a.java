package utils.collections;

import utils.InputReader;
import utils.OutputWriter;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Surya Vamsi on 23-Mar-15.
 */
public class a {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        out.print("c");out.print("d");
        System.out.println("ke");
        out.close();
    }
}
