package created;

import sv.misc.ArrayUtils;
import sv.misc.MiscUtils;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = IOUtils.readIntArray(in, n);
        for (int i = 0; i < n; i++) {
            while(a[i]%2==0 || a[i]%3==0){
                if(a[i]%2==0)a[i]/=2;
                if(a[i]%3==0)a[i]/=3;
            }
        }
        //System.out.println(Arrays.toString(a));
        int x=a[0];
        for(int i=1;i<n;i++){
            if(a[i]!=x){out.println("No");return;}
        }
        out.println("Yes");


    }

}
