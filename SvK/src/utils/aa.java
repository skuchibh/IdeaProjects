package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Surya Vamsi on 19-Jul-15.
 */
public class aa {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            ArrayList<Integer> P=new ArrayList<>();
            ArrayList<Integer>M=new ArrayList<>();
            TreeSet<Integer> disjointset=new TreeSet<>();

            for(int i=0;i<2;i++){

                String []temp=br.readLine().split(" ");
                if(i==0)
                    for(String x:temp){P.add(Integer.parseInt(x));disjointset.add(Integer.parseInt(x));}
                else{
                    for(String x:temp){M.add(Integer.parseInt(x));disjointset.add(Integer.parseInt(x));}
                }
            }
            Collections.sort(P);Collections.sort(M);
            ArrayList<Integer>combined=new ArrayList<>();
            ArrayList<Integer>only=new ArrayList<>();
            int pmarker=0,mmarker=0;
            for(int i=0;i<P.size();i++){
                int phy=P.get(i);
                if(M.contains(phy))combined.add(phy);
                else only.add(phy);
            }
            // System.System.System.out.println(only);
            Iterator it=disjointset.iterator();
            for(int i=0;i<disjointset.size();i++){
                System.out.print(it.next()+" ");
            }
            System.out.println();
            if(!combined.isEmpty()){
                for(Integer x:combined)System.out.print(x+" ");
            }else System.out.print("Empty List");
            System.out.println();
            if(!only.isEmpty()){
                for(Integer x:only)System.out.print(x+" ");
            }else System.out.print("Empty List");
            System.out.println();
        }
    }
}
