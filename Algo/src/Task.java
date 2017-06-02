import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Task {
    static double div;
    static long count;

    public void solve(InputReader in, OutputWriter out) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));


        int n=Integer.valueOf(br.readLine());
        char[]s1=br.readLine().toCharArray();
        char[]s2=br.readLine().toCharArray();
        int res=0;
        HashMap<Character,HashMap<Character,Integer>>someOcurence=new HashMap<Character, HashMap<Character, Integer>>();
        for(int i=0;i<n;i++){
            if(s1[i]!=s2[i]){
                res++;
                if(!someOcurence.containsKey(s1[i])){
                    someOcurence.put(s1[i],new HashMap<Character, Integer>());
                }
                someOcurence.get(s1[i]).put(s2[i],i);//System.out.println(someOcurence.get(s1[i]).get(s2[i]));
            }

        }

        boolean flag=false;
        int x=-1,y=-1;
        for(int i=0;i<n;i++){
            if(s1[i]!=s2[i]){
                if(someOcurence.containsKey(s2[i])){
                    if(someOcurence.get(s2[i]).containsKey(s1[i])){
                        res-=2;
                        flag=true;
                        x=i+1;y=someOcurence.get(s2[i]).get(s1[i])+1;
                        break;

                    }
                }
            }

        }
        if(!flag){
            for(int i=0;i<n;i++){
                if(s1[i]za!=s2[i]){
                    if(someOcurence.containsKey(s2[i])){
                        res-=1;

                        x=i+1;
                        for(char c: someOcurence.get(s2[i]).keySet())
                        y=someOcurence.get(s2[i]).get(c)+1;
                        break;
                    }
                    break;
                }
            }


        }
        System.out.println(res);
        System.out.println(x+" "+y);

    }


}





