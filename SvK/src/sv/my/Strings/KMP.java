package sv.my.Strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Surya Vamsi on 02-Sep-15.
 */
public class KMP {
    ArrayList<Integer>list=new ArrayList<>();
    private int[] b;
    private char[] p, t;
    private int m, n;
    private char[] showmatches;
    private String matches;

    private void preProcess(){
        int i=0;int j=-1;
        b[i]=j;
        while(i<m){
            while(j>=0 && p[i]!=p[j]){
                j=b[j];
            }
            i++;j++;
            b[i]=j;
        }
    }
    private void kmpSearch(){
        int i=0;int j=0;
        while(i<n){
            while(j>=0 && t[i]!=p[j]){
                j=b[j];
            }
            i++;j++;
            if(j==m){
                report(i-m);
                j=b[j];
            }
        }
    }
    private void report(int i){
        matches+=i+" ";
        list.add(i);
        showmatches[i]='^';
    }
    public void search(String tt,String pp){
        setText(tt);setPattern(pp);
        kmpSearch();
    }
    private void setText(String tt){
        n=tt.length();t=tt.toCharArray();
        initMatches();
    }
    private void initMatches(){
        matches="";
        showmatches=new char[n];
        for(int i=0;i<n;i++)showmatches[i]=' ';
    }
    private void setPattern(String pp){
        m=pp.length();
        p=pp.toCharArray();
        b=new int[m+1];
        preProcess();
        //System.out.println(Arrays.toString(b));
    }
    public ArrayList<Integer>getIndexes(){return list;}
    public String getMatches(){
        return matches;
    }
}
