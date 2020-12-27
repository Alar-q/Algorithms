 import java.io.PrintWriter;

 import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
    static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Set<Integer> set = new HashSet<Integer>();

        for(int i=0; i<n; i++)
            set.add(in.nextInt());

        for(int i: set){
            out.println(i);
        }

        out.println(set.size());
    }

}
