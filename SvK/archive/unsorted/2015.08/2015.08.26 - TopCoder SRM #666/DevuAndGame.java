package created;

public class DevuAndGame {
    public String canWin(int[] nextLevel) {
        int x = 0;boolean res=false;
        boolean[] vis = new boolean[nextLevel.length];
        while (true) {
            if (vis[x]) {res=false;break;}
            vis[x] = true;
            if (nextLevel[x] == -1){ res=true;break;}
            int xx = nextLevel[x];

            if (xx == -1) {res=true;break;}
            x = xx;
        }
        if(res)return "Win";
        else return "Lose";

    }
}
