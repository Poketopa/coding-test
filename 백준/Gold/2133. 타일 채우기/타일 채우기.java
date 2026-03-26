import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        if(input < 2){
            System.out.print("0");
            return;
        }

        long[] dp = new long[input + 1];

        dp[2] = 3;
        // 정방향일 시 3배 추가
        for(int i=4;i<=input;i+=2){
            int temp = i-4;
            dp[i] += dp[i-2] * 3 + 2;
            while(temp >= 0){
                dp[i] += dp[temp] * 2;
                temp -= 2;
            }
        }

        System.out.print(dp[input]);
    }
}
