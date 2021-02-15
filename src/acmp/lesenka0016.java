package acmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lesenka0016 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        //3-2, 6-4, 7-4
        System.out.println(possible_amount(N+1, N));
    }

    static int possible_amount(int prev, int remainder){
        if(remainder==0) //Значит удалось собрать лесенку
            return 1;

        int res = 0;

        for(int built = 1; built<prev; built++){
            if(remainder-built<0) break;
            res += possible_amount(built, remainder-built);
        }

        return res;
    }

}
