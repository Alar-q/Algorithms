
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        double r1 = 6d, angle1 = Math.toRadians(60);
        double chord_l = main.cos_theorem_c(r1, r1, 60); //Можно найти и через r2, angle2
        System.out.println(chord_l);
    }

    private double cos_theorem_c(double a, double b, double angle_360){
        return Math.sqrt(Math.pow(a,2) + Math.pow(b,2) - (2d*a*b*Math.cos(Math.toRadians(angle_360))) );
    }
}