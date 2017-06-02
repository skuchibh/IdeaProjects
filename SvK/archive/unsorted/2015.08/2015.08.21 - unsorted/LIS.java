package created;

import sv.misc.ArrayUtils;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class LIS {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] arr = IOUtils.readIntArray(in, n);
        int[] lis = new int[n];
        Arrays.fill(lis,1);int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && lis[i]<lis[j]+1){
                    lis[i]=lis[j]+1;max=Math.max(max,lis[i]);
                }
            }
        }out.println(max);

    }
}
