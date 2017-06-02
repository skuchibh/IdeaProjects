package created;

import utils.InputReader;
import utils.OutputWriter;

public class GSS1 {
    int []sum;
    int []max;
    int []sequence;
    int []maxprefix;
    int []maxsuffix;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();sum=new int[n+1];max=new int[n<<2];maxsuffix=new int[n<<2];
        maxprefix=new int[n<<2];sequence=new int[n+1];
        for(int i=1;i<=n;i++){sequence[i]=in.nextInt();sum[i]=sum[i-1]+sequence[i];}
        build(1,n,1);int q=in.nextInt();while(q-->0)
        out.println(query(in.nextInt(),in.nextInt(),1,n,1,new int[3]));
    }
    void build(int left,int right,int index){
        if(left==right){
            max[index]=maxprefix[index]=maxsuffix[index]=sequence[left];return;
        }
        int mid=left+right;mid>>=1;
        int leftchild=2*index;
        int rightchild=leftchild+1;
        build(left,mid,leftchild);build(mid+1,right,rightchild);
        max[index]=max(max[leftchild],max[rightchild]);
        max[index]=max(max[index],maxsuffix[leftchild]+maxprefix[rightchild]);
        maxprefix[index]=max(maxprefix[leftchild],sum[mid]-sum[left-1]+maxprefix[rightchild]);
        maxsuffix[index]=max(maxsuffix[rightchild],sum[right]-sum[mid]+maxsuffix[leftchild]);
    }
    int query(int qleft,int qright,int left,int right,int index,int []info){
        if(qleft<=left && qright>=right){
            info[0]=maxprefix[index];
            info[1]=maxsuffix[index];
            info[2]=sum[right]-sum[left-1];
            return max[index];
        }
        int mid=left+right;mid>>=1;int leftchild=index<<1;int rightchild=leftchild+1;
        if(qleft>mid)return query(qleft,qright,mid+1,right,rightchild,info);
        if(qright<=mid)return query(qleft,qright,left,mid,leftchild,info);
        int []info1=new int[3];int []info2=new int[3];
        int maxLeft=query(qleft,qright,left,mid,leftchild,info1);
        int maxRight=query(qleft,qright,mid+1,right,rightchild,info2);
        int max=max(maxLeft,maxRight);
        max=max(max,info1[1]+info2[0]);
        info[0]=max(info1[0],info1[2]+info2[0]);
        info[1]=max(info2[1],info2[2]+info1[1]);
        info[2]=info1[2]+info2[2];
        return max;
    }
    int max(int a,int b){return Math.max(a,b);}
}
