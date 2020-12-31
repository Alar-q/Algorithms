package acmp;
import java.util.*;

public class PoleChudes0017 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() - 1; //-1 так как последня = первая

        int[] arr = new int[n]; //числа на барабане
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();


        List<Integer> dividers = new ArrayList<Integer>();//все делители
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                dividers.add(i);
                if (n / i != i)
                    dividers.add(n / i);
            }
        }
        Collections.sort(dividers);//n=12 -> 1, 2, 3, 4 ..

        //проверяем все пары
        f:for (int d: dividers) {
            for(int p=d; p<n; p++)
                if(arr[p-d]!=arr[p])
                    continue f;
            System.out.print(d);
            break;
        }

    }
}