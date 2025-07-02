import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        if(input == 1){
            System.out.println("3");
            return;
        }
        if(input == 2){
            System.out.println("7");
            return;
        }
        int[][] dp = new int[input][3];
        // 0: X X
        // 1: O X
        // 3: X O
        // 0은 이전 경우의 수 모두 가능
        // 1, 2는 이전 경우의 수 두가지 가능
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[1][0] = 3;
        dp[1][1] = 2;
        dp[1][2] = 2;
        for(int i=2;i<input;i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
            dp[i][1] = dp[i-1][0] + dp[i-1][2];
            dp[i][2] = dp[i-1][0] + dp[i-1][1];
            dp[i][0] %= 9901;
            dp[i][1] %= 9901;
            dp[i][2] %= 9901;
        }
        System.out.println((dp[input-1][0] + dp[input-1][1] + dp[input-1][2]) % 9901);
    }
}