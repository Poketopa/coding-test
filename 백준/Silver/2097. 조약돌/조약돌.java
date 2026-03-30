import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());

        if (n <= 4) {
            System.out.println(4);
            return;
        }

        long a = (long) Math.sqrt(n);
        
        if (a * a >= n) {
            System.out.println(2 * (a + a - 2));
        } else if (a * (a + 1) >= n) {
            System.out.println(2 * (a + a + 1 - 2));
        } else {
            System.out.println(2 * (a + 1 + a + 1 - 2));
        }
    }
}
