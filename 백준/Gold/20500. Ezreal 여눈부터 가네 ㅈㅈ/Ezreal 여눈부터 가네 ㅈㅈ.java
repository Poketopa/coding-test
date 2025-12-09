import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        // 각 자리수의 합이 3으로 나누어 떨어져야함
        // 뒷자리는 무조건 5

        long[][] dp = new long[input + 1][3];
        // i자릿수에서 합을 3으로 나눈 나머지가 j인 것
        dp[1][0] = 0;
        dp[1][1] = 0;
        dp[1][2] = 1;

        for(int i=2;i<=input;i++){
            dp[i][0] += dp[i-1][2];
            dp[i][1] += dp[i-1][0];
            dp[i][2] += dp[i-1][1];

            dp[i][2] += dp[i-1][0];
            dp[i][0] += dp[i-1][1];
            dp[i][1] += dp[i-1][2];

            dp[i][0] %= 1000000007;
        }
        System.out.println(dp[input][0]);
    }
}
