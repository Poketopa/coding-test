import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        long[] dp = new long[input + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=input;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println((dp[input] * 2) + (dp[input] + dp[input-1]) * 2);
    }
}