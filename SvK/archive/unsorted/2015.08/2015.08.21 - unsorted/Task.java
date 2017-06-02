package created;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;
import sv.misc.ArrayUtils;
import sv.my.FloydWarshall;
import sv.my.graph.UnionFind;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.*;

public class Task {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int [][]dp=new int[n+1][m+1];
        int []a=IOUtils.readIntArray(in,n);
        int []b=IOUtils.readIntArray(in,m);
        ArrayUtils.fill(dp, 0);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i+1][j+1]=a[i]==b[j]?dp[i][j]+1:Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        //out.println(dp[n][m]);
//StringBuffer sb=new StringBuffer();
        int i=n;int j=m;
        ArrayList<Integer>list=new ArrayList<>();
        while(i>0 && j>0){
            if(dp[i-1][j]==dp[i][j])i--;
            else if(dp[i][j-1]==dp[i][j])j--;
            else {
                try {
                    if(i>0)
                    list.add(a[i-1]);
                    else list.add(b[j-1]);
                    i--;j--;
                }
                catch (Exception e){
                    System.out.println(i-1+"OKOKOK");
                }

            }
        }
        Collections.reverse(list);
        for(Integer x:list){
            out.print(x+" ");
        }
    }
}
