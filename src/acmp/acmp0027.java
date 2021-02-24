package acmp;

import java.util.Scanner;

public class acmp0027 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cols = in.nextInt(), rows = in.nextInt(), n = in.nextInt();
        int[][] mat = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            int x0 = in.nextInt(), y0 = in.nextInt(), x1 = in.nextInt(), y1 = in.nextInt();
            for (int y = y0; y < y1; y++) {
                for (int x = x0; x < x1; x++) {
                    mat[y][x] = 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}
