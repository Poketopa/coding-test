

import java.io.*;
import java.util.*;

public class Main {
    static int count0 = 0;
    static int count1 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        int[] dp = new int[input + 1];
        if(input == 1){
            System.out.println("1");
            return;
        }
        else if(input == 2){
            System.out.println("3");
            return;
        }
        dp[1] = 1;
        dp[2] = 3;
        for(int i=3;i<=input;i++){
            dp[i] = dp[i-1] + dp[i-2]*2;
            dp[i] %= 10007;
        }
        System.out.println(dp[input]);
    }
}