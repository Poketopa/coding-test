import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] num = new int[input];
        for(int i=0;i<input;i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[input];
        // 1일 떄
        if(input == 1){
            System.out.println(num[0]);
            return;
        }
        if(input == 2){
            System.out.println(num[0] + num[1]);
            return;
        }
        if (input == 3) {
            dp[0] = num[0];
            dp[1] = num[0] + num[1];
            dp[2] = Math.max(dp[0] + num[2], num[1] + num[2]);
            System.out.println(Math.max(dp[0], Math.max(dp[1], dp[2])));
            return;
        }
        dp[0] = num[0];
        dp[1] = num[0] + num[1];
        dp[2] = Math.max(dp[1], Math.max(dp[0] + num[2], num[1] + num[2]));
        int max = Math.max(dp[0], Math.max(dp[1], dp[2]));
        for(int i=3;i<input;i++){
            int a = dp[i-1];
            int b = dp[i-2] + num[i];
            int c = dp[i-3] + num[i-1] + num[i];
            dp[i] = Math.max(Math.max(a, b), c);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
