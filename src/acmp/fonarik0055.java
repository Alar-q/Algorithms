package acmp;


import java.io.PrintWriter;
import java.util.Scanner;

public class fonarik0055 {
    public static void main(String[] args){
        new fonarik0055().run();
    }
    private void run(){
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out){
        final int O_X1 = in.nextInt(), O_Y1 = in.nextInt();
        final int O_X2 = in.nextInt(), O_Y2 = in.nextInt();
        final int r = in.nextInt(); //у кругов одинаковые радиусы
        final long s_main = in.nextInt();

        double d = vector2d_length(O_X1, O_Y1, O_X2, O_Y2);
        double s_additional = circle_area(r);

        boolean better;
        if(r+r <= d) { // Если сумма радиусов меньше или равна дистанции между центрами кругов, значит круги не пересекаются
            better = s_main < s_additional * 2;
        }
        else if(r>=r+d) { //Если один радиус(1) больше суммы радиуса(2) и длины, значит круг(2) полностью лежит в круге(1)
            better = s_main < s_additional;
        }
        else {
            double s_intersection = intersection_area(r, r, d);
            better = s_main < s_additional * 2 - s_intersection;
        }

        if(better)
            out.println("YES");
        else
            out.println("NO");
    }

    private void round(double v){
        v = (double) Math.round(v * 10000000d) / 10000000d;
    }

    private double intersection_area(int r1, int r2, double d){
        double angle1 = angle_rad_CosTheorem(r1, d, r2);

        double chord_l = cos_theorem_c(r1, r1, 2*angle1); //Можно найти и через r2, angle2

        double segment1 = circle_segment_area(r1, chord_l);
        double segment2 = circle_segment_area(r2, chord_l);

        return segment1 + segment2;
    }

    private double circle_segment_area(double r, double l){
        double h = Math.sqrt(Math.pow(r, 2) - Math.pow(l/2d, 2));
        double s_tr1 = ( l *  h) / 2d;

        double s_circle = circle_area(r);

        double s_pizza = Math.toDegrees(angle_rad_CosTheorem(r, r, l)) * s_circle/360d;
        return s_pizza - s_tr1;
    }

    private double circle_area(double r){
        return Math.PI * Math.pow(r, 2);
    }

    private double cos_theorem_c(int a, int b, double rad){
        return Math.sqrt(Math.pow(a,2) + Math.pow(b,2) - (2d*a*b*Math.cos(rad)) );
    }

    private double angle_rad_CosTheorem(double a, double b, double c){
        return Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2d * a * b) );
    }

    private double vector2d_length(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
}
