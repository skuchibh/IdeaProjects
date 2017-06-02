package created;

import sv.SegmentTreeLazy.SegmentTree;
import utils.IOUtils;
import utils.InputReader;
import utils.OutputWriter;

public class seg {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = IOUtils.readIntArray(in, n);
        int q = in.nextInt();
        SegmentTree st=new SegmentTree(a);

        while (q-- > 0) {
            int qn=in.nextInt();
            if(qn==0){
                int index=in.nextInt()-1;int val=in.nextInt();
                st.updateRange(index,index,val);
            }
            else if(qn==1){
                int from=in.nextInt();int to=in.nextInt();from--;to--;
                out.println(st.query(from,to));
            }
            else {
                int from=in.nextInt();int to=in.nextInt();from--;to--;
                int len=to-from+1;
                out.println(len-st.query(from,to));
            }
        }
    }
}
