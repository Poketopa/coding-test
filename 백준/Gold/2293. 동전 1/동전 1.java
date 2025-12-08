import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int coin = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] coins = new int[coin];
        for (int i = 0; i < coin; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int i=coin-1;i>=0;i--){
            for(int j=1;j<=target;j++){
                if(j - coins[i] < 0) continue;
                dp[j] += dp[j-coins[i]];
            }
        }

        System.out.print(dp[dp.length-1]);
    }
}
