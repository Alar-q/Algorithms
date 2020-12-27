package hackerrangCoding;

import java.io.*;
import java.util.*;

/**
 * Помните, что студент Арман подарил волшебную шляпу преподавателям?
 * Теперь он стал самым любимым студентом в группе! Но если вы думаете,
 * что любимчикам задают только самые простые задачи, то это не всегда правда.
 * Преподаватель по С++ отправил Арману отдельное домашнее задание, которое Арман,
 * к сожалению, не смог выполнить. Помогите Арману не выпасть из списка
 * любимчиков преподавателя, решите задачу. Задание следующее. Cколько
 * существует таких пар (i, j), что 1 <= i<= j <= n, j - i <= a
 *
 * В первой строке записаны два целых положительных числа n и a.
 * 1 <= n <= 1000000, 0 <= a <= 1000000
 *
 * 3 1 - 5
 * 5 4 - 15
 * 10 5 - 45
 */

public class Number_of_pairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();

        System.out.println(countPair(n, a));
    }

    public static long countPair(int n, int a) {
        long res = 0;

        for(int j=1; j<=n; j++)
            res += j - Math.max(j-a, 1) + 1;

        /*solution with Brute force
        for(int j=1; j<=n; j++){
            for(int i=1; i<=j; i++){ //i дойдет до j.
                if(j - i <= a) // i >= j - a - можно сразу понять до куда дойдет i
                    res++;
            }
        }
        */

        return res;
    }
}
