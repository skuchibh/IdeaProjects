package created;

import utils.InputReader;
import utils.OutputWriter;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Afirst {
    static double[] speeds;
    static double[] consumption;
    static double initFuel;
    static int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        speeds = new double[n];
        consumption = new double[n];
        for (int i = 0; i < n; i++) speeds[i] = in.readDouble();
        for (int i = 0; i < n; i++) consumption[i] = in.readDouble();
        initFuel = in.readDouble();
        out.println(calc());
    }

    static String calc() {
        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            double con=consumption[i];
            double sp=speeds[i];
            if(initFuel/con * sp >ans){
                ans=initFuel/con * sp;
            }
        }
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.FLOOR);
        String num = df.format(ans);
        return num;

    }
}
