package sv;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Surya Vamsi on 08-Aug-15.
 */
public class encrypt {
    public static void main(String[] args) throws IOException {
        int n = 8;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        out.println("kFryuqymtb\n" +
                "qjncJncquuqpf\n" +
                "wmActYymJncquuqpf\n" +
                "pmkrclkquyuqCncquuqpf\n" +
                "pgcrryEncquuqpf\n" +
                "pmkrcLryuqymtb\n" +
                "vgdzcpryuqymtb\n" +
                "zmhncquuqpf");
        out.close();
    }

    static String EncryptString(String s, int passwordlength, String password) {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        sb.append(password);
        char[] arr = sb.toString().toCharArray();
        //System.out.println(sb.toString());
        ArrayList<Integer> indexes = fibo(passwordlength);
        for (int i = 0; i < indexes.size(); i++) {
            int index = indexes.get(i);
            for (int j = 0; j < arr.length; j++) {
                if (j % 2 == 0) {//odd
                    //System.out.println("HERE UP");
                    int integer = (int) arr[j];
                    //System.out.println("arr[j] = " + arr[j]);
                    //System.out.println("integer1 = " + integer);
                    if (integer >= 65 && integer <= 90) {
                        if (integer + index <= 90) integer += index;
                        else {
                            int diff = 90 - integer;
                            integer = 65 + index - diff - 1;
                        }
                        //System.out.println(new String(arr));
                    } else if (integer >= 97 && integer <= 122) {
                        if (integer + index <= 122) integer += index;
                        else {
                            int diff = 122 - integer;
                            integer = 97 + index - diff - 1;
                        }
                    }
                    arr[j] = (char) integer;
                    //System.out.println(new String(arr));
                } else {
                    //System.out.println("HERE DOWN");
                    int integer = (int) arr[j];
                    //System.out.println("arr[j] = " + arr[j]+" "+index);
                    if (integer >= 65 && integer <= 90) {
                        if (integer - index >= 65) integer -= index;
                        else {
                            int diff = integer - 65;
                            integer = 90 - (index - diff) + 1;
                            //    System.out.println(new String(arr));
                        }

                    } else if (integer >= 97 && integer <= 122) {
                        if (integer - index >= 97) integer -= index;
                        else {
                            int diff = integer - 97;
                            integer = 123 - (index) + diff;
                        }

                    }
                    arr[j] = (char) integer;
                    //System.out.println(new String(arr));

                }
            }
            //System.out.println("FINAL   " + new String(arr));

        }
        return new String(arr);

    }

    static ArrayList<Integer> fibo(int n) {
        int count = 0;
        int start = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        if (n <= 2) return list;
        int x1 = 1, x2 = 1, fib = 1;
        for (int i = 2; i < n; i++) {
            fib = x1 + x2;
            list.add(fib);
            x1 = x2;
            x2 = fib;
        }
        return list;
    }
}
