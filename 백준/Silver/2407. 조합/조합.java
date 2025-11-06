import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        String m = st.nextToken();
        int intN = Integer.parseInt(n);
        int intM = Integer.parseInt(m);
        int r = Math.min(intN - intM, intM);
        if (r == 0) {
            System.out.print(1);
            return;
        }

        BigInteger N = new BigInteger(n);
        BigInteger sum1 = new BigInteger("1");
        BigInteger sum2 = new BigInteger("1");

        for (int i = 0; i < r; i++) {
            sum1 = sum1.multiply(N.subtract(new BigInteger(String.valueOf(i))));
        }

        for (int i = r; i >= 1; i--) {
            sum2 = sum2.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.print(sum1.divide(sum2));
    }
}






