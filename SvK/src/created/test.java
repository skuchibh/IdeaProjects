package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        A[] arr = new A[3];
        arr[0] = new A("A");
        arr[1] = new A("B");
        arr[2] = new A("C");
        Arrays.sort(arr, (A a1, A a2) -> a1.name.compareTo(a2.name));
        Arrays.sort(arr, (a1, a2) -> a2.name.compareTo(a1.name));
        System.out.println(Arrays.toString(arr));
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(4);


    }

    static class A {
        String name;

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public A(String name) {
            this.name = name;
        }


    }
}
