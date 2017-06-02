package created;

import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

import java.util.*;

public class Task {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        String []arr= IOUtils.readStringArray(in,n);
        System.out.println(Arrays.toString(arr));
        HashSet<String>set=new HashSet<>();
        for(String x:arr)set.add(x);
        int size=set.size();
        String []temp=set.toArray(new String[size]);
        System.out.println(Arrays.toString(temp));
        int []f=new int[size];
        for(int i=0;i<n;i++){
            for(int j=0;j<size;j++){
                if(arr[i].compareTo(temp[j])==0){
                    f[j]++;break;
                }
            }
        }
        ArrayList<Pair>list=new ArrayList<>();
        for(int i=0;i<size;i++){
            list.add(new Pair(f[i],temp[i]));
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair x, Pair y) {
                int s1=x.getSize();int s2=y.getSize();
                if(s1>s2)return -1;
                else if(s1<s2)return 1;
                else {
                    String n1=x.getName();String n2=y.getName();
                    if(n1.compareTo(n2)<0)return 1;
                    else return -1;
                }
            }
        });
        for(Pair x:list)out.println(x.getName()+" "+x.getSize());

    }
    static class Pair{
        private int size;private String name;

        public Pair(int size, String name) {
            this.size = size;
            this.name = name;
        }
        public int getSize(){return this.size;}public String getName(){return this.name;}
        public void setSize(int size){this.size=size;}public void setName(String name){this.name=name;}
    }
}
