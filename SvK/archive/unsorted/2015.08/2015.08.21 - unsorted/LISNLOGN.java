package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class LISNLOGN {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] arr = IOUtils.readIntArray(in, n);
        int len=arr.length;
        out.println(LIS(arr,len));
    }
    static int LIS(int []arr,int len){
        if(len==1)return 1;
        int []tailTable=new int[len];
        int g=0;
        tailTable[0]=arr[0];
        g=1;
        for(int i=1;i<len;i++){
            //System.out.println("arr[i] = " + arr[i]);
            //if(arr[i]<tailTable[0])tailTable[0]=arr[i];
            if(arr[i]>tailTable[g-1])tailTable[g++]=arr[i];
            else {
             //   System.out.println("(g-1) = " + (g-1));
                tailTable[bsearch(tailTable,-1,g-1,arr[i])]=arr[i];
            }
            //System.out.println(Arrays.toString(tailTable));
        }return g;
    }
    static int bsearch(int []tailTable,int lo,int hi,int key){
        int mid;
        while(hi-lo>1){
            mid=lo+((hi-lo)/2);
            //System.out.println("mid = " + mid);
            //if(mid==0)break;
            if(tailTable[mid]>=key)hi=mid;
            else lo=mid;
        }
        return hi;
    }
}
