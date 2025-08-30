import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        long[] dp = new long[31];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=30;i++){
            long sum = 0;
            for(int j=0;j<i;j++){
                sum += dp[j] * dp[i-1-j];
            }
            dp[i] = sum;
        }

        while(true){
            int input = Integer.parseInt(br.readLine());
            if(input == 0) return;
            System.out.println(dp[input]);
        }
    }
}
