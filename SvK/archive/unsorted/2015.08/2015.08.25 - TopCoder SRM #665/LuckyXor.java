package created;

public class LuckyXor {
    public int construct(int a) {

        for (int i = a + 1; i <= 100; i++) {
            if (f(a ^ i)) {
                return i;
            }
        }
        return -1;
    }

    static boolean f(int a) {
        String x = "" + a;
        int len = x.length();
        for(int i=0;i<len;i++){
            if(x.charAt(i)!='4' && x.charAt(i)!='7'){
                return false;
            }
        }
        return true;
    }
}
