package created;

import sv.misc.ArrayUtils;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;

public class CFB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();
        Bit []a= new Bit[1000005];for(int i=0;i<1000005;i++)a[i]=new Bit();
        for(int i=0;i<1000005;i++){a[i].start=-1;a[i].end=-1;}
        int []arr=new int[1000005];
        for(int i=0;i<n;i++){
            int x=in.nextInt();
            arr[x]++;
            if(a[x].start==-1)a[x].start=i;
            a[x].end=i;
            //System.out.println("a[1].start = " + a[i].start);
            //System.out.println("a[1].end = " + a[i].end);
        }//out.println(arr);
        ArrayList<Integer>min=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<1000005;i++){
            if(arr[i]>max){
            max=arr[i];min=new ArrayList<>();min.add(i);}
            else if(arr[i]==max)min.add(i);
        }
        int mm=Integer.MAX_VALUE;
        for(int i=0;i<min.size();i++){
            int st=a[min.get(i)].start;int en=a[min.get(i)].end;
            if(en-st<mm){
            mm=Math.abs(en-st);
            max=min.get(i);
            }}
        out.println((a[max].start+1)+" "+(a[max].end+1));
    }
    static class Bit{
        int start;int end;

        public Bit(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Bit() {
        }
    }
}
