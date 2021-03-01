import java.util.*;

public class Main {
    static int a;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i]=in.nextInt();

        int res = res_minimax(arr, true, 0, 0, n-1);
        System.out.println(res == 0 ? 0 : (res > 0 ? 1 : 2));
    }

    private static int res_minimax(int[] arr, boolean first, int res, int leftBorder, int rightBorder){
        if(rightBorder-leftBorder==0) {
            a = res + arr[leftBorder] * plusMinus(first);
        }
        else {
            int outcome1 = res_minimax(arr, !first, res + arr[leftBorder] * plusMinus(first), leftBorder + 1, rightBorder),
                    outcome2 = res_minimax(arr, !first, res + arr[rightBorder] * plusMinus(first), leftBorder, rightBorder - 1);
            if (first) {
                a = Math.max(outcome1, outcome2);
            } else {
                a = Math.min(outcome1, outcome2);
            }
        }
        return a;
    }
    private static int plusMinus(boolean first){
        if(first)
            return 1;
        else  return -1;
    }

}