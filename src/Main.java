import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.solve();
    }

    private class Dyn{
        public int score;
        public boolean ready;
        public Dyn(){
            ready = false;
        }
    }

    private Dyn[][] dyn;

    private void solve(){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        dyn = new Dyn[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dyn[i][j] = new Dyn();
            }
        }

        int res = res_minimax(arr, true, 0, 0, n-1);
        System.out.println("res = " + (res == 0 ? 0 : (res > 0 ? 1 : 2)));


        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dyn[i][j].score);
            }
            System.out.println();
        }


    }

    private int res_minimax(int[] arr, boolean first, int res, int leftBorder, int rightBorder){

        //if(dyn[leftBorder][rightBorder].ready) { System.out.println("l="+leftBorder +" r="+rightBorder + " score="+dyn[leftBorder][rightBorder].score);return dyn[leftBorder][rightBorder].score; }else
            if(rightBorder-leftBorder==0) {
            return res + arr[leftBorder] * plusMinus(first);
        }
        else {
                //System.out.println("first = " + first);
                //System.out.println("outcome1: " + " leftBorder + 1 = " + (leftBorder + 1) + "; rightBorder = " + (rightBorder+1) + "; " + Arrays.toString(Arrays.copyOfRange(arr, leftBorder + 1, rightBorder+1)));
                //System.out.println("outcome2: " + " leftBorder = " + (leftBorder) + "; rightBorder - 1 = " + (rightBorder) + "; " + Arrays.toString(Arrays.copyOfRange(arr, leftBorder, rightBorder)));
                int outcome1 = res_minimax(arr, !first, res + arr[leftBorder] * plusMinus(first), leftBorder + 1, rightBorder); // Сначала берем слева
                int outcome2 = res_minimax(arr, !first, res + arr[rightBorder] * plusMinus(first), leftBorder, rightBorder - 1); // Потом справа

                int a;

                if (first)
                    a = Math.max(outcome1, outcome2);
                else
                    a = Math.min(outcome1, outcome2);

                if(leftBorder == 2 && rightBorder == 8){
                    System.out.println("l;"+a);
                }
                dyn[leftBorder][rightBorder].score = a;
                dyn[leftBorder][rightBorder].ready = true;

                return a;
            }
    }

    private int plusMinus(boolean first){
        if(first)
            return 1;
        else  return -1;
    }

}