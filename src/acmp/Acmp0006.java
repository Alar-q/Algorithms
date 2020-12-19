package acmp;

import java.io.PrintWriter;
import java.util.Scanner;

public class Acmp0006 {
    public static void main(String[] args) {
        new Acmp0006().run();
    }

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        String move = in.nextLine();
        String[] s = move.split("-");

        if (s.length != 2) {
            out.println("ERROR");
            return;
        }

        char let1 = s[0].charAt(0);
        int letNum1 = -1;
        int num1;

        char let2 = s[1].charAt(0);
        int letNum2 = -1;
        int num2;

        try {
            num1 = s[0].charAt(1) - '0';
            num2 = s[1].charAt(1) - '0';
        } catch (RuntimeException e) {
            out.println("ERROR");
            return;
        }


        switch (let1) {
            case 'A':
                letNum1 = 1;
                break;
            case 'B':
                letNum1 = 2;
                break;
            case 'C':
                letNum1 = 3;
                break;
            case 'D':
                letNum1 = 4;
                break;
            case 'E':
                letNum1 = 5;
                break;
            case 'F':
                letNum1 = 6;
                break;
            case 'G':
                letNum1 = 7;
                break;
            case 'H':
                letNum1 = 8;
                break;
        }
        switch (let2) {
            case 'A':
                letNum2 = 1;
                break;
            case 'B':
                letNum2 = 2;
                break;
            case 'C':
                letNum2 = 3;
                break;
            case 'D':
                letNum2 = 4;
                break;
            case 'E':
                letNum2 = 5;
                break;
            case 'F':
                letNum2 = 6;
                break;
            case 'G':
                letNum2 = 7;
                break;
            case 'H':
                letNum2 = 8;
                break;
        }

        if (letNum1 == -1 || letNum2 == -1 || num1 > 8 || num1 < 1 || num2 > 8 || num2 < 1) {
            out.println("ERROR");
            return;
        }

        if ((letNum1 + 2 == letNum2 || letNum1 - 2 == letNum2) && (num1 + 1 == num2 || num1 - 1 == num2))//horizontal
            out.println("YES");
        else if ((letNum1 + 1 == letNum2 || letNum1 - 1 == letNum2) && (num1 + 2 == num2 || num1 - 2 == num2))//vertical
            out.println("YES");
        else
            out.println("NO");


    }
}


