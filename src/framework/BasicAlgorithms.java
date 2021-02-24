package framework;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.lang.Math.sqrt;

public class BasicAlgorithms {

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


    public static void round(double v){
        v = (double) Math.round(v * 10000000d) / 10000000d;
    }

    public static double intersection_area(int r1, int r2, double d){
        double angle1 = angle_rad_CosTheorem(r1, d, r2);

        double chord_l = cos_theorem_c(r1, r1, 2*angle1); //Можно найти и через r2, angle2

        double segment1 = circle_segment_area(r1, chord_l);
        double segment2 = circle_segment_area(r2, chord_l);

        return segment1 + segment2;
    }

    public static double circle_segment_area(double r, double l){
        double h = Math.sqrt(Math.pow(r, 2) - Math.pow(l/2d, 2));
        double s_tr1 = ( l *  h) / 2d;

        double s_circle = circle_area(r);

        double s_pizza = Math.toDegrees(angle_rad_CosTheorem(r, r, l)) * s_circle/360d;
        return s_pizza - s_tr1;
    }

    public static double circle_area(double r){
        return Math.PI * Math.pow(r, 2);
    }

    public static double cos_theorem_c(int a, int b, double rad){
        return Math.sqrt(Math.pow(a,2) + Math.pow(b,2) - (2d*a*b*Math.cos(rad)) );
    }

    public static double angle_rad_CosTheorem(double a, double b, double c){
        return Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2d * a * b) );
    }

    public static double vector2d_length(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

    public static String decimal2binary(int decimal){
        int n = decimal;
        String binary = "";
        for(; n!=0; n/=2) {
            binary += n % 2;
        }
        return new StringBuilder(binary).reverse().toString();
    }

    public static int binary2decimal(String binary){
        char[] c = binary.toCharArray();
        int r = 0, l = c.length;
        for(int i=0; i<l; i++) {
            r += (c[i] - '0') * Math.pow(2, l - 1 - i);
        }
        return r;
    }
}
