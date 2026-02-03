import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        long mod = 1000000007;
        long sum = 0;
        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());

            long result = 1;
            long exp = mod - 2;
            long base = N % mod;

            while(exp > 0){
                if(exp % 2 == 1){
                    result = (result * base) % mod;
                }
                base = (base * base) % mod;
                exp /= 2;
            }

            long currentExpectation = ((S % mod) * result) % mod;
            sum = (sum + currentExpectation) % mod;
        }
        System.out.print(sum);
    }
}
