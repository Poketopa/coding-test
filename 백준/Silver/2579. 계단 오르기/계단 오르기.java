import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        int[] stair = new int[input];
        for(int i=0;i<input;i++){
            stair[i] = Integer.valueOf(br.readLine());
        }
        int[] dp = new int[input];
        if(dp.length == 1){
            System.out.println(stair[0]);
            return;
        }
        else if(dp.length == 2){
            System.out.println(stair[0] + stair[1]);
            return;
        }
        else if(dp.length == 3){
            System.out.println(Math.max(stair[0]+stair[2], stair[1]+stair[2]));
            return;
        }
        dp[0] = stair[0];
        dp[1] = stair[1] + dp[0];
        dp[2] = Math.max(stair[0]+stair[2], stair[1]+stair[2]);
        // n과 n-1로 생각하기
        for(int i=3;i<dp.length;i++){
            // 큰 경우 생각하기
            // 4로 올라가는 경우 12 4 / 1 34
            // 한칸 전
            int a = stair[i] + stair[i-1] + dp[i-3];
            int b = stair[i] + dp[i-2];
            dp[i] = Math.max(a, b);
        }
        System.out.println(dp[dp.length-1]);
    }
}