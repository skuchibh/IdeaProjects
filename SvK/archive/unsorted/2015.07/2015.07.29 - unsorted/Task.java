package created;

import sv.collections.UnionFind.QuickFind;
import sv.collections.sequence.Array;
import sv.misc.ArrayUtils;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;

public class Task {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n=in.nextInt();
        int nfolders=in.nextInt();
        int []folders= IOUtils.readIntArray(in,nfolders);
        out.println(getMostWork(folders,n));
    }

    static int getMostWork(int []folders,int n){
        int lo=ArrayUtils.maxElement(folders);
        int hi=0;for(int x:folders)hi+=x;

        while(lo<hi){
            int x=lo+(hi-lo)/2;
            int required=1,current_load=0;
            for(int i=0;i<folders.length;i++){
                if(current_load+folders[i]<=x){
                    current_load+=folders[i];
                }
                else {
                    required++;current_load=folders[i];
                }
            }
            if(required<=n)hi=x;
            else lo=x+1;
        }return lo;
    }

}
