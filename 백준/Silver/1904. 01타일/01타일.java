import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());

        long[][] dp = new long[input + 1][2];

        dp[0][1] = 1;
        dp[1][0] = 1;
        dp[1][1] = 0;

        for(int i=2;i<=input;i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
                dp[i][1] = dp[i-2][0] + dp[i-2][1];
            dp[i][1] %= 15746;
            dp[i][0] %= 15746;
        }

        System.out.print((dp[input][0] + dp[input][1]) % 15746);
    }
}
