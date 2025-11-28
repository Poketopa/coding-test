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

        int[] dp = new int[2001];
        dp[0] = 1;
        for(int i=1;i<=2000;i++){
            for(int j=2000;j>=i;j--){
                dp[j] += dp[j-i];
                dp[j] %= 100999;
            }
        }

        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            int temp = Integer.parseInt(br.readLine());
            System.out.println(dp[temp]);
        }
    }
}
