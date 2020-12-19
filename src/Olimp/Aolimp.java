package Olimp;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*** Задача A. Постоянная Капрекара .
 * Возьмем четырехзначное число, в котором не все цифры одинаковы, например 6264.
 * Расположим цифры сначала в порядке убывания - 6642; затем, переставив их в обратном порядке, получим 2466.
 * Вычтем последнее число из 6642. На следующем шаге с полученной разностью проделаем тоже самое.
 * Через несколько таких действий получится число, переходящее само в себя и называемое постоянной Капрекара.
 * Требуется написать программу, которая находит эту постоянную и количество шагов для ее получения из заданного четырехзначного числа.
 *
 * Технические требования:
 * Входной файл: B.in
 * Выходной файл: B.out
 * Формат входных данных:
 * Входной файл B.in содержит одну строку, в которой записано четырехзначное число.
 * Формат выходных данных:
 * В выходной текстовый файл B.out записываются: в первой строке постоянная Капрекара, во второй – количество шагов для ее получения.
 * Пример файла входных данных:
 * 1234
 * Пример файла выходных данных:
 * 6174
 * 3
 */
public class Aolimp{
    public static void main(String[] args) {
        new Aolimp().run();
    }

    void run() {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    void solve(Scanner in, PrintWriter out) {
        int sum = in.nextInt();
        int numOfIter = 0;
        int prev = -1;
        int leng = 4;

        int[] sumMax = new int[leng];
        Integer[] sumMin = new Integer[leng];

        while (true) {
            sumMax[0] = sum / 1000;
            sumMax[1] = sum / 100 % 10;
            sumMax[2] = sum / 10 % 10;
            sumMax[3] = sum % 10;

            for (int i = 0; i < leng; i++)
                sumMin[i] = sumMax[i];

            Arrays.sort(sumMax);
            Arrays.sort(sumMin, Collections.reverseOrder());


            int grow = sumMax[3] * 1000 + sumMax[2] * 100 + sumMax[1] * 10 + sumMax[0];
            int diminution = sumMin[3] * 1000 + sumMin[2] * 100 + sumMin[1] * 10 + sumMin[0];

            int result = grow - diminution;

            if (result == prev) {
                prev = result;
                break;
            }

            numOfIter++;
            prev = result;
            sum = result;
        }

        out.println(prev);
        out.println(numOfIter);
    }
}


