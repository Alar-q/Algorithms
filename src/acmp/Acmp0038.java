package acmp;

import java.util.Scanner;

public class Acmp0038 {

    public static void main(String[] args) {
        Acmp0038 m = new Acmp0038();
        m.solve();
    }

    private class Dyn {
        public int score;
        public boolean ready = false;
    }

    private Dyn[][] dyn;

    private void solve() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        dyn = new Dyn[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dyn[i][j] = new Dyn();
            }
        }
        int res = res_minimax(arr, true, 0, 0, n - 1);
        System.out.println(res == 0 ? 0 : (res > 0 ? 1 : 2));
    }

    private int res_minimax(int[] arr, boolean first, int res, int leftBorder, int rightBorder) {
        Dyn d = dyn[leftBorder][rightBorder];

        if (d.ready) {
            return res + d.score;
        } else if (rightBorder == leftBorder) {
            return res + arr[leftBorder] * plusMinus(first);
        } else {
            int outcomeL = res_minimax(arr, !first, res + arr[leftBorder] * plusMinus(first), leftBorder + 1, rightBorder); // Сначала берем слева
            int outcomeR = res_minimax(arr, !first, res + arr[rightBorder] * plusMinus(first), leftBorder, rightBorder - 1); // Потом справа

            int a;

            if (first)
                a = Math.max(outcomeL, outcomeR);
            else
                a = Math.min(outcomeL, outcomeR);

            d.score = a - res;
            d.ready = true;

            return a;
        }
    }

    private int plusMinus(boolean first) {
        if (first)
            return 1;
        else return -1;
    }


}
