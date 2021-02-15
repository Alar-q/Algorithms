package framework;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.lang.Math.sqrt;

public class Algorithm {

    public static void selection_sort(int[] arr){
        for(int i=0; i < arr.length; i++) {
            int min_value = arr[i], min_pos = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < min_value) { min_pos = j; min_value = arr[j]; }
            arr[min_pos] = arr[i]; arr[i] = min_value;
        }
    }

    public static int recursive_sum(List<Integer> list){
        if(list.isEmpty()) return 0;
        else return list.remove(0) + recursive_sum(list);
    }

    public static void quick_sort(int[] arr, int leftBorder, int rightBorder) {
        int tmp, leftMarker = leftBorder, rightMarker = rightBorder, pivot = arr[(leftMarker + rightMarker) / 2];
        do {
            //while (arr[leftMarker] < pivot) leftMarker++;//пытаемся найти большее чем середина знечение
            for (; arr[leftMarker] < pivot; leftMarker++) { }
            for (; arr[rightMarker] > pivot; rightMarker--) { }
            //while (arr[rightMarker] > pivot) rightMarker--;//пытаемся найти меньшее чем середина значение
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    tmp = arr[leftMarker];
                    arr[leftMarker] = arr[rightMarker];
                    arr[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker < rightMarker);
        if (leftMarker < rightBorder) quick_sort(arr, leftMarker, rightBorder);
        if (leftBorder < rightMarker) quick_sort(arr, leftBorder, rightMarker);
    }

    public static Set union(Set set1, Set set2){
        set1.addAll(set2);
        return set1;
    }

    public static Set intersect(Set set1, Set set2){
        set1.retainAll(set2);
        return set1;
    }
    public static Set difference(Set set1, Set set2){
        set1.removeAll(set2);
        return set1;
    }

    public static List<Long> dividers(long n){
        List<Long> list = new ArrayList<Long>();
        for (long i = 1; i <= Math.sqrt(n); i++){
            if (n%i == 0){
                list.add(i);
                if (n/i != i) list.add(n/i);
            }
        }
        return list;
    }
    public static List<BigInteger> dividers(BigInteger n){
        List<BigInteger> list = new ArrayList<BigInteger>();
        for (BigInteger i = BigInteger.ONE; i.compareTo(n.sqrt())==-1; i = i.add(BigInteger.ONE)){
            if (n.mod(i).compareTo(BigInteger.ZERO)==0){
                list.add(i);
                BigInteger div = n.divide(i);
                if (div.compareTo(i)!=0) list.add(div);
            }
        }
        return list;
    }

}
