package created;

public class BearCheats {
    public String eyesight(int A, int B) {

        char []s1=(""+A).toCharArray();
        char []s2=(""+B).toCharArray();
        if(s1.length!=s2.length)return "glasses";
        boolean res=false;boolean res2=false;
        for(int i=0;i<s1.length;i++){
            if(s1[i]!=s2[i]){
                if(!res)
                res=true;
                else if(res){res2=true;return "glasses";};
            }
        }
        return "happy";


    }
}
