package arrays2d;

import java.io.PrintWriter;
import java.util.Scanner;

public class Snake {
    public static void main(String[] args){
        solver(new Scanner(System.in), new PrintWriter(System.out));
    }

    private static void solver(Scanner sc, PrintWriter pw) {
        int[][] arr = new int[12][12];
        for (int i = 0, n=1; i < arr.length; i++) {
            if(i%2!=0) {
                for (int j = 0; j <= i; j++, n++) {
                    arr[i - j][j] = n;
                }
            }else{
                for (int j = i; j >= 0; j--, n++) {
                    arr[i - j][j] = n;
                }
            }
        }

        for(int i = arr.length-1, n= arr.length*arr[0].length; i>0; i--)
            if(i%2!=0) {//как то эту штуку надо понять, а так на четных разиерах все ок
                for (int j = arr.length - 1; j >= i; j--, n--)
                    arr[j][i + (arr.length - 1 - j)] = n;
            }else
                for (int j = arr.length - 1; j >= i; j--, n--)
                    arr[i + (arr.length - 1 - j)][j] = n;

        for(int i=0; i<arr.length; i++) {
            for (int j = 0; j < arr.length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }

    }
}
