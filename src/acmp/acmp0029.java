package acmp;

import java.util.Scanner;

public class acmp0029 {
    public static void main(String[] args) {
        acmp0029 m = new acmp0029();
        m.solve();
    }
    private void solve() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        if(n<2){
            System.out.println(0);;
        }else {
            long[] hs = new long[n];
            long[] best = new long[n];
            hs[0] = in.nextLong();
            hs[1] = in.nextLong();
            best[0] = 0l; //энергия чтобы встать на 1-платформа
            best[1] = for1(hs[0], hs[1]); //до 2-платформы можно добраться только через первую

            for (int i = 2; i < n; i++) {
                hs[i] = in.nextLong();
                best[i] = Math.min(for1(hs[i], hs[i - 1]) + best[i - 1], for2(hs[i], hs[i - 2]) + best[i - 2]);
            }

            System.out.println(best[n - 1]);
        }

    }
    private long for1(long h1, long h2){
        return Math.abs(h1-h2);
    }
    private long for2(long h1, long h2){
        return Math.abs(3 * Math.abs(h1-h2));
    }
}
