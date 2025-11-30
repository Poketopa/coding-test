import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i+1] = Integer.parseInt(st.nextToken());
        long[][] dp = new long[input + 1][21];
        dp[1][number[1]] = 1;

        for(int i=2;i<=input;i++){
            for(int j=0;j<=20;j++){
                if(j + number[i] <= 20){
                    dp[i][j + number[i]] += dp[i-1][j];
                }
                if(j - number[i] >= 0){
                    dp[i][j - number[i]] += dp[i-1][j];
                }
            }
        }
        System.out.println(dp[input-1][number[input]]);
    }
}
