import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class Codeforces508B {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Task solver = new Task();
        solver.solve(in,out);
        out.close();
    }
}


