import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ll solver = new ll();
        solver.solve(1, in, out);
        out.close();
    }

    static class ll {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            LinkedList list = new LinkedList();
        }

    }

    static class LinkedList {
    }

    static class InputReader {
        private InputStream stream;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(PrintStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

    }
}

