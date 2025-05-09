import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        int[] dp = new int[input];
        dp[0] = number[0];

        for(int i=1;i<input;i++){
            // 더하면 더 큰 경우
            dp[i] = Math.max(dp[i-1] + number[i], number[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i : dp) max = Math.max(max, i);
        System.out.println(max);
    }
}
