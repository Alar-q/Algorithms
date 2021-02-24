package acmp;

import java.util.Scanner;

public class Acmp0009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int  sum = 0, mult = 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, minInd = 0, maxInd = n, a;
        for(int i=0; i<n; i++){
            a = in.nextInt();
            arr[i] = a;
            if(a>0){
                sum+=a;
            }
            if(a<min) {
                min = a;
                minInd = i;
            }
            if(a>max){
                max = a;
                maxInd = i;
            }
        }
        for(int i=Math.min(minInd, maxInd)+1; i<Math.max(minInd, maxInd); i++){
            mult*=arr[i];
        }
        System.out.println(sum + " " + mult);
    }
}
