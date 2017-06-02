import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.valueOf(in.readLine());
        ArrayList<Integer> a=new ArrayList<Integer>();
        String [] temp=in.readLine().split(" ");
        for(int i=0;i<n;i++){
            a.add(Integer.valueOf(temp[i]));
        }
        int t=Integer.valueOf(in.readLine());
        while(t-->0){
            String []temp2=in.readLine().split(" ");
            int x=Integer.valueOf(temp2[0]);int y=Integer.valueOf(temp2[1]);int k=Integer.valueOf(temp2[2]);
            for(int i=x;i<=y;i++){
                a.set(i-1,a.get(i-1)+k);
            }
        }
        for(int i=0;i<n;i++) System.out.println(a.get(i));
    }
}