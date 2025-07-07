import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        long[] dp = new long[36];
        dp[0] = 1;
        for(int i=1;i<=35;i++){
            long sum = 0;
            for(int j=0;j< i ;j++){
                sum += dp[j] * dp[i-j-1];
            }
            dp[i] = sum;
        }
        int input = Integer.parseInt(br.readLine());
        System.out.println(dp[input]);
    }
}