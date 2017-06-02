package created;

import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class spoj {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();int l=0,r=0;long ans=0;long tot=0;long lsum=0,rsum=0;
        ArrayList<Tree>left=new ArrayList<>();
        ArrayList<Tree>right=new ArrayList<>();
        while (n-->0){
            int xx=in.nextInt();int f=in.nextInt();tot+=f;
            if(xx<0){left.add(new Tree(xx,f));lsum+=f;}
            else {
                right.add(new Tree(xx, f));
            rsum+=f;}       }
        Collections.sort(left, new Comparator<Tree>() {
            @Override
            public int compare(Tree o1, Tree o2) {
                return o2.x-o1.x;
            }
        });Collections.sort(right, new Comparator<Tree>() {
            @Override
            public int compare(Tree o1, Tree o2) {
                return o1.x-o2.x;
            }
        });

        int dif=Math.abs(right.size()-left.size());if(dif==0){out.println(tot);return;}
        if(right.size()==0)dif=0;if(left.size()==0)dif=0;
        if(right.size()>left.size()){dif=left.size()+1;
            ans+=lsum;for(int i=0;i<dif;i++)ans+=right.get(i).fruit;
        }
        else {dif=right.size()+1;
            ans+=rsum;for(int i=0;i<dif;i++)ans+=left.get(i).fruit;
        }
        out.println(ans);
    }
    static class Tree{
        int x;int fruit;

        public Tree(int x, int fruit) {
            this.x = x;
            this.fruit = fruit;
        }
    }
}
