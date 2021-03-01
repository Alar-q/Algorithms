import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 5)));
    }
}
