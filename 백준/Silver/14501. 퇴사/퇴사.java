import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] number = new int[input][2];
        int[] dp = new int[input + 1];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            number[i][0] = Integer.parseInt(st.nextToken());
            number[i][1] = Integer.parseInt(st.nextToken());
        }
        int nowMax = 0;
        for(int i=0;i<input;i++){
            int date = number[i][0];
            int money = number[i][1];
            if(dp[i] < nowMax) dp[i] = nowMax;
            if(i + date <= input){
                dp[i + date] = Math.max(dp[i + date], dp[i] + money);
            }

            nowMax = Math.max(nowMax, dp[i]);
        }
        int max = -1;
        for(int i=0;i<=input;i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}