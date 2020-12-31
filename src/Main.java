
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() - 1;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        List<Integer> dividers = new ArrayList<Integer>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                dividers.add(i);
                if (n / i != i) dividers.add(n / i);
            }
        }

        Collections.sort(dividers);

        for (int k = 0; k < dividers.size(); k++) {
            int p = dividers.get(k);

            boolean good = true;
            for(int i=p; i<n; i++){
                if(arr[i]!=arr[i-p]){
                    good = false;
                    break;
                }
            }
            if(good){
                System.out.println(p);
                break;
            }
        }
    }
}