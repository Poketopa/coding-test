import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0;i<input;i++){
            if(isPrime(Long.parseLong(br.readLine()) * 2 + 1)) count++;
        }
        System.out.print(count);
    }

    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        // 1. n - 1 = 2^s * d (d는 홀수) 형태로 분해
        long d = n - 1;
        int s = 0;
        while (d % 2 == 0) {
            d /= 2;
            s++;
        }

        // 2. 판별을 위한 베이스(witness) 숫자들
        long[] bases = {2, 7, 61};

        for (long a : bases) {
            if (n <= a) break;
            if (!checkMillerRabin(n, a, d, s)) {
                return false; // 하나라도 통과 못 하면 확실한 합성수
            }
        }
        return true; // 모든 테스트를 통과하면 소수
    }

    private static boolean checkMillerRabin(long n, long a, long d, int s) {
        BigInteger bn = BigInteger.valueOf(n);
        BigInteger ba = BigInteger.valueOf(a);
        BigInteger bd = BigInteger.valueOf(d);
        
        BigInteger x = ba.modPow(bd, bn);
        
        if (x.equals(BigInteger.ONE) || x.equals(BigInteger.valueOf(n - 1))) {
            return true;
        }


        for (int r = 1; r < s; r++) {
            x = x.multiply(x).remainder(bn);
            if (x.equals(BigInteger.valueOf(n - 1))) {
                return true;
            }
        }
        return false;
    }
}
