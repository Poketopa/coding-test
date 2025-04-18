import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        // n / 4 의 나머지를 가져갈 수 있으면 이긴다
        int input = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[input + 1];
        dp[1] = true;
        if(input==1){
            System.out.println(dp[input]?"SK":"CY");
            return;
        }
        dp[2] = false;
        if(input==2){
            System.out.println(dp[input]?"SK":"CY");
            return;
        }
        dp[3] = true;
        if(input==3){
            System.out.println(dp[input]?"SK":"CY");
            return;
        }
        for(int i=4;i<=input;i++){
            if(!dp[i-1] || !dp[i-3]) dp[i] = true;
            else dp[i] = false;
        }
        System.out.println(dp[input]?"SK":"CY");
        return;
    }
}