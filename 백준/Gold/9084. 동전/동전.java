import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int testCast = Integer.parseInt(br.readLine());
        for(int repeat=0;repeat<testCast;repeat++){
            int coin = Integer.parseInt(br.readLine());
            int[] coins = new int[coin];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<coin;i++) coins[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(coins);
            int target = Integer.parseInt(br.readLine());
            int[]dp = new int[target + 1];
            dp[0] = 1;
            for(int j=coin-1;j>=0;j--){
                for(int i=1;i<=target;i++){
                    if(i-coins[j] < 0) continue;
                    dp[i] += dp[i-coins[j]];
                }
            }
            System.out.println(dp[target]);
        }

    }
}
