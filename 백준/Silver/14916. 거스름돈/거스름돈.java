import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] dp = new int[input + 1];
        if(input==1) System.out.print("-1");
        else if(input == 2)System.out.println("1");
        else if(input == 3)System.out.println("-1");
        else if(input == 4)System.out.println("2");
        else if(input == 5)System.out.println("1");
        else{
            dp[2] = 1;
            dp[4] = 2;
            dp[5] = 1;
            for(int i=6;i<=input;i++){
                if(dp[i-2] != 0 && dp[i-5] == 0){
                    dp[i] = dp[i-2] + 1;
                }
                else if(dp[i -2] == 0 && dp[i-5] != 0){
                    dp[i] = dp[i-5] + 1;
                }
                else if(dp[i-2] != 0 && dp[i-1] != 0){
                    dp[i] = Math.min(dp[i-2] + 1, dp[i-5] + 1);
                }
            }
            if(dp[input] == 0) System.out.println("-1");
            else System.out.println(dp[input]);
        }
        
    }
}