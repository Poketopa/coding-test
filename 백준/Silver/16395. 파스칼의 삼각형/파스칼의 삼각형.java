import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int temp = Integer.parseInt(st.nextToken());
        int[][] dp = new int[input + 1][input + 1];
        for(int i=0;i<=input;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=input;i++){
            for(int j=1;j<=i;j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        System.out.println(dp[input-1][temp - 1]);
    }
}