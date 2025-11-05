import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int repeat = Integer.parseInt(br.readLine());
        for(int l = 0;l<repeat;l++){
            int input = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[input];
            for(int i=0;i<input;i++) coins[i] = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(br.readLine());

            int[] dp = new int[target + 1];
            dp[0] = 1;
            for(int coin : coins){
                for(int i=1;i<=target;i++){
                    if(i-coin >= 0)  dp[i] += dp[i - coin];
                }
            }

            System.out.println(dp[target]);
        }
    }
}






