package created;

import utils.InputReader;
import utils.OutputWriter;

public class codevitaex2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String x=in.readString();
        char []a=x.toCharArray();
        int []arr=new int[a.length];int index=0;
        for(int i=0;i<a.length;i++){
            //if(i==2) System.out.println(a[i]-'0');
            if(i==a.length-1){
                if(a[i]=='X'){
                    arr[i]=10;
                }else if(a[i]-'0'>=0 && a[i]-'0'<=9)arr[i]=a[i]-'0';
                else{ System.out.println("INVALID");return;}
            }
            else if(a[i]!='?' &&(a[i]-'0'>=0 && a[i]-'0'<=9) ){
            arr[i]=a[i]-'0';
            }
            else if(a[i]=='?') {arr[i]=0;index=10-i;}
            else {
                System.out.println("INVALID");return;}
        }
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=arr[i]*(10-i);
        }
        System.out.println(sum);
            for(int i=1;i<=9;i++){
                int xx=sum+(index*i);
                if(xx%11==0){out.println(i);break;}
                if(i==9)out.println("NO SOLUTION POSSIBLE");
            }
            out.println(arr);
    }
}
