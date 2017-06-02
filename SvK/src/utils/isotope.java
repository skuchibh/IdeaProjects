package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Surya Vamsi on 19-Jul-15.
 */
public class isotope {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int []a=new int[n];int[]dp=new int[n+1];
        String []temp=br.readLine().split(" ");
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(temp[i]);
        }
        int energy[]=new int[n];
        for(int i=0;i<a.length-1;i++){
            int x=a[i];int y=a[i+1];energy[i]=a[i]*a[i+1];
            dp[i]=a[i]*a[i+1];dp[i]=dp[i]%199;
        }
        for(int i=0;i<a.length-1;i++){
            int x=a[i];int y=a[i+1];energy[i]=a[i]*a[i+1];
            dp[i]=a[i]*a[i+1];dp[i]=dp[i]%199;
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(energy));
    }
}
